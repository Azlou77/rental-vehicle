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
	private String vehicleType;
    private String vehicleBrand;
    private String vehicleModele;
    private int vehicleFiscalHorsepower;
    
    
    public Vehicle() {
    }
    public Vehicle(String vehicleModele, String vehicleBrand, String vehicleType) {
        this.vehicleModele = vehicleModele;
        this.vehicleBrand = vehicleBrand;
        this.vehicleType = vehicleType;
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

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}


	public String getVehicleModele() {
		return vehicleModele;
	}


	public void setVehicleModele(String vehicleModele) {
		this.vehicleModele = vehicleModele;
	}

	public int getVehicleFiscalHorsepower() {
		return vehicleFiscalHorsepower;
	}

	public void setVehicleFiscalHorsepower(int vehicleFiscalHorsepower) {
		this.vehicleFiscalHorsepower = vehicleFiscalHorsepower;
	}
	

}
