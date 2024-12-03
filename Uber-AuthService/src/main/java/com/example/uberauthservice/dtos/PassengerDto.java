package com.example.uberauthservice.dtos;

import com.example.uberauthservice.Models.Passenger;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerDto {

    private String name;
    private String email;
    private Long phoneNumber;
    private String password;
    private Date createdAt;
    private Date updatedAt;


    public static  PassengerDto fromPassengertoPassengerDto(Passenger passenger) {
        PassengerDto passengerDto = PassengerDto.
                builder().email(passenger.getEmail()).
                name(passenger.getName()).
                phoneNumber(passenger.getPhoneNumber()).
                password(passenger.getPassword()).
                password(passenger.getPassword()).
                createdAt(passenger.getCreatedAt()).
                updatedAt(passenger.getUpdatedAt()).
                build();
        return passengerDto;
    }



}
