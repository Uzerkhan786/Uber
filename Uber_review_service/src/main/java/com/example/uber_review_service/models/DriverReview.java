package com.example.uber_review_service.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DriverReview extends Review  {

    private  String driverReview;
    private Double rating;


}
