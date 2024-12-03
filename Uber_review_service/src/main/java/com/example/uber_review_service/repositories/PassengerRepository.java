package com.example.uber_review_service.repositories;

import com.example.uber_review_service.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
