package com.example.uberauthservice.dtos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthRequestDto {

    private String email;
    private String password;

}
