package com.example.repository;

import com.example.entity.Film;
import com.example.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    Genre findByCategory(String category);
}

