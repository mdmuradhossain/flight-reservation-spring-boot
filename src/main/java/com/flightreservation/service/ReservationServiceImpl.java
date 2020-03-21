package com.flightreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.dto.ReservationRequest;
import com.flightreservation.model.Flight;
import com.flightreservation.model.Passenger;
import com.flightreservation.model.Reservation;
import com.flightreservation.repository.FlightRepository;
import com.flightreservation.repository.PassengerRepository;
import com.flightreservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());

		Passenger savePassenger = passengerRepository.save(passenger);
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savePassenger);
		reservation.setCheckedIn(false);
		Reservation saveReservation = reservationRepository.save(reservation);
		return saveReservation;
	}

}
