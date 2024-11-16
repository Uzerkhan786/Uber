package com.example.uber_review_service.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Student extends BaseModel {

    private String studentName;
    private String studentRollNo;
    @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(name = "register_course",
                       joinColumns = @JoinColumn(name="stduent_id"),
                    inverseJoinColumns = @JoinColumn(name = "course_id")
                 )
    List<Course> courseList=new ArrayList<>();



}
