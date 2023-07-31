package com.example2.demo.gallery;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PaintingToArtistId implements Serializable {


    @Column(name = "painting_id")
    private Integer paintingId;
    @Column(name = "artist_id")
    private Integer artistId;

    public PaintingToArtistId() {
    }

    public PaintingToArtistId(Integer paintingId, Integer artistId) {
        this.paintingId = paintingId;
        this.artistId = artistId;
    }

    public Integer getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(Integer paintingId) {
        this.paintingId = paintingId;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }
}
