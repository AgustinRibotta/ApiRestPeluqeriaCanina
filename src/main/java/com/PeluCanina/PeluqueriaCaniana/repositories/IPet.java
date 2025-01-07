package com.PeluCanina.PeluqueriaCaniana.repositories;

import com.PeluCanina.PeluqueriaCaniana.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPet extends JpaRepository<Pet, Long> {
    Pet findByName(String name);
}
