package com.airlinecompany.service;

import com.airlinecompany.model.Flight;
import com.airlinecompany.model.Reservations;
import com.airlinecompany.repository.FlightRepository;
import com.airlinecompany.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    FlightRepository flightRepository;

    public List<Reservations> findAllByUserId(String userId){
        return reservationRepository.findAllByUserId(userId);
    }

    public Reservations buyingTickets(Reservations reservations) {
       Optional<Flight> flight = flightRepository.findById(reservations.getFlightId());
       if(!flight.isPresent() || flight.get().getAvailableSeatsNumber() < reservations.getTicketAmount()){
           return null;
       }
       int previousAvailableSets = flight.get().getAvailableSeatsNumber();
       flight.get().setAvailableSeatsNumber(previousAvailableSets - reservations.getTicketAmount());
       flightRepository.save(flight.get());
       reservations.setTotalTicketPrice(reservations.getTicketAmount() * flight.get().getTicketPrice());
       return reservationRepository.save(reservations);
    }
}
