package com.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flightreservation.dto.ReservationRequest;
import com.flightreservation.model.Flight;
import com.flightreservation.model.Reservation;
import com.flightreservation.repository.FlightRepository;
import com.flightreservation.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@PathVariable("flightId") Long flightId, Model model) {
		Flight flight = flightRepository.findById(flightId).get();
		model.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String comeleteReservation(ReservationRequest request,Model model) {
		Reservation reservation = reservationService.bookFlight(request);
		model.addAttribute("msg","Reservation created successfully and the id is: "+reservation.getId());
		return "reservationConfirmation";
		
	}
}
