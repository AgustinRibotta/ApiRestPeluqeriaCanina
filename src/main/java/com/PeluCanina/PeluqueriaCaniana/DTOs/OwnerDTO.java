package com.PeluCanina.PeluqueriaCaniana.DTOs;

import java.util.List;

public class OwnerDTO {

    private Long id;
    private String name;
    private String telOwner;

    private List<String> petNames;

    public OwnerDTO() {

    }

    public OwnerDTO(Long id, String name, String telOwner, List<String> petNames) {
        this.id = id;
        this.name = name;
        this.telOwner = telOwner;
        this.petNames = petNames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelOwner() {
        return telOwner;
    }

    public void setTelOwner(String telOwner) {
        this.telOwner = telOwner;
    }

    public List<String> getPetNames() {
        return petNames;
    }

    public void setPetNames(List<String> petNames) {
        this.petNames = petNames;
    }


}
