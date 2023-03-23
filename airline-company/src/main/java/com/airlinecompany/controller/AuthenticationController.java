package com.airlinecompany.controller;

import com.airlinecompany.config.JwtService;
import com.airlinecompany.dto.AuthenticationResponse;
import com.airlinecompany.dto.LoginDTO;
import com.airlinecompany.dto.UserCreateDTO;
import com.airlinecompany.model.AuthenticationRole;
import com.airlinecompany.model.User;
import com.airlinecompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    @Autowired
    UserService userService;
    @Autowired
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserCreateDTO userCreateDTO){
        User newUser = userService.create(userCreateDTO);
        if(newUser == null){
            throw new RuntimeException(String.valueOf("User with given username already exists"));
        }
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public AuthenticationResponse authentication(@RequestBody LoginDTO loginDTO){
       Authentication authentication1 = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUserName(),
                        loginDTO.getPassword()
                )
        );
        User myUser = (User) authentication1.getPrincipal();
        System.out.println(myUser.getName());
        var jwtToken = jwtService.generateToken(myUser);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
