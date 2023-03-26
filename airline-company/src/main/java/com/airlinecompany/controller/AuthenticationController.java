package com.airlinecompany.controller;

import com.airlinecompany.config.JwtService;
import com.airlinecompany.dto.LoginDTO;
import com.airlinecompany.dto.UserCreateDTO;
import com.airlinecompany.dto.UserTokenStateDTO;
import com.airlinecompany.model.User;
import com.airlinecompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
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
           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenStateDTO> authentication(@RequestBody LoginDTO loginDTO){
       Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUserName(),
                        loginDTO.getPassword()
                )
        );
        User newUser = (User) auth.getPrincipal();
        var jwtToken = jwtService.generateToken(newUser);
        int expiresIn = jwtService.getExpiredIn();

        return new ResponseEntity<UserTokenStateDTO>(new UserTokenStateDTO(jwtToken, (long) expiresIn, newUser.getRole().getType(), newUser.getId()), HttpStatus.OK);
    }
}
