package com.example2.demo.university.course.repository;

import com.example2.demo.university.student.repository.StudentEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")

//the target side
public class CourseEntity {

    @Id
    private Integer id;

    @ManyToMany(mappedBy = "enrolledCourses")
    Set<StudentEntity> enrolles;



    @Column(name = "title")
    private String title;

    public CourseEntity() {
    }

    public CourseEntity(Integer id, Set<StudentEntity> enrolledStudents, String title) {
        this.id = id;
        this.enrolles = enrolledStudents;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<StudentEntity> getEnrolledStudents() {
        return enrolles;
    }

    public void setEnrolledStudents(Set<StudentEntity> enrolles) {
        this.enrolles = enrolles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "id=" + id +
                ", enrolledStudents=" + enrolles +
                ", title='" + title + '\'' +
                '}';
    }
}
