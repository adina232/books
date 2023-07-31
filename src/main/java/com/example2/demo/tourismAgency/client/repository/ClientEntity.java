package com.example2.demo.tourismAgency.client.repository;

import com.example2.demo.tourismAgency.trip.repository.TripEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class ClientEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "budget")
    private double budget;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(mappedBy = "clientEntityList")
    private List<TripEntity> tripEntityList;

    public ClientEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<TripEntity> getTripEntityList() {
        return tripEntityList;
    }

    public void setTripEntityList(List<TripEntity> tripEntityList) {
        this.tripEntityList = tripEntityList;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "name='" + name + '\'' +
                ", budget=" + budget +
                ", id=" + id +
                ", tripEntityList=" + tripEntityList +
                '}';
    }
}
