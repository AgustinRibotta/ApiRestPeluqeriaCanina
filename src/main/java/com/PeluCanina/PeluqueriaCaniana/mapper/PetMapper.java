package com.PeluCanina.PeluqueriaCaniana.mapper;

import com.PeluCanina.PeluqueriaCaniana.DTOs.OwnerDTO;
import com.PeluCanina.PeluqueriaCaniana.DTOs.PetDTO;
import com.PeluCanina.PeluqueriaCaniana.entities.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    public PetDTO toDTO(Pet pet) {
        PetDTO dto = new PetDTO();
        dto.setId(pet.getId());
        dto.setName(pet.getName());
        dto.setRace(pet.getRace());
        dto.setColor(pet.getColor());
        dto.setAlergicTo(pet.getAlergicTo());
        dto.setSpecialAttention(pet.getSpecialAttention());
        dto.setObservations(pet.getObservations());

        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(pet.getOneOwner().getId());
        ownerDTO.setName(pet.getOneOwner().getName());
        ownerDTO.setTelOwner(pet.getOneOwner().getTelOwner());
        dto.setOwner(ownerDTO);

        return dto;
    }

}
