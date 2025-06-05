package com.example.catalogue.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class Vehicle {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	// Attributs
	private Long idVehicle;
	private int registrationNumber;
	private String vehicle_type;
    private String vehicle_brand;
    private String vehicle_modele;
    private int vehicle_fiscalHorsepower;
    
    
    // Getters and Setters
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public String getVehicle_brand() {
		return vehicle_brand;
	}
	public void setVehicle_brand(String vehicle_brand) {
		this.vehicle_brand = vehicle_brand;
	}
	public String getVehicle_modele() {
		return vehicle_modele;
	}
	public void setVehicle_modele(String vehicle_modele) {
		this.vehicle_modele = vehicle_modele;
	}
	public int getVehicle_fiscalHorsepower() {
		return vehicle_fiscalHorsepower;
	}
	public void setVehicle_fiscalHorsepower(int vehicle_fiscalHorsepower) {
		this.vehicle_fiscalHorsepower = vehicle_fiscalHorsepower;
	}

}
