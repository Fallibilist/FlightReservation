/**
 * 
 */
package com.cooksys.service;

import org.springframework.stereotype.Service;

import com.cooksys.dto.CredentialsDto;
import com.cooksys.dto.UserSaveDto;
import com.cooksys.entity.UserEntity;
import com.cooksys.entity.embeddable.CredentialsEmbeddable;
import com.cooksys.exception.ErrorType;
import com.cooksys.exception.FlightAppException;
import com.cooksys.mapper.UserMapper;
import com.cooksys.repository.UserJpaRepository;

/**
 * @author Greg Hill
 *
 */
@Service
public class UserService {

	private UserJpaRepository userJpaRepository;
	
	private UserMapper userMapper;
	
	public UserService(UserJpaRepository userJpaRepository, UserMapper userMapper) {
		this.userJpaRepository = userJpaRepository;
		this.userMapper = userMapper;
	}
	
	/**
	 * @param username
	 * @return a user by username
	 * @throws TwitterException 
	 */
	public UserEntity pullUser(String username) {
		return userJpaRepository.findByCredentialsUsername(username);
	}
	
	/**
	 * @param credentials
	 * @throws TwitterException
	 */
	public void login(CredentialsDto credentials) throws FlightAppException {
		UserEntity user = pullUser(credentials.getUsername());
		
		if(user == null) {
			throw new FlightAppException(ErrorType.NOT_FOUND);
		}
		
		if(!user.getCredentials().getPassword().equals(credentials.getPassword())) {
			throw new FlightAppException(ErrorType.NOT_AUTHORIZED);
		}
	}

	/**
	 * @param userSaveDto
	 * @return the created user
	 * @throws TwitterException 
	 */
	public void postUser(UserSaveDto userSaveDto) throws FlightAppException {
		UserEntity user = userMapper.fromDtoSave(userSaveDto);
		CredentialsEmbeddable credentials = user.getCredentials();
		
		if(credentials.getUsername() == null || credentials.getPassword() == null) {
			throw new FlightAppException(ErrorType.NOT_ACCEPTABLE);
		}
		
		if(pullUser(credentials.getUsername()) == null) {
			userJpaRepository.save(user);
		} else {
			throw new FlightAppException(ErrorType.CONFLICT);
		}
	}
}
