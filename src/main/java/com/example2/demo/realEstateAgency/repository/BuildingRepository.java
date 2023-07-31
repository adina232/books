package com.example2.demo.realEstateAgency.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends CrudRepository<BuildingEntity, Integer> {

    List<BuildingEntity> findByPriceGreaterThanAndPriceLessThan(double fromPrice, double toPrice);

    List<BuildingEntity> findBySurfaceGreaterThanAndSurfaceLessThan(double fromSurface, double toSurface);


}
