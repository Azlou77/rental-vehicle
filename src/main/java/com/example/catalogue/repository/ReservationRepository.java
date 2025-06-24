package com.example.catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.catalogue.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
   
}