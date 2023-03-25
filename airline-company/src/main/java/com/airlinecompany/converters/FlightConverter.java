package com.airlinecompany.converters;

import com.airlinecompany.dto.FlightDTO;
import com.airlinecompany.model.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Service
public class FlightConverter implements Converter<Flight, FlightDTO>{
    private final EnumConverter enumConverter;
    public FlightConverter(EnumConverter enumConverter) {
        this.enumConverter = enumConverter;
    }

    @Override
    public FlightDTO entityToDto(Flight flight) {
        return FlightDTO.builder()
                .id(flight.getId())
                .takeOfDate(flight.getTakeOfDate().toString())
                .landingDate(flight.getLandingDate().toString())
                .landingPlace(flight.getLandingPlace().toString())
                .departurePlace(flight.getDeparturePlace().toString())
                .ticketPrice(flight.getTicketPrice())
                .availableSeatsNumber(flight.getAvailableSeatsNumber())
                .build();
    }

    @Override
    public Flight dtoToEntity(FlightDTO flightDTO) {
        String str = "1986-04-08 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return Flight.builder()
                .id(flightDTO.getId())
                .takeOfDate(LocalDateTime.parse(flightDTO.getTakeOfDate(), formatter))
                .landingDate(LocalDateTime.parse(flightDTO.getLandingDate(), formatter))
                .landingPlace(enumConverter.stringToDestination(flightDTO.getLandingPlace()))
                .departurePlace(enumConverter.stringToDestination(flightDTO.getDeparturePlace()))
                .ticketPrice(flightDTO.getTicketPrice())
                .totalSeatsNumber(flightDTO.getTotalSeatsNumber())
                .availableSeatsNumber(flightDTO.getAvailableSeatsNumber())
                .build();
    }
}
