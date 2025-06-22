package com.example.catalogue.controller;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.catalogue.service.VehicleService;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
	
	    @Autowired
	    private VehicleService vehicleService;

	    @GetMapping
	    public String showVehicles(Model model) {
	        model.addAttribute("vehicles", vehicleService.getAllVehicles());
	        return "vehicle_catalog";
	    }
	    
	    @GetMapping("/{idVehicle}")
	    public String showOneVehicle(@PathVariable Long idVehicle, Model model) {
	        model.addAttribute("vehicle", vehicleService.getVehicleById(idVehicle));
	        return "vehicle_catalog_details";
	    }
}