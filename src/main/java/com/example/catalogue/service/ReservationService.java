package com.example.catalogue.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.catalogue.entity.Garage;
import com.example.catalogue.entity.Reservation;
import com.example.catalogue.entity.Vehicle;
import com.example.catalogue.repository.GarageRepository;
import com.example.catalogue.repository.ReservationRepository;
import com.example.catalogue.repository.VehicleRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private GarageRepository garageRepository;

    public void createReservation(Long idVehicle, Long idGarage, LocalDate dateBegin, LocalDate dateEnd) {
        Vehicle vehicle = vehicleRepository.findById(idVehicle)
            .orElseThrow(() -> new RuntimeException("Véhicule introuvable"));
        Garage garage = garageRepository.findById(idGarage)
            .orElseThrow(() -> new RuntimeException("Garage introuvable"));

        Reservation reservation = new Reservation();
        reservation.setDateBegin(dateBegin);
        reservation.setDateEnd(dateEnd);
        reservation.setVehicle(vehicle);
        reservation.setGarage(garage);
       

        reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}


