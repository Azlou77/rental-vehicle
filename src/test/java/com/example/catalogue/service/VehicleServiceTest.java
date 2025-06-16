package com.example.catalogue.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.catalogue.entity.Vehicle;
import com.example.catalogue.repository.VehicleRepository;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleService vehicleService;

    @Test
    void shouldAllVehicles() {
        System.out.println("🔹 Début du test : shouldAllVehicles");

        // Arrange – Simulation des données
        Vehicle v1 = new Vehicle("Tesla", "Tesla", "Electric");
        Vehicle v2 = new Vehicle("Yamaha", "Modele 3", "Motorbike");
        when(vehicleRepository.findAll()).thenReturn(List.of(v1, v2));

        // Act – Appel de la méthode du service
        List<Vehicle> vehicles = vehicleService.getAllVehicles();

        // Assert – Vérifications
        assertEquals(2, vehicles.size());
        assertIterableEquals(List.of(v1,v2), vehicles);
        
        
        verify(vehicleRepository, times(1)).findAll();
        System.out.println("✅ Test terminé avec succès !");
    }

    @Test
    void shouldReturnVehiclesByType() {
        System.out.println("🔹 Début du test : shouldReturnVehiclesByType");

        // Arrange – Simulation des données
        Vehicle electricCar = new Vehicle("Tesla", "Tesla", "Electric");
        Vehicle motorbike = new Vehicle("Yamaha", "Modele 3", "Motorbike");
        when(vehicleRepository.findByVehicleType("Electric")).thenReturn(List.of(electricCar));

        // Act – Appel du service
        List<Vehicle> electricVehicles = vehicleService.getVehiclesByType("Electric");

        // Assert – Vérifications
        assertEquals(1, electricVehicles.size());
        assertIterableEquals(List.of(electricCar), electricVehicles);
        

        verify(vehicleRepository, times(1)).findByVehicleType("Electric");
        System.out.println("✅ Test de filtrage réussi !");
    }
    
    
    
    
}
