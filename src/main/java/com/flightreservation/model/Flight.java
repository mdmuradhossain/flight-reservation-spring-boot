package com.flightreservation.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "flight_number")
	private String flightNumber;

	@Column(name = "airlines_name")
	private String airlinesName;

	@Column(name = "departure_city")
	private String departureCity;

	@Column(name = "arrival_city")
	private String arrivalCity;

	@Column(name = "departure_date")
	private Date dateOfDeparture;

	@Column(name = "departure_time")
	private Timestamp estimatedDepartureTime;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reservation_id", referencedColumnName = "id")
	private Reservation reservation;

	public Flight() {

	}

	public Flight(Long id, String flightNumber, String airlinesName, String departureCity, String arrivalCity,
			Date dateOfDeparture, Timestamp estimatedDepartureTime) {
		this.id = id;
		this.flightNumber = flightNumber;
		this.airlinesName = airlinesName;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.dateOfDeparture = dateOfDeparture;
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirlinesName() {
		return airlinesName;
	}

	public void setAirlinesName(String airlinesName) {
		this.airlinesName = airlinesName;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}

	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airlinesName == null) ? 0 : airlinesName.hashCode());
		result = prime * result + ((arrivalCity == null) ? 0 : arrivalCity.hashCode());
		result = prime * result + ((dateOfDeparture == null) ? 0 : dateOfDeparture.hashCode());
		result = prime * result + ((departureCity == null) ? 0 : departureCity.hashCode());
		result = prime * result + ((estimatedDepartureTime == null) ? 0 : estimatedDepartureTime.hashCode());
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (airlinesName == null) {
			if (other.airlinesName != null)
				return false;
		} else if (!airlinesName.equals(other.airlinesName))
			return false;
		if (arrivalCity == null) {
			if (other.arrivalCity != null)
				return false;
		} else if (!arrivalCity.equals(other.arrivalCity))
			return false;
		if (dateOfDeparture == null) {
			if (other.dateOfDeparture != null)
				return false;
		} else if (!dateOfDeparture.equals(other.dateOfDeparture))
			return false;
		if (departureCity == null) {
			if (other.departureCity != null)
				return false;
		} else if (!departureCity.equals(other.departureCity))
			return false;
		if (estimatedDepartureTime == null) {
			if (other.estimatedDepartureTime != null)
				return false;
		} else if (!estimatedDepartureTime.equals(other.estimatedDepartureTime))
			return false;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", airlinesName=" + airlinesName
				+ ", departureCity=" + departureCity + ", arrivalCity=" + arrivalCity + ", dateOfDeparture="
				+ dateOfDeparture + ", estimatedDepartureTime=" + estimatedDepartureTime + "]";
	}

}
