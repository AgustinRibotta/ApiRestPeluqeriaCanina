package com.PeluCanina.PeluqueriaCaniana.DTOs;

public class PetDTO {
    private Long id;
    private String name;
    private String race;
    private String color;
    private String alergicTo;
    private String specialAttention;
    private String observations;
    private OwnerDTO owner;

    public PetDTO() {
    }

    public PetDTO(Long id, String name, String race, String color, String alergicTo, String specialAttention, String observations, OwnerDTO owner) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.color = color;
        this.alergicTo = alergicTo;
        this.specialAttention = specialAttention;
        this.observations = observations;
        this.owner = owner;
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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlergicTo() {
        return alergicTo;
    }

    public void setAlergicTo(String alergicTo) {
        this.alergicTo = alergicTo;
    }

    public String getSpecialAttention() {
        return specialAttention;
    }

    public void setSpecialAttention(String specialAttention) {
        this.specialAttention = specialAttention;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }
}
