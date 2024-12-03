package com.example.uberauthservice.Models;

import jakarta.persistence.Entity;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Passenger extends BaseModel {

    private String name;
    private String email;
    private String password;
    private Long phoneNumber;

}
