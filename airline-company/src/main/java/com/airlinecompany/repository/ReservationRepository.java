package com.airlinecompany.repository;

import com.airlinecompany.model.Reservations;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ReservationRepository extends MongoRepository<Reservations, String> {
    List<Reservations> findAllByUserId(String userId);
}
