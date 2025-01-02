package com.PeluCanina.PeluqueriaCaniana.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "race")
    private String race;

    @Column(name = "color")
    private String color;

    @Column(name = "alergic_to", nullable = false)
    private String alergicTo;

    @Column(name = "special_attention")
    private String specialAttention;

    @Column(name = "observations")
    private String observations;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner oneOwner;

    @Version
    private Long version;

    public Pet() {
    }

    public Pet(Long id, String name, String race, String color, String alergicTo, String specialAttention, String observations, Owner oneOwner) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.color = color;
        this.alergicTo = alergicTo;
        this.specialAttention = specialAttention;
        this.observations = observations;
        this.oneOwner = oneOwner;
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

    public Owner getOneOwner() {
        return oneOwner;
    }

    public void setOneOwner(Owner oneOwner) {
        this.oneOwner = oneOwner;
    }
}
