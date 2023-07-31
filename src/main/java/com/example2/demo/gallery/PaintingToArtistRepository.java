package com.example2.demo.gallery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaintingToArtistRepository extends CrudRepository<PaintingToArtist, PaintingToArtistId> {
    void deleteByArtistId(Integer id);

    void deleteByPaintingId(Integer id);

    List<PaintingToArtist> findAllByPaintingId(Integer id);

    List<PaintingToArtist> findAllByArtistId(Integer id);
}
