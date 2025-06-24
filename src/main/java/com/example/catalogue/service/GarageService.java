package com.example.catalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.catalogue.entity.Garage;
import com.example.catalogue.repository.GarageRepository;

@Service
public class GarageService {

    @Autowired
    private GarageRepository garageRepository;

    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    public Garage getGarageById(Long idGarage) {
        return garageRepository.findById(idGarage)
            .orElseThrow(() -> new RuntimeException("Garage introuvable"));
    }
}
