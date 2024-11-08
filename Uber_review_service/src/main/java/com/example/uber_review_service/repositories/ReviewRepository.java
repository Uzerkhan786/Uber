package com.example.uber_review_service.repositories;

import com.example.uber_review_service.models.Review;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
