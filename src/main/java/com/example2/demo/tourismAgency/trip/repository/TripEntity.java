package com.example2.demo.tourismAgency.trip.repository;

import com.example2.demo.tourismAgency.client.repository.ClientEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trip")
public class TripEntity {
    @Column(name = "country")
    private String country;

    @Column(name = "city")
    @Id
    private String city;

    @Column(name = "cost")
    private double cost;


    @ManyToMany
    @JoinTable(
            name = "clientsInTrips",
            inverseJoinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "trip_city", referencedColumnName = "city")
    )
    List<ClientEntity> clientEntityList;



    public TripEntity() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<ClientEntity> getClientEntityList() {
        return clientEntityList;
    }

    public void setClientEntityList(List<ClientEntity> clientEntityList) {
        this.clientEntityList = clientEntityList;
    }

    @Override
    public String toString() {
        return "TripEntity{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", cost=" + cost +
                ", clientEntityList=" + clientEntityList +
                '}';
    }
}
