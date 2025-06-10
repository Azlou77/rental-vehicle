package com.example.catalogue.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.catalogue.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	List<Vehicle> findByVehicleType(String vehicle_type);
	
	

}


