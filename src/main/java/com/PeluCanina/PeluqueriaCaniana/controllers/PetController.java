package com.PeluCanina.PeluqueriaCaniana.controllers;

import com.PeluCanina.PeluqueriaCaniana.DTOs.PetDTO;
import com.PeluCanina.PeluqueriaCaniana.entities.Owner;
import com.PeluCanina.PeluqueriaCaniana.entities.Pet;
import com.PeluCanina.PeluqueriaCaniana.mapper.PetMapper;
import com.PeluCanina.PeluqueriaCaniana.services.IOwnerService;
import com.PeluCanina.PeluqueriaCaniana.services.IPetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final IPetService petService;
    private final PetMapper petMapper;
    private final IOwnerService ownerService;

    public PetController(IPetService petService, PetMapper petMapper, IOwnerService ownerService) {
        this.petService = petService;
        this.petMapper = petMapper;
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<?> getPets() {
        List<Pet> allPet = petService.getPet();

        if (allPet == null || allPet.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT) // 204 No Content
                    .body(Collections.singletonMap("message", "No elements available yet."));
        }

        List<PetDTO> petDTOS = allPet.stream()
                .map(petMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(petDTOS);  // 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPet(@PathVariable Long id) {
        Pet pet = petService.getPetById(id);

        if (pet == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "No pet found with that ID.")); // 404 Not Found
        }

        PetDTO petDTO = petMapper.toDTO(pet);

        return ResponseEntity.ok(petDTO);  // 200 OK
    }

    @PostMapping
    public ResponseEntity<?> postPet(@RequestBody @Validated Pet pet) {
        if (pet.getOneOwner() != null && pet.getOneOwner().getId() != null) {
            Owner owner = ownerService.getOwnerById(pet.getOneOwner().getId());
            if (owner == null) {
                return ResponseEntity.badRequest().body("Owner not found"); // 403 Bad Request
            }
            pet.setOneOwner(owner);
        }

        Pet savePet = petService.postPet(pet);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savePet.getId())
                .toUri();

        PetDTO petDTO = petMapper.toDTO(savePet);

        return ResponseEntity.created(location).body(petDTO);  // 201 CREATE
    }
}
