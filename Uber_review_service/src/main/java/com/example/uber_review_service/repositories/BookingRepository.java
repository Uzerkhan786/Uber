package com.example.uber_review_service.repositories;

import com.example.uber_review_service.models.Booking;
import com.example.uber_review_service.models.Driver;
import com.example.uber_review_service.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking>findAllByDriverId(long id);
    List<Booking>findAllByDriverIn(List<Driver>driver);
//   @Query("select r from Booking b inner join Review r on b.review=r  where b.id=:bookingId ")
//    Review findReviewByBookingId(Long bookingId);
}
