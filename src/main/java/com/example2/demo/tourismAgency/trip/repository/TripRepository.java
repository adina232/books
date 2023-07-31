package com.example2.demo.tourismAgency.trip.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<TripEntity, String> {
    TripEntity findByCity(String city);
    void deleteByCity(String city);
}
