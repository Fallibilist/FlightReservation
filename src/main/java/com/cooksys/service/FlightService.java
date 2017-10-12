package com.cooksys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cooksys.component.FlightGenerator;
import com.cooksys.dto.TripDto;
import com.cooksys.entity.Trip;
import com.cooksys.entity.UserEntity;
import com.cooksys.exception.ErrorType;
import com.cooksys.exception.FlightAppException;
import com.cooksys.mapper.TripMapper;
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

	private TripMapper tripMapper;
	
	public FlightService(FlightGenerator generator, UserJpaRepository userJpaRepository, TripJpaRepository tripJpaRepository, TripMapper tripMapper) {
		this.generator = generator;
		this.userJpaRepository = userJpaRepository;
		this.tripJpaRepository = tripJpaRepository;
		this.tripMapper = tripMapper;
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

	public List<TripDto> getBookedTrips(String username) throws FlightAppException {
		if(username == null) {
			throw new FlightAppException(ErrorType.NOT_FOUND);
		}

		UserEntity user = userJpaRepository.findByCredentialsUsername(username);

		if(user != null && user.getTrips() != null && !user.getTrips().isEmpty()) {
			return tripMapper.toDto(user.getTrips());
		} else {
			return null;
		}
	}

	public void bookTrip(Trip trip, String username) throws FlightAppException {
		if(username == null || trip == null) {
			throw new FlightAppException(ErrorType.NOT_FOUND);
		}
		
		UserEntity user = userJpaRepository.findByCredentialsUsername(username);
		trip.setUser(user);
		tripJpaRepository.save(trip);
	}
	
	//The fixedDelay parameter determines how often a new day is generated as expressed in milliseconds
	@Scheduled(fixedDelay=10000)
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
