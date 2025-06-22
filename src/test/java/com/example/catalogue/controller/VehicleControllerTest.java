package com.example.catalogue.controller;
import com.example.catalogue.entity.Vehicle;
import com.example.catalogue.service.VehicleService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.MediaType;
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
            new Vehicle(1L, "Mustang", "Ford", "Coupé"),
            new Vehicle(2L, "Leaf", "Nissan", "Électrique")
        );

        Mockito.when(vehicleService.getAllVehicles()).thenReturn(mockVehicles);

        MvcResult result = mockMvc.perform(get("/vehicles"))
        	    .andExpect(status().isOk())
        	    .andReturn();

        	String json = result.getResponse().getContentAsString();

        	ObjectMapper mapper = new ObjectMapper();
        	JsonNode jsonNode = mapper.readTree(json);
        	String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        	System.out.println("✅ JSON formaté :\n" + prettyJson);
    }
 
}