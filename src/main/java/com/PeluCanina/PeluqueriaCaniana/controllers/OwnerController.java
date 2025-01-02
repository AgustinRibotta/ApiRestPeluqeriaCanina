package com.PeluCanina.PeluqueriaCaniana.controllers;

import com.PeluCanina.PeluqueriaCaniana.DTOs.OwnerDTO;
import com.PeluCanina.PeluqueriaCaniana.entities.Owner;
import com.PeluCanina.PeluqueriaCaniana.entities.Pet;
import com.PeluCanina.PeluqueriaCaniana.services.IOwnerService;
import com.PeluCanina.PeluqueriaCaniana.services.imp.OwnerServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final IOwnerService ownerServiceImp;

    public OwnerController(OwnerServiceImp ownerServiceImp) {
        this.ownerServiceImp = ownerServiceImp;
    }

    @GetMapping
    public ResponseEntity<List<OwnerDTO>> getOwners () {
        List<Owner> owners = ownerServiceImp.getOwner();

        if (owners == null || owners.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<OwnerDTO> ownerDTOs = owners.stream()
                .map(owner -> {
                    List<String> petNames = owner.getPets().stream()
                            .map(Pet::getName)
                            .collect(Collectors.toList());

                    return new OwnerDTO(owner.getId(), owner.getName(), owner.getTelOwner(), petNames);
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(ownerDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOwner (@PathVariable Long id) {
        Owner owner = ownerServiceImp.getOwnerById(id);

        if (owner == null ) {
            return  ResponseEntity.notFound().build();
        }

        List <String> petNames = owner.getPets().stream().map(Pet::getName).toList();

        OwnerDTO ownerDTO  = new OwnerDTO(owner.getId(), owner.getName(), owner.getTelOwner(), petNames);

        return ResponseEntity.ok(ownerDTO);
    }

    @PostMapping
    public ResponseEntity<?> postOwner(@RequestBody @Validated Owner owner) {
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

        return ResponseEntity.created(location).body(ownerDTO);
    }
}
