package com.example2.demo.realEstateAgency.service;

import com.example2.demo.realEstateAgency.repository.BuildingEntity;
import com.example2.demo.realEstateAgency.repository.BuildingRepository;
import com.example2.demo.realEstateAgency.rest.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public void addBuilding(Building building) {
        BuildingEntity buildingEntity = new BuildingEntity();
        buildingEntity.setSurface(building.getSurface());
        buildingEntity.setFinished(building.isFinished());
        buildingEntity.setPrice(building.getPrice());

        buildingRepository.save(buildingEntity);
    }

    public List<Building> getAllBuildings() {
        List<BuildingEntity> all = (List<BuildingEntity>) buildingRepository.findAll();
        return convertEntity(all);
    }

    public List<Building> getBuildingsByPrice(double fromPrice, double toPrice) {
        List<BuildingEntity> all = buildingRepository.findByPriceGreaterThanAndPriceLessThan(fromPrice, toPrice);
        return convertEntity(all);
    }

    private static List<Building> convertEntity(List<BuildingEntity> all) {
        List<Building> response = new ArrayList<>();
        for (BuildingEntity buildingEntity : all) {
            Building building = new Building();
            building.setSurface(buildingEntity.getSurface());
            building.setPrice(buildingEntity.getPrice());
            building.setFinished(buildingEntity.isFinished());
            response.add(building);
        }
        return response;
    }


    public List<Building> getBuildingsBySurface(double fromSurface, double toSurface) {
        List<BuildingEntity> all = buildingRepository.findBySurfaceGreaterThanAndSurfaceLessThan(fromSurface, toSurface);
        return convertEntity(all);
    }

    public void modifyById(Integer id, Building building) {
        Optional<BuildingEntity> buildingEntity = buildingRepository.findById(id);
        if (buildingEntity.isPresent()) {
            buildingEntity.get().setSurface(building.getSurface());
            buildingEntity.get().setPrice(building.getPrice());
            buildingEntity.get().setFinished(building.isFinished());

            buildingRepository.save(buildingEntity.get());
        }
    }


    public void deleteById(Integer id) {
        buildingRepository.deleteById(id);
    }

    public void deleteAll() {
        buildingRepository.deleteAll();
    }
}
