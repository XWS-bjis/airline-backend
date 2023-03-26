package com.airlinecompany.converters;

import com.airlinecompany.model.Destination;
import org.springframework.stereotype.Service;

@Service
public class EnumConverter {
    public Destination stringToDestination(String input) {
        switch(input.trim().toUpperCase()) {
            case "BELGRADE":
                return Destination.BELGRADE;
            case "OSLO":
                return Destination.OSLO;
            case "PARIS":
                return Destination.PARIS;
            case "LONDON":
                return Destination.LONDON;
            case "TIVAT":
                return Destination.TIVAT;
            case "MOSCOW":
                return Destination.MOSCOW;
            default:
                return Destination.NONE;
        }
    }
}
