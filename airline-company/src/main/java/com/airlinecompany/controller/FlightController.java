package com.airlinecompany.controller;

import com.airlinecompany.converters.EnumConverter;
import com.airlinecompany.converters.FlightConverter;
import com.airlinecompany.dto.FlightDTO;
import com.airlinecompany.dto.FlightFilterDTO;
import com.airlinecompany.model.Flight;
import com.airlinecompany.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flight")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {


    private FlightService flightService;
    private final FlightConverter flightConverter;
    private final EnumConverter enumConverter;
    @Autowired
    public FlightController(EnumConverter enumConverter, FlightService service, FlightConverter flightConverter) {
        this.flightService = service;
        this.flightConverter = flightConverter;
        this.enumConverter = enumConverter;
    }
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Flight> create(@RequestBody Flight flight){
        Flight newFlight = flightService.create(flight);
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        flightService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Flight>> getAllFlights(){
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Flight> findById(@PathVariable("id") String id){
        Flight flight = flightService.findById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<FlightDTO>> search(@RequestBody FlightFilterDTO request) throws ParseException {
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(formatter1.parse(request.getSearchDate()));
        System.out.println(request.getSearchDate());

        List<Flight> searchedData = flightService.filter(formatter1.parse(request.getSearchDate()), enumConverter.stringToDestination(request.getLandingPlace()), enumConverter.stringToDestination(request.getDeparturePlace()), request.getPassengers());
        if(searchedData != null) {
            List<FlightDTO> dtos = searchedData.stream().map(flightConverter::entityToDto).toList();
            return ResponseEntity.ok(dtos);
        } else {
            return ResponseEntity.ok(new ArrayList<FlightDTO>());
        }
    }
}
