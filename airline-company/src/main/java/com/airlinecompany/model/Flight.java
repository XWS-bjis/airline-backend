package com.airlinecompany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Flight {
    @Id
    private String id;
    private LocalDateTime takeOfDate;
    private LocalDateTime landingDate;
    private Destination landingPlace;
    private Destination departurePlace;
    private double ticketPrice;
    private int totalSeatsNumber;
    private int availableSeatsNumber;
}
