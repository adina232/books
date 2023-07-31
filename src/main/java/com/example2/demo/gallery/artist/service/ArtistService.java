package com.example2.demo.gallery.artist.service;

import com.example2.demo.gallery.PaintingToArtist;
import com.example2.demo.gallery.PaintingToArtistRepository;
import com.example2.demo.gallery.artist.repository.ArtistEntity;
import com.example2.demo.gallery.artist.repository.ArtistRepository;
import com.example2.demo.gallery.artist.rest.Artist;
import com.example2.demo.gallery.painting.repository.PaintingEntity;
import com.example2.demo.gallery.painting.repository.PaintingRepository;
import com.example2.demo.gallery.painting.rest.Painting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private PaintingRepository paintingRepository;

    @Autowired
    private PaintingToArtistRepository paintingToArtistRepository;

    public void createArtist(Artist artist) {
        ArtistEntity artistEntity = new ArtistEntity();
        artistEntity.setFirstName(artist.getFirstName());
        artistEntity.setLastName(artist.getLastName());
        artistEntity.setAge(artist.getAge());

        artistRepository.save(artistEntity);
    }

    public List<Artist> getAllArtists() {
        Iterable<ArtistEntity> all = artistRepository.findAll();
        List<Artist> response = new ArrayList<>();

        for (ArtistEntity artistEntity : all) {

            Artist artist = getArtist(artistEntity.getId());
            response.add(artist);
        }

        return response;
    }

    public Artist getArtist(Integer id) {
        Optional<ArtistEntity> artistEntity = artistRepository.findById(id);
        if (artistEntity.isPresent()) {
            Artist artist = new Artist();
            artist.setFirstName(artistEntity.get().getFirstName());
            artist.setLastName(artistEntity.get().getLastName());
            artist.setAge(artistEntity.get().getAge());

            List<PaintingToArtist> paintingToArtistList = paintingToArtistRepository.findAllByArtistId(id);
            List<Painting> paintingList = new ArrayList<>();

            for (PaintingToArtist paintingToArtist : paintingToArtistList) {
                PaintingEntity paintingEntity = paintingToArtist.getPainting();
                Painting painting = new Painting();
                painting.setTitle(paintingEntity.getTitle());
                painting.setDimensions(paintingEntity.getDimensions());
                paintingList.add(painting);
            }

            artist.setPaintingList(paintingList);
            return artist;
        }
        return null;
    }

    public void modifyArtist(Integer id, Artist artist) {
        Optional<ArtistEntity> artistEntity = artistRepository.findById(id);
        if (artistEntity.isPresent()) {
            ArtistEntity newArtistEntity = artistEntity.get();

            newArtistEntity.setLastName(artist.getLastName());
            newArtistEntity.setFirstName(artist.getFirstName());
            newArtistEntity.setAge(artist.getAge());

            artistRepository.save(newArtistEntity);
        }
    }

    public void deleteArtist(Integer id) {
        Optional<ArtistEntity> artistEntity = artistRepository.findById(id);
        if (artistEntity.isPresent()) {
            paintingToArtistRepository.deleteByArtistId(id);
            artistRepository.deleteById(id);
        }
    }
}
