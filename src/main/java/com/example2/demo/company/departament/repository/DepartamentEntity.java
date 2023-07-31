package com.example2.demo.company.departament.repository;

import com.example2.demo.company.manager.repository.ManagerEntity;

import javax.persistence.*;

@Entity
@Table(name = "departament")
public class DepartamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String label;
    @Column(name = "number_of_people")
    private int people;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private ManagerEntity manager;

    public DepartamentEntity() {
    }

    public DepartamentEntity(Integer id, String label, int people, ManagerEntity manager) {
        this.id = id;
        this.label = label;
        this.people = people;
        this.manager = manager;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public ManagerEntity getManagerEntity() {
        return manager;
    }

    public void setManager(ManagerEntity manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "DepartamentEntity{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", people=" + people +
                '}';
    }
}
