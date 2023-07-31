package com.example2.demo.company.manager.rest;

public class Manager {
    private String lastName;

    private String fistName;

    private Integer id;

    public Manager() {
    }

    public Manager(String lastName, String fistName, Integer id) {
        this.lastName = lastName;
        this.fistName = fistName;
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
