package com.airlinecompany.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String streetNumber;
    private String streetName;
    private String postalCode;
    private String town;
    private String country;
}
