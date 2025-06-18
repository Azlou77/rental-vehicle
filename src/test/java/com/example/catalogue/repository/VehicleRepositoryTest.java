package com.example.catalogue.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.catalogue.entity.Vehicle;

@ExtendWith(MockitoExtension.class)
class VehicleRepositoryTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @Test
    void findAll_shouldReturnListOfVehicles() {
        System.out.println("Début du test : findAll_shouldReturnListOfVehicles");

        // Arrange – Simuler les données retournées par le repository
        List<Vehicle> mockVehicles = List.of(
            new Vehicle((long) 1, "Tesla", "Tesla", "Electric"),
            new Vehicle((long) 2, "Modele 3", "Yamaha", "Motorbike")
        );

        System.out.println("Mock des données initialisé");

        when(vehicleRepository.findAll()).thenReturn(mockVehicles);

        // Act – Exécuter la méthode sur le mock
        List<Vehicle> result = vehicleRepository.findAll();
        System.out.println("findAll() exécuté");

        // Assert – Vérifier que la liste contient bien 2 éléments
        System.out.println("Validation du nombre d'éléments...");
        assertEquals(2, result.size());
        System.out.println("✅ Nombre d'éléments correct");

        System.out.println("Validation des valeurs...");
        assertEquals("Tesla", result.get(0).getVehicleModele());
        System.out.println("✅ Première valeur correcte");

        // Vérifier que `findAll()` est bien appelé une fois
        verify(vehicleRepository, times(1)).findAll();
        System.out.println("✅ Vérification de l'appel du repository réussie");

        System.out.println("Test terminé avec succès !");
    }
}
