package com.airlinecompany.dto;
import com.airlinecompany.model.Flight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ReservationDTO {
    private String id;
    private Flight flight;
    private String userId;
    private int ticketAmount;
    private double totalTicketPrice;
}
