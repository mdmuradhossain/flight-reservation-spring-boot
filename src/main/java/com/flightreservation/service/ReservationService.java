package com.flightreservation.service;

import com.flightreservation.dto.ReservationRequest;
import com.flightreservation.model.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
