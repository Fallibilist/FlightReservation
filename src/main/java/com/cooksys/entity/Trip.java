package com.cooksys.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trip {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ElementCollection
	private List<String> origins = new ArrayList<>();
	
	@ElementCollection
	private List<String> destinations = new ArrayList<>();

	@ElementCollection
	private List<Long> flightTimes = new ArrayList<>();

	@ElementCollection
	private List<Long> layoverTimes = new ArrayList<>();
	
	@ManyToOne
	private UserEntity user;

	/**
	 * Constructor
	 */
	public Trip() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	public void setOrigins(ArrayList<String> origins) {
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
	public void setDestinations(ArrayList<String> destinations) {
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
	public void setFlightTimes(ArrayList<Long> flightTimes) {
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
	public void setLayoverTimes(ArrayList<Long> layoverTimes) {
		this.layoverTimes = layoverTimes;
	}

	/**
	 * @return the user
	 */
	public UserEntity getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
