package com.example2.demo.university.student.repository;

import com.example2.demo.university.course.repository.CourseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Student")
@Table(name = "student")

//the owner side
public class StudentEntity {

    @Id
    @SequenceGenerator(
            name = "student_sequance",
            sequenceName = "student_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequance"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "enrolled_in_courses",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    Set<CourseEntity> enrolledCourses;



    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    public StudentEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<CourseEntity> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(Set<CourseEntity> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", enrolledCourses=" + enrolledCourses +
                ", name='" + name + '\'' +
                '}';
    }
}
