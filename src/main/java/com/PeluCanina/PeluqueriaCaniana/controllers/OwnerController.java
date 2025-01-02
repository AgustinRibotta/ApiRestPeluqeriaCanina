package com.PeluCanina.PeluqueriaCaniana.controllers;

import com.PeluCanina.PeluqueriaCaniana.entities.Owner;
import com.PeluCanina.PeluqueriaCaniana.services.IOwnerService;
import com.PeluCanina.PeluqueriaCaniana.services.imp.OwnerServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private final IOwnerService ownerServiceImp;

    public OwnerController(OwnerServiceImp ownerServiceImp) {
        this.ownerServiceImp = ownerServiceImp;
    }

    @GetMapping
    public ResponseEntity <List<Owner>> getOwners () {
        List<Owner> owners = ownerServiceImp.getOwner();

        if (owners == null || owners.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOwner (@PathVariable Long id) {
        Owner owner = ownerServiceImp.getOwnerById(id);

        if (owner == null ) {
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(owner);
    }
}
