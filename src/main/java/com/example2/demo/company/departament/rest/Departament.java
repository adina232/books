package com.example2.demo.company.departament.rest;

import com.example2.demo.company.manager.rest.Manager;

public class Departament {
    private String label;
    private int people;
    private Manager manager;

    public Departament() {
    }

    public Departament(String label, int people, Manager manager) {
        this.label = label;
        this.people = people;
        this.manager = manager;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String name) {
        this.label = name;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
