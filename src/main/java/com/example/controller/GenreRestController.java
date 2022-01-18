package com.example.controller;

import com.example.DTO.GenreDTO;
import com.example.entity.Genre;
import com.example.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreRestController {
    @Autowired
    GenreService genreService;

    @GetMapping("/allGenreFilm")
    public List<GenreDTO> findAllGenreFilm(){

        return genreService.getAllGenreFilm();
    }

    @PostMapping("/addGenre")
    public Genre addGenre (@RequestBody Genre genre) {
        return genreService.saveGenre (genre);
    }

    @GetMapping("/allGenres")
    public List<Genre> findAllGenres() {
        return genreService.getGenre ();
    }

    @GetMapping("/genreById/{id}")
    public Genre findGenreById(@PathVariable Long id) {
        return genreService.getGenreById(id);
    }

      @PutMapping("/updateGenre")
    public Genre updateGenre(@RequestBody Genre genre) {
        return genreService.updateGenre(genre);
    }

}
