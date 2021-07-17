package com.example.controller;


import com.example.entity.Genre;
import com.example.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreRestController {
    @Autowired
    GenreService genreService;

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

    @GetMapping("/genreByCategory/{category}")
    public Genre findGenreByCategory(@PathVariable String category) {
        return genreService.getGenreByCategory(category);
    }

    @PutMapping("/updateGenre")
    public Genre updateGenre(@RequestBody Genre genre) {
        return genreService.updateGenre(genre);
    }

}
