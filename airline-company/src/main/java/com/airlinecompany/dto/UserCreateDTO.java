package com.airlinecompany.dto;

import lombok.Data;

@Data
public class UserCreateDTO {
    private String name;
    private String surname;
    private String userName;
    private String email;
    private String password;
    //private Address address;
    private String role;
}
