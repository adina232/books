package com.example2.demo.gallery.painting.rest;

import com.example2.demo.gallery.artist.rest.Artist;

import java.util.ArrayList;
import java.util.List;

public class Painting {
    private Integer idPainting;
    private String title;
    private String dimensions;

    private List<Artist> artistList = new ArrayList<>();

    public Painting() {
    }

    public Painting(Integer idPainting, String title, String dimensions, List<Artist> artistList) {
        this.idPainting = idPainting;
        this.title = title;
        this.dimensions = dimensions;
        this.artistList = artistList;
    }

    public Integer getIdPainting() {
        return idPainting;
    }

    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
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

    public void setIdPainting(Integer idPainting) {
        this.idPainting = idPainting;
    }
}
