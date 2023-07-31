package com.example2.demo.tourismAgency.trip.rest;

import com.example2.demo.tourismAgency.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("/trip")
    public void addTrip(@RequestBody Trip trip) {
        tripService.addTrip(trip);
    }

    @GetMapping("/trips")
    public List<Trip> getTrips() {
        return tripService.getTrips();
    }

    @GetMapping("/trip")
    public Trip getTrip (@RequestParam(value = "city") String city) {
        return tripService.getTrip(city);
    }

    @PutMapping("/trip/modify/{city}")
    public void modifyTrip(@PathVariable String city, @RequestBody Trip trip) {
        tripService.modifyTrip(city, trip);
    }

    @DeleteMapping("/delete/trip/{city}")
    public void deleteTrip(@PathVariable String city) {
        tripService.deleteTrip(city);
    }

    @PutMapping("/add/client")
    public void addClient(@RequestParam(value = "id") Integer id) {
        tripService.addClient(id);
    }

}
