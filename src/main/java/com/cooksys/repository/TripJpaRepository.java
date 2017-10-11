package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.Trip;

public interface TripJpaRepository extends JpaRepository<Trip, Integer> {

	
}
