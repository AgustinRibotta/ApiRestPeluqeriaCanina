package com.PeluCanina.PeluqueriaCaniana.services;

import com.PeluCanina.PeluqueriaCaniana.entities.Owner;

import java.util.List;

public interface IOwnerService {
    List<Owner> getOwner ();
    Owner getOwnerById(Long id);
    Owner postOwner(Owner owner);
    Owner putOwner(Owner owner);
    void  deleteOwner (Long id);
}
