package com.flightreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightreservation.model.Flight;
import com.flightreservation.repository.FlightRepository;

@SpringBootTest
class FlightReservationApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	private FlightRepository flightRepository;

	public void testFindFlights() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Date date = formatter.parse("18/03/2020");

		List<Flight> flights = flightRepository.findFlights("DAL", "NYC", date);
		for (Flight flight : flights) {
			System.out.println(flight);
		}
	}
}
