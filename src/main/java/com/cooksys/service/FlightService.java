package com.cooksys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cooksys.component.FlightGenerator;
import com.cooksys.entity.Trip;
import com.cooksys.entity.UserEntity;
import com.cooksys.exception.ErrorType;
import com.cooksys.exception.FlightAppException;
import com.cooksys.pojo.Flight;
import com.cooksys.repository.TripJpaRepository;
import com.cooksys.repository.UserJpaRepository;

@Service
public class FlightService {

	private FlightGenerator generator;

	private TripJpaRepository tripJpaRepository;

	private UserJpaRepository userJpaRepository;

	private ArrayList<Flight> flightList = new ArrayList<>();
	
	private ArrayList<ArrayList<Flight>> tripList = new ArrayList<>();
	
	private String origin;
	
	private String destination;
	
	public FlightService(FlightGenerator generator, UserJpaRepository userJpaRepository, TripJpaRepository tripJpaRepository) {
		this.generator = generator;
		this.userJpaRepository = userJpaRepository;
		this.tripJpaRepository = tripJpaRepository;
	}
	
	public ArrayList<Flight> getDailyFlightList()
	{
		return flightList;
	}

	public ArrayList<ArrayList<Flight>> getTripList(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
		
		refreshTrips();
		
		return tripList;
	}

	public List<Trip> getBookedTrips(String username) throws FlightAppException {
		if(username == null) {
			throw new FlightAppException(ErrorType.NOT_FOUND);
		}

		UserEntity user = userJpaRepository.findByCredentialsUsername(username);
		return user.getTrips();
	}

	public void bookTrip(Trip trip, String username) throws FlightAppException {
		if(username == null || trip == null) {
			throw new FlightAppException(ErrorType.NOT_FOUND);
		}
		
		UserEntity user = userJpaRepository.findByCredentialsUsername(username);
		tripJpaRepository.save(trip);
		user.getTrips().add(trip);
		userJpaRepository.save(user);
	}
	
	//The fixedDelay parameter determines how often a new day is generated as expressed in milliseconds
	@Scheduled(fixedDelay=50000)
	private void refreshFlights()
	{
		flightList = generator.generateNewFlightList();
		refreshTrips();
	}
	
	private void refreshTrips()
	{
		tripList = generator.generateNewTripList(origin, destination, flightList);
	}
	
}
