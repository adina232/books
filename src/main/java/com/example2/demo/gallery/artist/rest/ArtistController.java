package com.example2.demo.gallery.artist.rest;
import com.example2.demo.gallery.artist.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping("/artist")
    public void createArtist(@RequestBody Artist artist) {
        artistService.createArtist(artist);
    }

    @GetMapping("/artists/all")
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/artist")
    public Artist getArtist(@RequestParam(value = "id") Integer id) {
        return artistService.getArtist(id);
    }

    @PutMapping("/artist/modify/{id}")
    public void modifyArtist(@PathVariable Integer id, @RequestBody Artist artist) {
        artistService.modifyArtist(id, artist);
    }

    @DeleteMapping("/artist/delete")
    public void deleteArtist(@RequestParam(value = "id") Integer id) {
        artistService.deleteArtist(id);
    }
}
