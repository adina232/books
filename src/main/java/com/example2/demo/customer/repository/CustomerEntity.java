package com.example2.demo.customer.repository;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "prenume")
    private String prenume;

    @Column(name = "age")
    private int age;

    public CustomerEntity() {
    }

    public CustomerEntity(Integer id, String name, String prenume, int age) {
        this.id = id;
        this.name = name;
        this.prenume = prenume;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prenume='" + prenume + '\'' +
                ", age=" + age +
                '}';
    }
}
