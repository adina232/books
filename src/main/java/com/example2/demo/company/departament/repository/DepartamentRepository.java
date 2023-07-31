package com.example2.demo.company.departament.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends CrudRepository<DepartamentEntity, Integer> {

}
