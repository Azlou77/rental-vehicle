package com.example.catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.catalogue.entity.Garage;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Long> {
   
}