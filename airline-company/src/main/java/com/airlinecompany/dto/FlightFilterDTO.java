package com.airlinecompany.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightFilterDTO {
    String searchDate;
    String landingPlace;
    String departurePlace;
    int passengers;
}
