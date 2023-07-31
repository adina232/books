package com.example2.demo.tourismAgency.trip.service;

import com.example2.demo.tourismAgency.trip.repository.TripEntity;
import com.example2.demo.tourismAgency.trip.repository.TripRepository;
import com.example2.demo.tourismAgency.trip.rest.Trip;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public void addTrip(@NotNull Trip trip) {
        TripEntity tripEntity = new TripEntity();
        setTripEntity(trip, tripEntity);

        tripRepository.save(tripEntity);
    }


    public List<Trip> getTrips() {
        List<Trip> trips = new ArrayList<>();
        List<TripEntity> tripEntityList = (List<TripEntity>) tripRepository.findAll();

        for (TripEntity tripEntity : tripEntityList) {
            Trip trip = new Trip();
            setTrip(trip, tripEntity);

            trips.add(trip);
        }

        return trips;
    }


    public Trip getTrip(String city) {
        TripEntity tripEntity = tripRepository.findByCity(city);
        Trip trip = new Trip();
        setTrip(trip, tripEntity);

        return trip;
    }

    public void modifyTrip(String city, Trip trip) {
        TripEntity tripEntity = tripRepository.findByCity(city);
        setTrip(trip, tripEntity);
        setTripEntity(trip, tripEntity);

        tripRepository.save(tripEntity);
    }

    public void deleteTrip(String city) {
        tripRepository.deleteByCity(city);
    }




    private void setTrip(Trip trip, TripEntity tripEntity) {
        trip.setCounty(tripEntity.getCountry());
        trip.setCity(trip.getCity());
        trip.setCost(trip.getCost());
    }

    private void setTripEntity(Trip trip, TripEntity tripEntity) {
        tripEntity.setCountry(trip.getCounty());
        tripEntity.setCity(trip.getCity().toLowerCase());
        trip.setCost(trip.getCost());
    }

    public void addClient(Integer id) {

    }
}
