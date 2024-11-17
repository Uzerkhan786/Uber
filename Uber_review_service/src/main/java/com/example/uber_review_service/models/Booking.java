package com.example.uber_review_service.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Booking extends BaseModel {
    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private  Review review;
@Enumerated(EnumType.STRING)
private BookingStatus status;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date startBookingDate;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date endBookingDate;
    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;


}
