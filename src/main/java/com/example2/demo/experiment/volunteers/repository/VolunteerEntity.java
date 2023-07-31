package com.example2.demo.experiment.volunteers.repository;

import com.example2.demo.experiment.experiments.repository.ExperimentEntity;

import javax.persistence.*;
import java.util.List;


//the target side



@Entity
@Table(name = "volunteer")
public class VolunteerEntity {

    @Id
    private Integer id;

    @ManyToMany(mappedBy = "volunteerEntityList")
    List<ExperimentEntity> experimentEntityList;


    @Column(name = "name")
    private String name;

    public VolunteerEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ExperimentEntity> getExperimentEntityList() {
        return experimentEntityList;
    }

    public void setExperimentEntityList(List<ExperimentEntity> experimentEntityList) {
        this.experimentEntityList = experimentEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "VolunteerEntity{" +
                "id=" + id +
                ", experimentEntityList=" + experimentEntityList +
                ", name='" + name + '\'' +
                '}';
    }
}
