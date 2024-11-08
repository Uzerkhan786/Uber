package com.example.uber_review_service.services;

import com.example.uber_review_service.models.Review;
import com.example.uber_review_service.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    public reviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }




    @Override
    public void run(String... args) throws Exception {
        Review review = Review.builder().content("amazing ride 2").rating(3.0).build();
        System.out.println(review.getString());
       reviewRepository.save(review);
        
        System.out.println("******");
    }
}
