package com.example2.demo.university.course.rest;

import com.example2.demo.university.student.rest.Student;

import java.util.List;

public class Course {
    private String title;
    private Integer id;
    private List<Student> studentList;

    public Course() {
    }

    public Course(String title, Integer id, List<Student> studentList) {
        this.title = title;
        this.id = id;
        this.studentList = studentList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
