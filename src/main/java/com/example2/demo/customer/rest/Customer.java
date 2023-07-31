package com.example2.demo.customer.rest;

public class Customer {

    private String name;
    private String prenume;
    private int age;

    public Customer() {

    }

    public Customer(String name, String prenume, int age) {
        this.name = name;
        this.prenume = prenume;
        this.age = age;
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
}
