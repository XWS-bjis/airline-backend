package com.airlinecompany.model;

import java.time.LocalDateTime;

public class Flight {
    private String id;
    private LocalDateTime takeOfDate;
    private LocalDateTime landingDate;
    private Destination landingPlace;
    private Destination departurePlace;
    private double ticketPrice;
    private int totalSeatsNumber;
    private int availableSeatsNumber;
}
