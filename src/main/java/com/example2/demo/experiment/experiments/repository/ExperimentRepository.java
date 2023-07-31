package com.example2.demo.experiment.experiments.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperimentRepository extends CrudRepository<ExperimentEntity, Integer> {


}
