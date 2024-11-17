package com.example.uber_review_service.repositories;

import com.example.uber_review_service.models.Review;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByRatingIsGreaterThanEqual(double rating);

    List<Review>findAllByBookingId(Long bookingId);

}
