package com.example2.demo.university.student.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
}
