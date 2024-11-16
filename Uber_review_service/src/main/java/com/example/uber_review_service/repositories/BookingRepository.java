package com.example.uber_review_service.repositories;

import com.example.uber_review_service.models.Booking;
import com.example.uber_review_service.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking>findAllByDriverId(long id);
    List<Booking>findAllByDriverIn(List<Driver>driver);
}
