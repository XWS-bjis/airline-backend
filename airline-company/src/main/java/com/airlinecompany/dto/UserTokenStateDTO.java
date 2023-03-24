package com.airlinecompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserTokenStateDTO {
    private String accessToken;
    private Long expiresIn;
    private String role;
    private String userId;
}
