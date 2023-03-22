package com.airlinecompany.controller;

import com.airlinecompany.config.JwtService;
import com.airlinecompany.dto.AuthenticationResponse;
import com.airlinecompany.dto.LoginDTO;
import com.airlinecompany.dto.UserCreateDTO;
import com.airlinecompany.model.Role;
import com.airlinecompany.model.User;
import com.airlinecompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private User user = new User();

    public AuthenticationController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody UserCreateDTO userCreateDTO){
        userService.create(userCreateDTO);
        
        user.setName(userCreateDTO.getName());
        user.setSurname(userCreateDTO.getSurname());
        user.setUserName(userCreateDTO.getUserName());
        user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        user.setEmail(userCreateDTO.getEmail());
        user.setRole(Role.ROLE_REGULAR);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @PostMapping("/login")
    public AuthenticationResponse authentication(@RequestBody LoginDTO loginDTO){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUserName(),
                        loginDTO.getPassword()
                )
        );
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
