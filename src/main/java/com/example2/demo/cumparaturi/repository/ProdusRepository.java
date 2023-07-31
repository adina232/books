package com.example2.demo.cumparaturi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdusRepository extends CrudRepository<ProdusEntity, Integer> {
    ProdusEntity findByName(String name);
}
