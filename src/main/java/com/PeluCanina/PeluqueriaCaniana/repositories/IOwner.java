package com.PeluCanina.PeluqueriaCaniana.repositories;

import com.PeluCanina.PeluqueriaCaniana.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwner extends JpaRepository<Owner, Long> {
    Owner findByName(String name);
}
