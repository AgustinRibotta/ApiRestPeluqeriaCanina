package com.PeluCanina.PeluqueriaCaniana.services.imp;

import com.PeluCanina.PeluqueriaCaniana.entities.Owner;
import com.PeluCanina.PeluqueriaCaniana.repositories.IOwner;
import com.PeluCanina.PeluqueriaCaniana.services.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImp implements IOwnerService {

    @Autowired
    IOwner ownerRepository;

    @Override
    public List<Owner> getOwner() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id).orElse(null) ;
    }

    @Override
    public Owner postOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner putOwner(Owner owner) {
        if(!ownerRepository.existsById(owner.getId())){
            return null;
        }
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        if (!ownerRepository.existsById(id)) {
            return;
        }
        ownerRepository.deleteById(id);
    }

    @Override
    public boolean existsByTelOwner(String telOwner) {

        return ownerRepository.findByTelOwner(telOwner) != null;
    }

}
