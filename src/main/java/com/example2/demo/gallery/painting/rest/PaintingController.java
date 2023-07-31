package com.example2.demo.gallery.painting.rest;

import com.example2.demo.gallery.painting.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaintingController {
    @Autowired
    private PaintingService paintingService;

    @PostMapping("/painting")
    public void createPainting(@RequestBody Painting painting) {
        paintingService.createPainting(painting);
    }

    @GetMapping("/paintings/all")
    public List<Painting> getAllPaintings() {
        return paintingService.getAllPaintings();
    }

    @GetMapping("/painting")
    public Painting getPainting(@RequestParam(value = "id") Integer id) {
        return paintingService.getPainting(id);
    }

    @PutMapping("/painting/modify/{id}")
    public void modifyPainting(@PathVariable Integer id, @RequestBody Painting painting) {
        paintingService.modifyPainting(id, painting);
    }

    @DeleteMapping("/painting/delete")
    public void deletePainting(@RequestParam(value = "id") Integer id) {
        paintingService.deletePainting(id);
    }

    @PutMapping("/artist-to-painting")
    public void artistToPainting(@RequestParam(value = "id-painting") Integer idPainting, @RequestParam
            (value = "id-artist") Integer idArtist) {
        paintingService.artistToPainting(idPainting, idArtist);
    }

    @DeleteMapping("/delete/connection")
    public void deleteConnection(@RequestParam(value = "id-painting") Integer idPainting, @RequestParam
            (value = "id-artist") Integer idArtist) {
        paintingService.deleteConnection(idPainting, idArtist);
    }
}