package com.airlinecompany.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRole implements GrantedAuthority {
    private String id;
    private String type;


    @Override
    public String getAuthority() {
        return this.type;
    }
}
