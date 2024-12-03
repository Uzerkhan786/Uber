package com.example.uber_review_service.Adapters;

import com.example.uber_review_service.Dtos.CreateBookingDto;
import com.example.uber_review_service.Dtos.CreateBookingDto;
import com.example.uber_review_service.models.Booking;

public interface ConvertReviewToReviewDtos {

    public Booking convertBooking(CreateBookingDto createBookingDto);
}
