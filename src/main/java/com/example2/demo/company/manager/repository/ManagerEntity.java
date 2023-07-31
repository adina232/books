package com.example2.demo.company.manager.repository;

import com.example2.demo.company.departament.repository.DepartamentEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "manager")
public class ManagerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastname;

    @OneToMany(mappedBy = "manager")
    private List<DepartamentEntity> departments = new ArrayList<>();

    public ManagerEntity() {
    }

    public ManagerEntity(Integer id, String firstName, String lastname, List<DepartamentEntity> departments) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.departments = departments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<DepartamentEntity> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartamentEntity> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "ManagerEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
