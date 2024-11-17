package com.example.uber_review_service.models;


import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;
    private Double rating;
   @OneToOne
   @JoinColumn(name = "booking_id",referencedColumnName = "id")
    private Booking booking;
    public String getString(){
        return this.content+" "+this.rating+" ";
    }

}
