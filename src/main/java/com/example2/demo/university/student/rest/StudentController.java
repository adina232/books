package com.example2.demo.university.student.rest;

import com.example2.demo.university.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public void createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @GetMapping("/see/student/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/see/all/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PutMapping("/add-course/{idStudent}/{idCourse}")
    public void addCourse(@PathVariable Integer idStudent, @PathVariable Integer idCourse) {
        studentService.addCourse(idStudent, idCourse);
    }
}