package com.cooksys.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cooksys.dto.TripDto;
import com.cooksys.entity.Trip;

@Mapper(componentModel="spring")
public interface TripMapper {

	@Mapping(source = "user.credentials.username", target = "username")
	TripDto toDto(Trip trip);
	
	List<TripDto> toDto(List<Trip> trip);
	
}