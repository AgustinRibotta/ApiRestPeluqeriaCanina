package com.PeluCanina.PeluqueriaCaniana.controllers;

import com.PeluCanina.PeluqueriaCaniana.DTOs.OwnerDTO;
import com.PeluCanina.PeluqueriaCaniana.entities.Owner;
import com.PeluCanina.PeluqueriaCaniana.entities.Pet;
import com.PeluCanina.PeluqueriaCaniana.services.IOwnerService;
import com.PeluCanina.PeluqueriaCaniana.services.imp.OwnerServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final IOwnerService ownerServiceImp;

    public OwnerController(OwnerServiceImp ownerServiceImp) {
        this.ownerServiceImp = ownerServiceImp;
    }

    @GetMapping
    public ResponseEntity<?> getOwners () {
        List<Owner> owners = ownerServiceImp.getOwner();

        if (owners == null || owners.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT) // 204 No Content
                    .body(Collections.singletonMap("message", "No elements available yet."));
        }

        List<OwnerDTO> ownerDTOs = owners.stream()
                .map(owner -> {
                    List<String> petNames = owner.getPets().stream()
                            .map(Pet::getName)
                            .collect(Collectors.toList());

                    return new OwnerDTO(owner.getId(), owner.getName(), owner.getTelOwner(), petNames);
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(ownerDTOs); // 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOwner (@PathVariable Long id) {
        Owner owner = ownerServiceImp.getOwnerById(id);

        if (owner == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .<Object>body(Collections.singletonMap("error", "No owner found with that ID..")); // 404 Not Found
        }

        List <String> petNames = owner.getPets().stream().map(Pet::getName).toList();

        OwnerDTO ownerDTO  = new OwnerDTO(owner.getId(), owner.getName(), owner.getTelOwner(), petNames);

        return ResponseEntity.ok(ownerDTO);  // 200 OK
    }

    @PostMapping
    public ResponseEntity<?> postOwner(@RequestBody @Validated Owner owner) {
        if (ownerServiceImp.existsByTelOwner(owner.getTelOwner())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .<Object>body(Collections.singletonMap("error", "The owner's phone number is already registered.")); // 409 Conflict
        }

        Owner saveOwner = ownerServiceImp.postOwner(owner);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveOwner.getId())
                .toUri();

        List<String> petNames = (owner.getPets() != null && !owner.getPets().isEmpty())
                ? owner.getPets().stream().map(Pet::getName).toList()
                : new ArrayList<>();

        OwnerDTO ownerDTO = new OwnerDTO(owner.getId(), owner.getName(), owner.getTelOwner(), petNames);

        return ResponseEntity.created(location).body(ownerDTO); // 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putOwner (@PathVariable Long id,@RequestBody @Validated  Owner owner) {
        Owner existingOwner = ownerServiceImp.getOwnerById(id);

        if (existingOwner == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .<Object>body(Collections.singletonMap("error", "No owner found with that ID..")); // 404 Not Found
        }

        existingOwner.setName(owner.getName());
        existingOwner.setTelOwner(owner.getTelOwner());

        Owner updatedOwner = ownerServiceImp.putOwner(existingOwner);

        List<String> updatedPetNames = updatedOwner.getPets().stream()
                .map(Pet::getName)
                .collect(Collectors.toList());
        OwnerDTO ownerDTO = new OwnerDTO(updatedOwner.getId(), updatedOwner.getName(), updatedOwner.getTelOwner(), updatedPetNames);

        return ResponseEntity.ok(ownerDTO); // 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOwner (@PathVariable Long id) {
        Owner existingOwner = ownerServiceImp.getOwnerById(id);

        if (existingOwner == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .<Object>body(Collections.singletonMap("error", "No owner found with that ID..")); // 404 Not Found
        }
        ownerServiceImp.deleteOwner(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .<Object>body(Collections.singletonMap("message", "Successfully deleted."));  // 204 No Content

    }

}
