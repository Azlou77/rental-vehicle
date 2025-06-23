package com.example.catalogue.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;

	@Pattern(
		    regexp = "^[\\p{Lu}][\\p{Ll}]+$",
		    message = "Doit commencer par une majuscule suivie de lettres minuscules, sans chiffres, espaces ni caractères spéciaux"
		)
	private String firstname;
	
	@Pattern(
		    regexp = "^[\\p{Lu}][\\p{Ll}]+$",
		    message = "Doit commencer par une majuscule suivie de lettres minuscules, sans chiffres, espaces ni caractères spéciaux"
		)
	private String lastname;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	private String address;

	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	private Role role;

	// Constructeur vide
	public User() {
	}

	// Getters & Setters
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	
	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
