package com.example.uber_review_service.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Course extends BaseModel {

    private String courseName;
    private String courseDescription;
    @ManyToMany(mappedBy = "courseList",cascade = CascadeType.ALL)
    private List<Student>studentList=new ArrayList<>();


}
