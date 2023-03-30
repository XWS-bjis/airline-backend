package com.airlinecompany.controller;

import com.airlinecompany.dto.ReservationDTO;
import com.airlinecompany.model.Reservations;
import com.airlinecompany.service.ReservationService;
import com.airlinecompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @GetMapping("/all/{userId}")
    @PreAuthorize("hasRole('REGULAR')")
    public ResponseEntity<List<ReservationDTO>> getAllReservations(@PathVariable("userId") String userId) {
        List<ReservationDTO> reservations = reservationService.findAllByUserId(userId);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('REGULAR')")
    @PostMapping("/buy")
    public ResponseEntity<Reservations> buyingTickets(@RequestBody Reservations reservations) {
        Reservations booking = reservationService.buyingTickets(reservations);
        if (booking == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('REGULAR')")
    @GetMapping("/getUsername/{userId}")
    public ResponseEntity<String> getUsername(@PathVariable("userId") String userId) {
        String username = userService.findById(userId);
        return new ResponseEntity<>(username, HttpStatus.OK);

    }


}
