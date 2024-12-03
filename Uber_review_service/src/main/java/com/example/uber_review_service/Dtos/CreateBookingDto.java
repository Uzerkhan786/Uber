package com.example.uber_review_service.Dtos;

import lombok.*;
import org.springframework.stereotype.Component;


import java.util.Date;
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateBookingDto {

    private Date startDate;
    private Date endDate;
    private Long PassengerId;
    private Long DriverId;
    
}
