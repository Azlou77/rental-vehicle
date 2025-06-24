package com.example.catalogue.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.catalogue.entity.Vehicle;
import com.example.catalogue.repository.VehicleRepository;

@Service
public class VehicleService {
	

	    @Autowired
	    private VehicleRepository vehicleRepository;

	    public List<Vehicle> getAllVehicles() {
	        return vehicleRepository.findAll();
	    }

	    public List<Vehicle> getVehiclesByType(String type) {
	        return vehicleRepository.findByType(type);
	    }
	    
	    public Vehicle getVehicleById(Long idVehicle) {
	        return vehicleRepository.findById(idVehicle)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Véhicule introuvable"));
	    }

}


