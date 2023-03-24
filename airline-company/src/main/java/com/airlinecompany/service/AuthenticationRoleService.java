package com.airlinecompany.service;

import com.airlinecompany.model.AuthenticationRole;
import com.airlinecompany.repository.AuthenticationRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationRoleService {
    @Autowired
    private AuthenticationRoleRepository authenticationRoleRepository;

    public AuthenticationRole findByType(String type){
        return authenticationRoleRepository.findByType(type);
    }
}
