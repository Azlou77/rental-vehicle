package com.example.catalogue.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	// Attributs
	private String permissions;

	
	public String getAddress() {
		return permissions;
	}
	public void setAddress(String permissions) {
		this.permissions = permissions;
	}
	

}
