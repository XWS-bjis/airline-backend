package com.airlinecompany.service;


import com.airlinecompany.dto.UserCreateDTO;
import com.airlinecompany.model.Role;
import com.airlinecompany.model.User;
import com.airlinecompany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
   /*@Autowired
   UserRepository userRepository;*/
   @Autowired
   private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       /*User user = userRepository.findOneByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", username));
        } else {
            return user;
        }
        /*UserDetails user = new User();
        return user;*/
        UserDetails user = new User();
        return user;
    }

    public User create(UserCreateDTO userCreateDTO){
        return null;
    }
}
