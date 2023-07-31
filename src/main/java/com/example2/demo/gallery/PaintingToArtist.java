package com.example2.demo.gallery;

import com.example2.demo.gallery.artist.repository.ArtistEntity;
import com.example2.demo.gallery.painting.repository.PaintingEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Painting_to_Artist")
//@IdClass(PaintingToArtistId.class)
public class PaintingToArtist implements Serializable {


    @EmbeddedId
    private PaintingToArtistId paintingToArtistId = new PaintingToArtistId();

    @ManyToOne
    @JoinColumn(name = "painting_id", nullable = false, insertable = false, updatable = false)
    private PaintingEntity painting;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false, insertable = false, updatable = false)
    private ArtistEntity artist;


    public PaintingToArtist() {
    }

    public PaintingToArtist(PaintingEntity painting, ArtistEntity artist) {
        this.paintingToArtistId = new PaintingToArtistId(painting.getId(), artist.getId());
        this.painting = painting;
        this.artist = artist;
    }

    public PaintingEntity getPainting() {
        return painting;
    }

    public void setPainting(PaintingEntity painting) {
        this.paintingToArtistId.setPaintingId(painting.getId());
        this.painting = painting;
    }

    public ArtistEntity getArtist() {
        return artist;
    }

    public void setArtist(ArtistEntity artist) {
        this.paintingToArtistId.setArtistId(artist.getId());
        this.artist = artist;
    }

    public PaintingToArtistId getPaintingToArtistId() {
        return paintingToArtistId;
    }

    public void setPaintingToArtistId(PaintingToArtistId paintingToArtistId) {
        this.paintingToArtistId = paintingToArtistId;
    }

    @Override
    public String toString() {
        return "PaintingToArtist{" +
                "paintingToArtistId=" + paintingToArtistId +
                ", painting=" + painting +
                ", artist=" + artist +
                '}';
    }
}
