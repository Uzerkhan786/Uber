package com.example.uberauthservice.Service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DemoService implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started the Spring boot project");
    }
}
