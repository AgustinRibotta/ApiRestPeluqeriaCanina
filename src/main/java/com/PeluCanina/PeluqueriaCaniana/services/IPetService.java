package com.PeluCanina.PeluqueriaCaniana.services;

import com.PeluCanina.PeluqueriaCaniana.entities.Pet;

import java.util.List;

public interface IPetService {
     List<Pet> getPet ();
     Pet getPetById(Long id);
     Pet postPet(Pet pet);
     Pet putPet(Pet pet);
     void  deletePet (Long id);
}
