package com.PeluCanina.PeluqueriaCaniana.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "tel_owner")
    private  String telOwner;

    @OneToMany(mappedBy = "oneOwner")
    private List<Pet> pets;D

    public Owner() {
    }

    public Owner(Long id, String name, String telOwner, List<Pet> pets) {
        this.id = id;
        this.name = name;
        this.telOwner = telOwner;
        this.pets = pets;
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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
