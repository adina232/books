package com.example2.demo.experiment.volunteers.rest;

import com.example2.demo.experiment.experiments.rest.Experiment;

import java.util.List;

public class Volunteer {

    private String name;
    private Integer id;

    private List<Experiment> experimentList;

    public Volunteer() {
    }

    public Volunteer(String name, Integer id, List<Experiment> experimentList) {
        this.name = name;
        this.id = id;
        this.experimentList = experimentList;
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

    public List<Experiment> getExperimentList() {
        return experimentList;
    }

    public void setExperimentList(List<Experiment> experimentList) {
        this.experimentList = experimentList;
    }
}
