package com.example2.demo.university.course.rest;

import com.example2.demo.university.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public void createCourse(@RequestBody Course course) {
        courseService.createCourse(course);
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

//    @PutMapping("/add-student/{idStudent}/{idCourse}")
//    public void addStudent(@PathVariable Integer idStudent, @PathVariable Integer idCourse) {
//        courseService.addStudent(idStudent, idCourse);
//    }
}
