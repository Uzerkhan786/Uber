package com.example.uberauthservice.dtos;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PassengerRequestDto {

    private String name;
    private String email;
    private Long phoneNumber;
    private String password;

}
