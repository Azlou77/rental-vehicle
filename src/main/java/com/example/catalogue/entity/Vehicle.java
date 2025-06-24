package com.example.catalogue.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
    
    @Enumerated(EnumType.STRING)
    private Status status;
    private int fiscalHorsepower;
    
    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;

    
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
