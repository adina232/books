package com.example2.demo.university.student.service;

import com.example2.demo.university.course.repository.CourseEntity;
import com.example2.demo.university.course.repository.CourseRepository;
import com.example2.demo.university.course.rest.Course;
import com.example2.demo.university.student.repository.StudentEntity;
import com.example2.demo.university.student.repository.StudentRepository;
import com.example2.demo.university.student.rest.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void createStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setId(student.getId());

        studentRepository.save(studentEntity);
    }

    public Student getStudent(Integer id) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if (studentEntity.isPresent()) {
            Student student = new Student();
            student.setId(studentEntity.get().getId());
            student.setName(studentEntity.get().getName());

            List<Course> courses = new ArrayList<>();
            Set<CourseEntity> courseEntityList = studentEntity.get().getEnrolledCourses();
            for (CourseEntity courseEntity : courseEntityList) {
                Course course = new Course();
                course.setTitle(courseEntity.getTitle());
                course.setId(courseEntity.getId());

                courses.add(course);
            }

            student.setCourseList(courses);
            return student;
        } else throw new RuntimeException("Student is not on the list");
    }


    public List<Student> getStudents() {
        Iterable<StudentEntity> studentEntities = studentRepository.findAll();
        List<Student> students = new ArrayList<>();

        for (StudentEntity studentEntity : studentEntities) {
            students.add(getStudent(studentEntity.getId()));
        }

        return students;
    }

    public void addCourse(Integer studentId, Integer courseId) {
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(studentId);

        if (studentEntityOptional.isPresent()) {
            Optional<CourseEntity> courseEntityOptional = courseRepository.findById(courseId);
            if (courseEntityOptional.isPresent()) {

                studentEntityOptional.get().getEnrolledCourses().add(courseEntityOptional.get());
                studentRepository.save(studentEntityOptional.get());

            } else throw new RuntimeException("Course not on the list");

        } else throw new RuntimeException("Student not on the list");
    }

}
