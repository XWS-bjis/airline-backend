package com.airlinecompany.repository;

import com.airlinecompany.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
   User findOneByEmail(String username);
}
