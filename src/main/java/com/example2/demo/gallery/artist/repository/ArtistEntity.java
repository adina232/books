package com.example2.demo.gallery.artist.repository;

import com.example2.demo.gallery.PaintingToArtist;
import com.example2.demo.gallery.painting.repository.PaintingEntity;
import com.example2.demo.gallery.painting.rest.Painting;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artist")
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "artist")
    private List<PaintingToArtist> paintings = new ArrayList<>();

    public ArtistEntity() {
    }

    public ArtistEntity(Integer id, String firstName, String lastName, int age,
                        List<PaintingToArtist> paintings) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.paintings = paintings;
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

    public List<PaintingToArtist> getPaintings() {
        return paintings;
    }

    public void setPaintings(List<PaintingToArtist> paintings) {
        this.paintings = paintings;
    }

    @Override
    public String toString() {
        return "ArtistEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", paintings=" + paintings +
                '}';
    }
}
