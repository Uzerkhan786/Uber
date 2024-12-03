package com.example.uber_review_service.Dtos;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBookingDto {
   private Long id;
   private Date createdAt;
   private Date updatedAt;
    private Date startDate;
    private Date endDate;
    private Long passengerId;
    private Long driverId;
}
