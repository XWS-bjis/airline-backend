package com.airlinecompany.repository;

import com.airlinecompany.model.AuthenticationRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRoleRepository extends MongoRepository<AuthenticationRole, String> {
    AuthenticationRole findByType(String type);
}
