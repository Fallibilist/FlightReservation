package com.cooksys.component;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.cooksys.pojo.Cities;
import com.cooksys.pojo.Flight;

@Component
public class FlightGenerator {

	public ArrayList<Flight> generateNewFlightList() {
		
		ArrayList<Flight> result = new ArrayList<>();

		for (int i = 0; i < 5; i++) {

			int originIndex = ThreadLocalRandom.current().nextInt(0, 4);

			int destinationIndex = ThreadLocalRandom.current().nextInt(0, 4);

			while (destinationIndex == originIndex)
				destinationIndex = ThreadLocalRandom.current().nextInt(0, 4);

			String origin = Cities.values()[originIndex].getName();
			String destination = Cities.values()[destinationIndex].getName();
			int flightTime = ThreadLocalRandom.current().nextInt(1, 4);
			int offset = ThreadLocalRandom.current().nextInt(0, 10);

			Flight f = new Flight(origin, destination, flightTime, offset);

			result.add(f);
		}
		return result;
	}

	public ArrayList<ArrayList<Flight>> generateNewTripList(String origin, String destination,  ArrayList<Flight> flightList) {
		
		if(origin == null || destination == null) {
			return null;
		}
		
		ArrayList<ArrayList<Flight>> result = new ArrayList<>();

//		Trip tripBuilder = new Trip();
//		tripBuilder.getOrigins().add(flight.getOrigin());
//		tripBuilder.getDestinations().add(flight.getDestination());
//		tripBuilder.getFlightTimes().add(flight.getFlightTime());
		
		flightList.forEach((flight) -> {
			if(flight.getOrigin().equals(origin)) {
				if(flight.getDestination().equals(destination)) {
					ArrayList<Flight> tripBuilder = new ArrayList<>();
					tripBuilder.add(flight);
					result.add(tripBuilder);
				} else {
					flightList.forEach((secondFlight) -> {
						if(secondFlight.getOffset() > flight.getOffset()
								&& secondFlight.getOrigin().equals(flight.getDestination())) {
							if(secondFlight.getDestination().equals(destination)) {
								ArrayList<Flight> tripBuilder = new ArrayList<>();
								tripBuilder.add(flight);
								tripBuilder.add(secondFlight);
								result.add(tripBuilder);
							} else {
								flightList.forEach((thirdFlight) -> {
									if(thirdFlight.getOffset() > secondFlight.getOffset()
											&& thirdFlight.getOrigin().equals(secondFlight.getDestination())
											&& !thirdFlight.getOrigin().equals(flight.getOrigin())) {
										if(thirdFlight.getDestination().equals(destination)) {
											ArrayList<Flight> tripBuilder = new ArrayList<>();
											tripBuilder.add(flight);
											tripBuilder.add(secondFlight);
											tripBuilder.add(thirdFlight);
											result.add(tripBuilder);
										}
									}
								});
							}
						}
					});
				}
			}
		});
		
		return result;
		 
	}

}
