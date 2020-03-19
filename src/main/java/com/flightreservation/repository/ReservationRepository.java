package com.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightreservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
