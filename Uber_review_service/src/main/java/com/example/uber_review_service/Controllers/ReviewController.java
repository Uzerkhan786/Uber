package com.example.uber_review_service.Controllers;

import com.example.uber_review_service.Adapters.ConvertReviewToReviewDtos;
import com.example.uber_review_service.Dtos.CreateBookingDto;
import com.example.uber_review_service.Dtos.CreateBookingDto;
import com.example.uber_review_service.Dtos.ResponseBookingDto;
import com.example.uber_review_service.models.Booking;
import com.example.uber_review_service.models.Driver;
import com.example.uber_review_service.models.Review;
import com.example.uber_review_service.repositories.BookingRepository;
import com.example.uber_review_service.repositories.DriverRepository;
import com.example.uber_review_service.repositories.ReviewRepository;
import com.example.uber_review_service.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ReviewController {
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;
    private final ConvertReviewToReviewDtos convertReviewToReviewDtos;
    private final ReviewService reviewService;

    public ReviewController(DriverRepository driverRepository,
                            ConvertReviewToReviewDtos convertReviewToReviewDtos,
                            BookingRepository bookingRepository,ReviewService reviewService){
        this.driverRepository = driverRepository;
        this.convertReviewToReviewDtos=convertReviewToReviewDtos;
        this.bookingRepository = bookingRepository;
        this.reviewService=reviewService;
    }

    @GetMapping("/api/v1/users")
    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }
    @GetMapping("/api/v1/users/{id}")
    public Optional<Driver> getDriverById(@PathVariable Long id){
        return driverRepository.findById(id);
    }

    @PostMapping("/api/v1/booking")
    public ResponseEntity<?> CreateBooking (@RequestBody CreateBookingDto createBookingDto){

        Booking booking=convertReviewToReviewDtos.convertBooking(createBookingDto);
       bookingRepository.save(booking);
        ResponseBookingDto response=ResponseBookingDto.builder().
                id(booking.getId()).
                createdAt(booking.getCreatedAt()).
                updatedAt(booking.getUpdatedAt()).
                startDate(booking.getStartBookingDate()).
                endDate(booking.getEndBookingDate()).
                passengerId(booking.getPassenger().getId()).
                driverId(booking.getPassenger().getId()).
                build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/api/v1/booking")
    public List<Booking>AllBookiong(){
        return  bookingRepository.findAll();
    }


    //Review Controller

    @GetMapping("/api/v1/review/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id){
        Optional<Review> review=this.reviewService.findReviewById(id);
        return new ResponseEntity<>(review.get(), HttpStatus.OK);
    }

    @PostMapping("/api/v1/review")
    public ResponseEntity<Review>CreateReviewController(@RequestBody Review r){
        Review review=this.reviewService.createReview(r);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/review")
   public  ResponseEntity<List<Review>> getAllReviewsController(){
        List<Review> reviews=this.reviewService.findAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

}
