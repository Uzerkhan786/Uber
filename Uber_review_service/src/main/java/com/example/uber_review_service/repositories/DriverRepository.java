package com.example.uber_review_service.repositories;


import com.example.uber_review_service.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {
@Query(name = "list", nativeQuery = true,value = "select * from driver where driver_name=:name")
    List<Driver>listOfDriver(String name);
@Query("select d from Driver as d where d.id=:id")
    Driver findByDriverName(Long id);

    List<Driver>findAllByIdIn(List<Long> ids);
}
