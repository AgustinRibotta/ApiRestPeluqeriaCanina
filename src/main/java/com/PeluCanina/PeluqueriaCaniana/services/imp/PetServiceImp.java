package com.PeluCanina.PeluqueriaCaniana.services.imp;

import com.PeluCanina.PeluqueriaCaniana.entities.Pet;
import com.PeluCanina.PeluqueriaCaniana.repositories.IPet;
import com.PeluCanina.PeluqueriaCaniana.services.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImp implements IPetService {

    @Autowired
    IPet petRepository;

    @Override
    public List<Pet> getPet() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Pet postPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Pet putPet(Pet pet) {
        if (!petRepository.existsById(pet.getId())) {
            return null;
        }
        return petRepository.save(pet);
    }

    @Override
    public void deletePet(Long id) {
        if (!petRepository.existsById(id)) {
            return;
        }
        petRepository.deleteById(id);
    }
}
