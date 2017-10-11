package com.cooksys.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.pojo.Flight;
import com.cooksys.service.FlightService;
import com.cooksys.service.LocationService;

@RestController
@RequestMapping("flights")
@CrossOrigin
public class FlightsController {
	
	LocationService locationService;
	
	FlightService flightService;
	
	public FlightsController(LocationService locationService, FlightService flightService) {
		this.locationService = locationService;
		this.flightService = flightService;
	}
	
	@RequestMapping
	public ArrayList<Flight> getFlightList()
	{
		return flightService.getDailyFlightList();
	}

}
