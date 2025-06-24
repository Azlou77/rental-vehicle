package com.example.catalogue.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.catalogue.entity.Garage;
import com.example.catalogue.entity.Vehicle;
import com.example.catalogue.service.GarageService;
import com.example.catalogue.service.ReservationService;
import com.example.catalogue.service.VehicleService;


@Controller
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	private GarageService garageService;
	

    @Autowired
    private VehicleService vehicleService;
    
    @Autowired
    private ReservationService reservationService;

	@GetMapping("/new")
	public String showReservationForm(@RequestParam Long idVehicle, Model model) {
	    Vehicle vehicle = vehicleService.getVehicleById(idVehicle);
	    List<Garage> garages = garageService.getAllGarages();

	    model.addAttribute("vehicle", vehicle);
	    model.addAttribute("garages", garages);

	    return "reservation_form";
	}
	
	@PostMapping("/save")
	public String saveReservation(@RequestParam Long idVehicle, @RequestParam Long idGarage,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateBegin,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnd,
			RedirectAttributes redirectAttributes) {

		reservationService.createReservation(idVehicle, idGarage, dateBegin, dateEnd);
		redirectAttributes.addFlashAttribute("success", "Réservation confirmée chez le garage choisi");

		return "redirect:/vehicles";
	}



}

