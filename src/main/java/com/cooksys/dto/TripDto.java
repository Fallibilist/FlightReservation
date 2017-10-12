package com.cooksys.dto;

import java.util.ArrayList;
import java.util.List;

public class TripDto {

	private List<String> origins = new ArrayList<>();
	
	private List<String> destinations = new ArrayList<>();

	private List<Long> flightTimes = new ArrayList<>();

	private List<Long> layoverTimes = new ArrayList<>();
	
	private String username;

	/**
	 * Constructor
	 */
	public TripDto() {
	}

	/**
	 * @return the origins
	 */
	public List<String> getOrigins() {
		return origins;
	}

	/**
	 * @param origins the origins to set
	 */
	public void setOrigins(List<String> origins) {
		this.origins = origins;
	}

	/**
	 * @return the destinations
	 */
	public List<String> getDestinations() {
		return destinations;
	}

	/**
	 * @param destinations the destinations to set
	 */
	public void setDestinations(List<String> destinations) {
		this.destinations = destinations;
	}

	/**
	 * @return the flightTimes
	 */
	public List<Long> getFlightTimes() {
		return flightTimes;
	}

	/**
	 * @param flightTimes the flightTimes to set
	 */
	public void setFlightTimes(List<Long> flightTimes) {
		this.flightTimes = flightTimes;
	}

	/**
	 * @return the layoverTimes
	 */
	public List<Long> getLayoverTimes() {
		return layoverTimes;
	}

	/**
	 * @param layoverTimes the layoverTimes to set
	 */
	public void setLayoverTimes(List<Long> layoverTimes) {
		this.layoverTimes = layoverTimes;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
}
