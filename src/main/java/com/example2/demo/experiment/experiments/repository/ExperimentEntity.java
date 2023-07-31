package com.example2.demo.experiment.experiments.repository;

import com.example2.demo.experiment.volunteers.repository.VolunteerEntity;

import javax.persistence.*;
import java.util.List;


//the owner side



@Entity
@Table(name = "experiment")
public class ExperimentEntity {

    @Id
    private Integer id;

    @ManyToMany
    @JoinTable (
            name = "volunteers_enrolled",
            joinColumns = @JoinColumn(name = "volunteer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "experiment_id", referencedColumnName = "id")
    )
    List<VolunteerEntity> volunteerEntityList;

    @Column(name = "name")
    private String name;


    public ExperimentEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<VolunteerEntity> getVolunteerEntityList() {
        return volunteerEntityList;
    }

    public void setVolunteerEntityList(List<VolunteerEntity> volunteerEntityList) {
        this.volunteerEntityList = volunteerEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExperimentEntity{" +
                "id=" + id +
                ", volunteerEntityList=" + volunteerEntityList +
                ", name='" + name + '\'' +
                '}';
    }
}
