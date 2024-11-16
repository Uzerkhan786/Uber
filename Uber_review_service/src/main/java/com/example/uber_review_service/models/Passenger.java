package com.example.uber_review_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Passenger extends  BaseModel  {
    private String passengerName;
    private Long mobileNumber;

    @OneToMany(mappedBy = "passenger",fetch = FetchType.LAZY)
    List<Booking> bookings=new ArrayList<>();
}
