package com.example.uber_review_service;

import com.example.uber_review_service.Controllers.ReviewController;
import com.example.uber_review_service.models.Review;
import com.example.uber_review_service.services.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import static org.mockito.Mockito.when;

public class ReviewControllerTest {

    @InjectMocks
   private ReviewController reviewController;

    @Mock
   private ReviewService reviewService;



    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetReview_Success(){
        long id=1;
        Review mockReview=Review.builder().build();
        mockReview.setId(id);
        when(reviewService.findReviewById(id)).thenReturn(Optional.of(mockReview));
        ResponseEntity<?>response=reviewController.getReviewById(id);
       assertEquals(HttpStatus.OK,response.getStatusCode());

    }

    public void testCreateReview_Success(){
        Review incomingReview=Review.builder().content("Nice").
                rating(3.2)
                .build();
        Review savedReview=Review.builder().
                content(incomingReview.getContent()).
                rating(incomingReview.getRating()).build();

        when(reviewService.createReview(incomingReview)).thenReturn(savedReview);
        ResponseEntity<?>response=reviewController.CreateReviewController(incomingReview);
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }
}
