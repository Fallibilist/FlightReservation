/**
 * 
 */
package com.cooksys.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
