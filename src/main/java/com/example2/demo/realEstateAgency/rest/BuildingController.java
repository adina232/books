package com.example2.demo.realEstateAgency.rest;

import com.example2.demo.realEstateAgency.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuildingController {

    @Autowired
    BuildingService buildingService;

    @PostMapping("/building/add")
    public void addBuilding(@RequestBody Building building) {
        buildingService.addBuilding(building);
    }

    @GetMapping("/buildings/all")
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping("/buildings/get/{fromPrice}/{toPrice}")
    public List<Building> getBuildingsByPrice(@PathVariable double fromPrice,
                                              @PathVariable double toPrice) {
        return buildingService.getBuildingsByPrice(fromPrice, toPrice);
    }

    @GetMapping("/buildings/get")
    public List<Building> getBuildingsBySurface(@RequestParam(value = "from", defaultValue = "0")
                                                double fromSurface, @RequestParam(value = "to")
    double toSurface) {
        return buildingService.getBuildingsBySurface(fromSurface, toSurface);
    }

    @PutMapping("/building/modify/{id}")
    public void modifyById(@PathVariable Integer id, @RequestBody Building building) {
        buildingService.modifyById(id, building);
    }

    @DeleteMapping("/building/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        buildingService.deleteById(id);
    }

    @DeleteMapping("/buildings/delete/all")
    public void deleteAll() {
        buildingService.deleteAll();
    }
}
