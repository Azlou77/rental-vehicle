package com.example.catalogue.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public  class Vehicle {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	// Attributs
	private Long idVehicle;
	private int registrationNumber;
	private String type;
	private String motorizationType;
    private String brand;
    private String model;
    private int fiscalHorsepower;
    
    
    
    // Constructors
    public Vehicle() {
    }
    
    public Vehicle(Long idVehicle, String modele, String brand, String type) {
    	this.idVehicle = idVehicle;
        this.model = modele;
        this.brand = brand;
        this.type = type;
    }
    

    public Long getIdVehicle() {
            return idVehicle;
    }
    
	// Getters and Setters
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}

	public int getFiscalHorsepower() {
		return fiscalHorsepower;
	}

	public void setFiscalHorsepower(int fiscalHorsepower) {
		this.fiscalHorsepower = fiscalHorsepower;
	}

	public String getMotorizationType() {
		return motorizationType;
	}

	public void setMotorizationType(String motorizationType) {
		this.motorizationType = motorizationType;
	}
	

}
