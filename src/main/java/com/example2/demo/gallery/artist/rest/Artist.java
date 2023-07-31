package com.example2.demo.gallery.artist.rest;

import com.example2.demo.gallery.painting.rest.Painting;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private Integer idArtist;
    private String firstName;
    private String lastName;
    private int age;

    private List<Painting> paintingList = new ArrayList<>();

    public Artist() {
    }

    public Artist(Integer idArtist, String firstName, String lastName,
                  int age, List<Painting> paintingList) {
        this.idArtist = idArtist;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.paintingList = paintingList;
    }

    public Integer getIdArtist() {
        return idArtist;
    }

    public List<Painting> getPaintingList() {
        return paintingList;
    }

    public void setPaintingList(List<Painting> paintingList) {
        this.paintingList = paintingList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdArtist(Integer idArtist) {
        this.idArtist = idArtist;
    }
}
