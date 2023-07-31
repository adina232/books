package com.example2.demo.experiment.experiments.rest;

import com.example2.demo.experiment.volunteers.rest.Volunteer;

import java.util.List;

public class Experiment {
    private String name;

    private Integer id;

    private List<Volunteer> volunteerList;

    public Experiment() {
    }

    public Experiment(String name, Integer id, List<Volunteer> volunteerList) {
        this.name = name;
        this.id = id;
        this.volunteerList = volunteerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Volunteer> getVolunteerList() {
        return volunteerList;
    }

    public void setVolunteerList(List<Volunteer> volunteerList) {
        this.volunteerList = volunteerList;
    }
}
