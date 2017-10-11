package com.cooksys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Trip;
import com.cooksys.exception.FlightAppException;
import com.cooksys.pojo.Flight;
import com.cooksys.service.FlightService;
import com.cooksys.service.LocationService;

@RestController
@RequestMapping("/flights/")
@CrossOrigin
public class FlightsController {
	
	LocationService locationService;
	
	FlightService flightService;
	
	public FlightsController(LocationService locationService, FlightService flightService) {
		this.locationService = locationService;
		this.flightService = flightService;
	}
	
	@GetMapping
	public ArrayList<Flight> getFlightList()
	{
		return flightService.getDailyFlightList();
	}
	
	@GetMapping("/trips/")
	public ArrayList<ArrayList<Flight>> getTripList(@RequestParam("origin") String origin, @RequestParam("destination") String destination)
	{
		return flightService.getTripList(origin, destination);
	}
	
	@GetMapping("/trips/{username}")
	public List<Trip> getBookedTrips(@PathVariable String username, HttpServletResponse response)
	{
		try {
			return flightService.getBookedTrips(username);
		} catch (FlightAppException flightAppException) {
			response.setStatus(flightAppException.getResponse());
			return null;
		}
	}
	
	@PostMapping("/trips/{username}")
	public void bookTrip(@RequestBody Trip tripInfo, @PathVariable String username, HttpServletResponse response)
	{
		try {
			flightService.bookTrip(tripInfo, username);
		} catch (FlightAppException flightAppException) {
			response.setStatus(flightAppException.getResponse());
		}
	}
	
}
