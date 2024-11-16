package com.example.uber_review_service.Controllers;

import com.example.uber_review_service.models.Driver;
import com.example.uber_review_service.repositories.DriverRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController

public class DemoRunController {
    private DriverRepository driverRepository;

    public DemoRunController(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    @GetMapping("/api/v1/users")
    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }
    @GetMapping("/api/v1/users/{id}")
    public Optional<Driver> getDriverById(@PathVariable Long id){
        return driverRepository.findById(id);
    }
}
