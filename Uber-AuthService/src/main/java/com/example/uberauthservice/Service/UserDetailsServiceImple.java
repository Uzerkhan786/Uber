package com.example.uberauthservice.Service;

import com.example.uberauthservice.Models.Passenger;
import com.example.uberauthservice.Repository.PassengerRepository;
import com.example.uberauthservice.helpers.AuthPassenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsServiceImple implements UserDetailsService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Passenger> passenger=passengerRepository.findPassengerByEmail(username);
        if(passenger.isPresent()){
            return new AuthPassenger(passenger.get());
        }
        else{
            throw new UsernameNotFoundException("User not found");
        }

    }
}
