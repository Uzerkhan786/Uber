package com.example.uber_review_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "driver_review_id")
public class DriverReview extends Review  {

    private  String driverReview;
    private Double rating;

}
