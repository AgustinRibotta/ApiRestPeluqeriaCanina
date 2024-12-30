package com.PeluCanina.PeluqueriaCaniana.services.imp;

import com.PeluCanina.PeluqueriaCaniana.entities.Owner;
import com.PeluCanina.PeluqueriaCaniana.services.IOwnerService;

import java.util.List;

public class OwnerServiceImp implements IOwnerService {

    @Override
    public List<Owner> getOwner() {
        return List.of();
    }

    @Override
    public Owner getOwnerById(Long id) {
        return ;
    }

    @Override
    public Owner postOwner(Owner owner) {
        return null;
    }

    @Override
    public Owner putOwner(Owner owner) {
        return null;
    }

    @Override
    public void deleteOwner(Long id) {

    }
}
