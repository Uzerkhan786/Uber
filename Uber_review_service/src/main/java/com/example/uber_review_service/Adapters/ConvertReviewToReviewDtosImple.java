package com.example.uber_review_service.Adapters;

import com.example.uber_review_service.Dtos.CreateBookingDto;
import com.example.uber_review_service.models.Booking;
import com.example.uber_review_service.models.Driver;
import com.example.uber_review_service.models.Passenger;
import com.example.uber_review_service.repositories.DriverRepository;
import com.example.uber_review_service.repositories.PassengerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ConvertReviewToReviewDtosImple implements ConvertReviewToReviewDtos {

    private PassengerRepository passengerRepository;
    private DriverRepository driverRepository;
    public ConvertReviewToReviewDtosImple(PassengerRepository passengerRepository,
                                     DriverRepository driverRepository){
        this.driverRepository=driverRepository;
        this.passengerRepository=passengerRepository;
    }

    @Override
    public Booking convertBooking(CreateBookingDto createDto) {
        Optional<Driver> driver=driverRepository.findById(createDto.getDriverId());
        Optional<Passenger> passenger=passengerRepository.findById(createDto.getPassengerId());

        Booking booking=Booking.builder().startBookingDate(createDto.getStartDate()).
                endBookingDate(createDto.getEndDate()).driver(driver.get()).
                passenger(passenger.get()).build();
        return booking;

    }


}
