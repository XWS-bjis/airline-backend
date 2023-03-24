package com.airlinecompany.service;

import com.airlinecompany.exception.FlightNotFoundException;
import com.airlinecompany.model.Flight;
import com.airlinecompany.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
