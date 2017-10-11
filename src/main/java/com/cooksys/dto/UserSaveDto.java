/**
 * 
 */
package com.cooksys.dto;

import com.cooksys.dto.CredentialsDto;

/**
 * @author Greg Hill
 *
 */
public class UserSaveDto {

	private CredentialsDto credentials;
	
	/**
	 * Default Constructor
	 */
	public UserSaveDto() { }

	/**
	 * @param credentials
	 * @param profile
	 */
	public UserSaveDto(CredentialsDto credentials) {
		this();
		this.credentials = credentials;
	}

	/**
	 * @return the credentials
	 */
	public CredentialsDto getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials the credentials to set
	 */
	public void setCredentials(CredentialsDto credentials) {
		this.credentials = credentials;
	}
	
}
