package com.cooksys.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dto.CredentialsDto;
import com.cooksys.dto.UserSaveDto;
import com.cooksys.exception.FlightAppException;
import com.cooksys.service.UserService;

@RestController
@RequestMapping("/users/")
@CrossOrigin
public class UserController {
	
	private UserService userService;

	/**
	 * Constructor injecting services
	 * @param userService
	 */
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * @param userSaveDto
	 * @param response
	 * @return a copy of the user created by the request
	 */
	@PostMapping("/new/")
	public void postUser(@RequestBody UserSaveDto userSaveDto, HttpServletResponse response) {
		try {
			userService.postUser(userSaveDto);
		} catch (FlightAppException flightAppException) {
			response.setStatus(flightAppException.getResponse());
		}
	}
	
	/**
	 * @param credentials
	 * @param response
	 */
	@PostMapping("/login/")
	public void login(@RequestBody CredentialsDto credentials, HttpServletResponse response) {
		try {
			userService.login(credentials);
		} catch (FlightAppException flightAppException) {
			response.setStatus(flightAppException.getResponse());
		}
	}
	
}
