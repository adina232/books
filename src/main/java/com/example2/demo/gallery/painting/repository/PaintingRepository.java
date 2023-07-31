package com.example2.demo.gallery.painting.repository;

import com.example2.demo.gallery.painting.rest.Painting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaintingRepository extends CrudRepository<PaintingEntity, Integer> {
}
