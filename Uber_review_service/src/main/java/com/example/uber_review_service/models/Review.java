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

    public String getString(){
        return this.content+" "+this.rating+" ";
    }

}
