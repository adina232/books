package com.example2.demo.gallery.painting.service;

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
public class PaintingService {

    @Autowired
    private PaintingRepository paintingRepository;
    @Autowired
    private PaintingToArtistRepository paintingToArtistRepository;
    @Autowired
    private ArtistRepository artistRepository;

    public void createPainting(Painting painting) {

        PaintingEntity paintingEntity = new PaintingEntity();
        paintingEntity.setTitle(painting.getTitle());
        paintingEntity.setDimensions(painting.getDimensions());

        paintingRepository.save(paintingEntity);

    }

    public List<Painting> getAllPaintings() {
        Iterable<PaintingEntity> all = paintingRepository.findAll();
        List<Painting> response = new ArrayList<>();

        for (PaintingEntity paintingEntity : all) {
            Painting painting = getPainting(paintingEntity.getId());
            response.add(painting);
        }
        return response;
    }

    public Painting getPainting(Integer id) {
        Painting painting = new Painting();
        Optional<PaintingEntity> paintingEntity = paintingRepository.findById(id);
        if (paintingEntity.isPresent()) {
            painting.setTitle(paintingEntity.get().getTitle());
            painting.setIdPainting(paintingEntity.get().getId());
            painting.setDimensions(paintingEntity.get().getDimensions());
            List<PaintingToArtist> allByPaintingId = paintingToArtistRepository.findAllByPaintingId(id);
            ArrayList<Artist> artists = new ArrayList<>();
            for (PaintingToArtist paintingToArtist : allByPaintingId) {
                ArtistEntity artistEntity = paintingToArtist.getArtist();
                Artist artist = new Artist();
                artist.setIdArtist(artistEntity.getId());
                artist.setAge(artistEntity.getAge());
                artist.setLastName(artistEntity.getLastName());
                artist.setFirstName(artistEntity.getFirstName());
                artists.add(artist);
            }
            painting.setArtistList(artists);

            return painting;
        }
        throw new RuntimeException("Invalid command");
    }

    public void modifyPainting(Integer id, Painting painting) {
        Optional<PaintingEntity> paintingEntity = paintingRepository.findById(id);
        if (paintingEntity.isPresent()) {
            PaintingEntity newPaintingEntity = paintingEntity.get();

            newPaintingEntity.setDimensions(painting.getDimensions());
            newPaintingEntity.setTitle(painting.getTitle());

            paintingRepository.save(newPaintingEntity);
        }
    }

    public void deletePainting(Integer id) {
        Optional<PaintingEntity> paintingEntity = paintingRepository.findById(id);
        if (paintingEntity.isPresent()) {
            paintingToArtistRepository.deleteByPaintingId(id);
            paintingRepository.deleteById(id);
        }
    }

    public void artistToPainting(Integer idPainting, Integer idArtist) {
        PaintingToArtist paintingToArtist = new PaintingToArtist();
        Optional<PaintingEntity> paintingEntity = paintingRepository.findById(idPainting);
        if (paintingEntity.isPresent()) {
            Optional<ArtistEntity> artistEntity = artistRepository.findById(idArtist);
            if (artistEntity.isPresent()) {
                paintingToArtist.setArtist(artistEntity.get());
                paintingToArtist.setPainting(paintingEntity.get());
                paintingToArtistRepository.save(paintingToArtist);
            } else throw new RuntimeException("Artist not on the list");
        } else throw new RuntimeException("Painting not on the list");
    }

    public void deleteConnection(Integer idPainting, Integer idArtist) {
        Optional<PaintingEntity> paintingEntity = paintingRepository.findById(idPainting);
        if (paintingEntity.isPresent()) {
            Optional<ArtistEntity> artistEntity = artistRepository.findById(idArtist);
            if (artistEntity.isPresent()) {
                PaintingToArtist paintingToArtist = new PaintingToArtist(paintingEntity.get(),
                        artistEntity.get());
                paintingToArtistRepository.delete(paintingToArtist);
            }
        }
    }
}
