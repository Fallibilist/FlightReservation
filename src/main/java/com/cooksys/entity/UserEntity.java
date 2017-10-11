/**
 * 
 */
package com.cooksys.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cooksys.entity.embeddable.CredentialsEmbeddable;

/**
 * @author Greg Hill
 *
 */
@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	@Embedded
	private CredentialsEmbeddable credentials;
	
	@OneToMany(mappedBy = "user")
	private List<Trip> trips = new ArrayList<>();

	/**
	 * Default Constructor
	 */
	public UserEntity() { }

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
	 * @return the credentials
	 */
	public CredentialsEmbeddable getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials the credentials to set
	 */
	public void setCredentials(CredentialsEmbeddable credentials) {
		this.credentials = credentials;
	}

	/**
	 * @return the trips
	 */
	public List<Trip> getTrips() {
		return trips;
	}

	/**
	 * @param trips the trips to set
	 */
	public void setTrips(ArrayList<Trip> trips) {
		this.trips = trips;
	}
}
