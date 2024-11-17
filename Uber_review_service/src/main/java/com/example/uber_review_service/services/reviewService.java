package com.example.uber_review_service.services;

import com.example.uber_review_service.models.*;
import com.example.uber_review_service.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.*;

@Service
public class reviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final DriverRepository driverRepository;

    public reviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository,
                         StudentRepository studentRepository, CourseRepository courseRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.driverRepository = driverRepository;
    }



    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        Review review = Review.
//                builder().
//                content("amazing ride 3").
//                rating(3.0).
//                build();
//


//                Booking b= Booking.
//                builder().
//                startBookingDate(new Date()).
//                endBookingDate(new Date()).
//                status(BookingStatus.PENDING).
//
//                build();


      //bookingRepository.save(b);
//        System.out.println(review);
//
//       reviewRepository.save(review);




        //Student.builder().studentName("uzer").studentRollNo("20BCE10760").build();



       //Course course=Course.builder().courseName("DSA").courseDescription("Algorithms").studentList(s).build();
//      Student student   =new Student();
//      student.setStudentName("uzerkhan");
//L
//      Course c=new Course();
//      c.setCourseName("SCIENCE");
//      student.getCourseList().add(c);
//
//      c.getStudentList().add(student);
//      studentRepository.save(student);
//      courseRepository.save(c);

      // student.builder().courseList(course).build();

//      Optional<Driver> d= driverRepository.findById(1L);
//        if(d.isPresent()){
//            List<Booking>bookings = d.get().getBookings();
//            for (Booking b:bookings){
//                System.out.println(b.getEndBookingDate());
//            }
//        }

//       List<Booking>booking=bookingRepository.findAllByDriverId(3L);
//        for(Booking bi:booking){
//            System.out.println(bi.getStartBookingDate());
//        }

//        List<Driver>d=driverRepository.listOfDriver("Musa");
//        Driver di=driverRepository.findByDriverName(3L);
//        List<Booking>bi=di.getBookings();
//        for(Booking b:bi){
//            System.out.println(b.getId());
//        }
        //System.out.println(di.getDriverName());
//        if(d.size()>0){
//            for(Driver driver:d){
//                System.out.println(driver.getDriverName());
//            }
//        }

//        List<Long>Ids=new ArrayList<>(Arrays.asList(1L,3L));
//        List<Driver>drivers=driverRepository.findAllByIdIn(Ids);
//
//        for(Driver driver:drivers){
//            List<Booking>bookings=driver.getBookings();
//           bookings.forEach(booking-> System.out.println(booking.getId()));
//        }
        //List<Booking>bookings=bookingRepository.findAllByDriverIn(driversIds);
//        for(Booking booking:bookings){
//            System.out.println(booking.getId());
//        }



        List<Review>r=reviewRepository.findAllByBookingId(2L);
        System.out.println(r.size());




        System.out.println("******");
    }
}
