package com.example.catalogue.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.catalogue.entity.Vehicle;
import com.example.catalogue.repository.VehicleRepository;

@Service
public class VehicleService {

	    @Autowired
	    private VehicleRepository vehicleRepository;

	    public List<Vehicle> getAllVehicles() {
	        return vehicleRepository.findAll();
	    }

	    public List<Vehicle> getVehiclesByType(String vehicle_type) {
	        return vehicleRepository.findByVehicleType(vehicle_type);
	    }
}


