package com.airlinecompany.repository;

import com.airlinecompany.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FlightRepository extends MongoRepository<Flight, String> {
}
