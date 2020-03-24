package com.flightreservation.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.model.Flight;
import com.flightreservation.repository.FlightRepository;

@Controller
public class FlightController {

	@Autowired
	private FlightRepository flightRepository;

	@RequestMapping("/showFlightForm")
	public String showFlightCreateForm(Model model) {
		Flight flight = new Flight();
		model.addAttribute("flight", flight);
		return "createFlight";
	}

	@PostMapping("/createFlight")
	public String createFlight(@ModelAttribute("flight") Flight flight) {
		flightRepository.save(flight);
		return "findFlights";
	}

	@RequestMapping("/showFindFlight")
	public String showFindFlight() {
		return "findFlights";
	}

	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam(required = false, name = "from") String from,
			@RequestParam(required = false, name = "to") String to,
			@RequestParam(required = false, name = "dateOfDeparture") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateOfDeparture,
			Model model) {
		List<Flight> flights = flightRepository.findFlights(from, to, dateOfDeparture);

		for (Flight flight : flights) {
			System.out.println(flight);
		}
		model.addAttribute("flights", flights);
		return "displayFlights";
	}
}
