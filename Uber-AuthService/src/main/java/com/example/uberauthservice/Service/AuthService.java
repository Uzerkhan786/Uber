package com.example.uberauthservice.Service;

import com.example.uberauthservice.Configurations.SpringSecurity;
import com.example.uberauthservice.Models.Passenger;
import com.example.uberauthservice.Repository.PassengerRepository;
import com.example.uberauthservice.dtos.PassengerDto;
import com.example.uberauthservice.dtos.PassengerRequestDto;
import org.aspectj.weaver.bcel.BcelTypeMunger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PassengerDto passengerDto;
    private BCryptPasswordEncoder bcryptEncoder;
private PassengerRepository passengerRepository;
 public AuthService(BCryptPasswordEncoder bcryptEncoder, PassengerRepository passengerRepository, PassengerDto passengerDto){
     this.bcryptEncoder=bcryptEncoder;
     this.passengerRepository=passengerRepository;
     this.passengerDto = passengerDto;
 }

    public PassengerDto AuthPassengerService(PassengerRequestDto passengerRequestDto){

        Passenger passenger =Passenger.builder().
                email(passengerRequestDto.getEmail())
                .name(passengerRequestDto.getName()).
                password(bcryptEncoder.encode(passengerRequestDto.getPassword()))
                .phoneNumber(passengerRequestDto.getPhoneNumber())
                .build();

        Passenger response =passengerRepository.save(passenger);
        return PassengerDto.fromPassengertoPassengerDto(response);
    }
}
