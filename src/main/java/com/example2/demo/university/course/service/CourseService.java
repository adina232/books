package com.example2.demo.university.course.service;

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
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    public void createCourse(Course course) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setTitle(course.getTitle());
        courseEntity.setId(course.getId());

        courseRepository.save(courseEntity);
    }

    public List<Course> getCourses() {
        List<CourseEntity> courseEntityList = (List<CourseEntity>) courseRepository.findAll();
        List<Course> courseList = new ArrayList<>();


        for (CourseEntity courseEntity : courseEntityList) {
            Course course = new Course();
            course.setTitle(courseEntity.getTitle());
            course.setId(courseEntity.getId());


            Set<StudentEntity> studentEntityList = courseEntity.getEnrolledStudents();

            List<Student> studentList = new ArrayList<>();
            for (StudentEntity studentEntity : studentEntityList) {
                Student student = new Student();
                student.setId(studentEntity.getId());
                student.setName(studentEntity.getName());

                studentList.add(student);
            }

            course.setStudentList(studentList);

            courseList.add(course);
        }
        return courseList;
    }


//    public void addStudent(Integer idStudent, Integer idCourse) {
//        Optional<CourseEntity> courseEntityOptional = courseRepository.findById(idCourse);
//        if (courseEntityOptional.isPresent()) {
//            Optional<StudentEntity> studentEntityOptional = studentRepository.findById(idStudent);
//            if (studentEntityOptional.isPresent()) {
//
//                courseEntityOptional.get().getEnrolledStudents().add(studentEntityOptional.get());
//                courseRepository.save(courseEntityOptional.get());
//
//            } else throw new RuntimeException("Student not on the list");
//        } else throw new RuntimeException("Course not on the list");
//    }
}
