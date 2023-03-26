package com.airlinecompany.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
    private String id;
    private String takeOfDate;
    private String landingDate;
    private String landingPlace;
    private String departurePlace;
    private double ticketPrice;
    private int totalSeatsNumber;
    private int availableSeatsNumber;

    public FlightDTO(String takeOfDate, String landingDate, String landingPlace, String departurePlace, double ticketPrice, int totalSeatsNumber, int availableSeatsNumber) {
        this.takeOfDate = takeOfDate;
        this.landingDate = landingDate;
        this.landingPlace = landingPlace;
        this.departurePlace = departurePlace;
        this.ticketPrice = ticketPrice;
        this.totalSeatsNumber = totalSeatsNumber;
        this.availableSeatsNumber = availableSeatsNumber;
    }
}
