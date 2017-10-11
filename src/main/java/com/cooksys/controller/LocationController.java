package com.cooksys.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Location;
import com.cooksys.service.LocationService;

@RestController
@RequestMapping("location")
@CrossOrigin
public class LocationController {
	
	private LocationService locationService;

	/**
	 * Constructor
	 * @param locationService
	 */
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}

	@GetMapping
	public List<Location> get() {
		return locationService.getAll();
	}

	@GetMapping("/{id}")
	public Location get(@PathVariable("id") long id) {
		return locationService.get(id);
	}
	
	@GetMapping("/name")
	public Location get(@RequestParam("name") String cityName)
	{
		return locationService.get(cityName);
	}

}
