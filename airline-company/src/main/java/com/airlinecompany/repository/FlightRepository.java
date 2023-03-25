package com.airlinecompany.repository;

import com.airlinecompany.model.Destination;
import com.airlinecompany.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;


public interface FlightRepository extends MongoRepository<Flight, String> {
    List<Flight> findAllByTakeOfDateBetweenAndLandingPlaceAndDeparturePlaceAndAvailableSeatsNumberGreaterThanEqual(Date searchDateStart, Date searchDateEnd, Destination landingPlace, Destination departurePlace, int availableSeatsNumber);
}
