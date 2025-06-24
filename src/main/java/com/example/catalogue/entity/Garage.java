package com.example.catalogue.entity;

import jakarta.persistence.*;

@Entity
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGarage;

    private String name;
    private String address;
    private int numberVehicle;

    // Constructeurs
    public Garage() {}

    public Garage(String name, String address, int numberVehicle) {
        this.name = name;
        this.address = address;
        this.numberVehicle = numberVehicle;
    }

    // Getters et Setters
    public Long getIdGarage() {
        return idGarage;
    }

    public void setIdGarage(Long idGarage) {
        this.idGarage = idGarage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberVehicle() {
        return numberVehicle;
    }

    public void setNumberVehicle(int numberVehicle) {
        this.numberVehicle = numberVehicle;
    }
}