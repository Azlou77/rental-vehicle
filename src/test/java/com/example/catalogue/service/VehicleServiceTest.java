package com.example.catalogue.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

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
        Vehicle v1 = new Vehicle((long) 1, "Tesla", "Tesla", "Electric");
        Vehicle v2 = new Vehicle((long) 2, "Yamaha", "Modele 3", "Motorbike");
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
        Vehicle electricCar = new Vehicle((long) 1,"Tesla", "Tesla", "Electric");
        Vehicle motorbike = new Vehicle((long) 2,"Yamaha", "Modele 3", "Motorbike");
        when(vehicleRepository.findByType("Electric")).thenReturn(List.of(electricCar));

        // Act – Appel du service
        List<Vehicle> electricVehicles = vehicleService.getVehiclesByType("Electric");

        // Assert – Vérifications
        assertEquals(1, electricVehicles.size());
        assertIterableEquals(List.of(electricCar), electricVehicles);
        

        verify(vehicleRepository, times(1)).findByType("Electric");
        System.out.println("✅ Test de filtrage réussi !");
    }
    
    @Test
    void shouldReturnVehicleById() {
        System.out.println("🔹 Début du test : shouldReturnVehicleById");

        // Arrange – Simulation des données
        Vehicle firstVehicle = new Vehicle((long) 1, "Tesla", "Tesla", "Electric");
        when(vehicleRepository.findById((long) 1L)).thenReturn(Optional.of(firstVehicle));

        // Act – Appel du service
        Vehicle retrievedVehicle = vehicleService.getVehicleById(1L);

        // Assert – Vérifications
        assertEquals(firstVehicle, retrievedVehicle);

        // Vérifier que la méthode du repository a été appelée une fois
        verify(vehicleRepository, times(1)).findById((long) 1L);

        System.out.println("✅ Test terminé avec succès !");
    }

    	
}
