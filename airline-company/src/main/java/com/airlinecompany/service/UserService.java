package com.airlinecompany.service;

import com.airlinecompany.dto.UserCreateDTO;
import com.airlinecompany.model.AuthenticationRole;
import com.airlinecompany.model.User;
import com.airlinecompany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
   @Autowired
   UserRepository userRepository;
   @Autowired
   private PasswordEncoder passwordEncoder;

   @Autowired
   private AuthenticationRoleService authenticationRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOneByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return user;
        }
    }

    public User create(UserCreateDTO userCreateDTO){
        if(userRepository.findOneByUserName(userCreateDTO.getUserName()) == null){
            User user = new User();
            user = DtoToEntity(userCreateDTO, user);
            return userRepository.save(user);
        }
        return null;
    }

    public User DtoToEntity(UserCreateDTO userCreateDTO, User user){
        AuthenticationRole  authenticationRole = authenticationRoleService.findByType("ROLE_REGULAR");

        user.setName(userCreateDTO.getName());
        user.setSurname(userCreateDTO.getSurname());
        user.setUserName(userCreateDTO.getUserName());
        user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        user.setEmail(userCreateDTO.getEmail());
        user.setAddress(userCreateDTO.getAddress());
        user.setRole(authenticationRole);

        return user;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
