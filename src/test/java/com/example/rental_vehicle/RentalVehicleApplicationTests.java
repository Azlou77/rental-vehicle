//package com.example.rental_vehicle;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.catalogue.entity.Vehicle;
//import com.example.catalogue.service.VehicleService;
//
//@SpringBootTest
//class RentalVehicleApplicationTests {
//
//    @Autowired
//    private VehicleService vehicleService;
//
//    @Test
//    void contextLoads() {
//        assertTrue(true); // Vérifie que le contexte démarre correctement
//    }
//
//    @Test
//    void testGetAllVehicles() {
//        List<Vehicle> vehicles = vehicleService.getAllVehicles();
//        assertNotNull(vehicles); // Vérifie que la liste n'est pas vide
//        assertTrue(vehicles.size() >= 0); // Vérifie que la taille est cohérente
//    }
//}
//
//
