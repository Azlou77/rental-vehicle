package com.example.catalogue.controller;

import com.example.catalogue.controller.VehicleController;
import com.example.catalogue.entity.Vehicle;
import com.example.catalogue.service.VehicleService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private VehicleService vehicleService;

	@Test
	void shouldReturnVehicleCatalogWithModel() throws Exception {
		List<Vehicle> mockVehicles = List.of(
				new Vehicle((long) 1, "Mustang", "Ford", "Coupé"),
				new Vehicle((long) 2, "Leaf", "Nissan", "Électrique")
		);

		Mockito.when(vehicleService.getAllVehicles()).thenReturn(mockVehicles);

		mockMvc.perform(get("/vehicles"))
		.andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(2))
        .andExpect(jsonPath("$[0].vehicleModele").value("Mustang"))
        .andExpect(jsonPath("$[1].vehicleModele").value("Leaf"));
	}
	
}
