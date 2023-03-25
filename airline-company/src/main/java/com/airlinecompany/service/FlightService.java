package com.airlinecompany.service;

import com.airlinecompany.exception.FlightNotFoundException;
import com.airlinecompany.model.Destination;
import com.airlinecompany.model.Flight;
import com.airlinecompany.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight create(Flight flight){
        return flightRepository.save(flight);
    }

    public void delete(String id){
        flightRepository.deleteById(id);
    }

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Flight findById(String id){
        return flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException("Flight by id"+id+"was not found"));
    }

    public List<Flight> filter(Date searchDate, Destination landingPlace, Destination departurePlace, int passengers) throws ParseException {
        Date searchDateStart = new Date(searchDate.getTime() - 1 * 24 * 60 * 60 * 1000);
        searchDateStart.setHours(23);
        searchDateStart.setMinutes(59);
        searchDateStart.setSeconds(59);
        Date searchDateEnd = new Date(searchDate.getTime() + 1 * 24 * 60 * 60 * 1000);
        searchDateEnd.setHours(0);
        searchDateEnd.setMinutes(0);
        searchDateEnd.setSeconds(0);
        return this.flightRepository.findAllByTakeOfDateBetweenAndLandingPlaceAndDeparturePlaceAndAvailableSeatsNumberGreaterThanEqual(searchDateStart, searchDateEnd, landingPlace, departurePlace, passengers);
    }
}
