package com.airlinecompany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Reservations {
    @Id
    private String id;
    private String flightId;
    private String userId;
    private int ticketAmount;
    private double totalTicketPrice;
}
