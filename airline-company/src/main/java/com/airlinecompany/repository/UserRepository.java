package com.airlinecompany.repository;

import com.airlinecompany.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
   User findOneByEmail(String username);

   User findOneByUserName(String username);
}
