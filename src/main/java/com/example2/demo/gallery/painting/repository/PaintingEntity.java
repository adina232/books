package com.example2.demo.gallery.painting.repository;

import com.example2.demo.gallery.PaintingToArtist;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "painting")
public class PaintingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "dimensions")
    private String dimensions;

    @OneToMany(mappedBy = "painting")
    private List<PaintingToArtist> artists = new ArrayList<>();

    public PaintingEntity() {
    }

    public PaintingEntity(Integer id, String title, String dimensions, List<PaintingToArtist> artists) {
        this.id = id;
        this.title = title;
        this.dimensions = dimensions;
        this.artists = artists;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public List<PaintingToArtist> getArtistsEntity() {
        return artists;
    }

    public void setArtistsEntity(List<PaintingToArtist> artist) {
        this.artists = artist;
    }

    @Override
    public String toString() {
        return "PaintingEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", artists=" + artists +
                '}';
    }
}
