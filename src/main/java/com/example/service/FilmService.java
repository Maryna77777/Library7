package com.example.service;


import com.example.DTO.FilmDTO;
import com.example.entity.Film;
import com.example.mapper.FilmMapper;

import com.example.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    public List<Film> saveFilm(List<Film> films) {
        return filmRepository.saveAll(films);
    }


    public List<FilmDTO> getAllFilmsWithActors() {
        List<FilmDTO> filmMapperDTOList = new ArrayList<>();
        List<Film> filmList = filmRepository.findAll();
        for (Film film : filmList) {
            filmMapperDTOList.add(FilmMapper.FILM_MAPPER.fromFilm(film));
        }
        return filmMapperDTOList;
    }

    public List<Film> getFilm() {
        System.out.println(filmRepository.findAll().size());
        return filmRepository.findAll(Sort.by("title"));
    }

    public Page<Film> getFilmPage(Pageable pageable) {
        return filmRepository.findAll(pageable);
    }

    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    public Film getByTitle(String title) {
        return filmRepository.findByTitle(title);
    }


    public List<Film> findByYear(int year) {
        System.out.println(filmRepository.findByYear(year).size());
        return filmRepository.findByYear(year);
    }

    public List<Film> getByCountry(String country) {
        System.out.println(filmRepository.findByCountry(country).size());
        return filmRepository.findByCountry(country);
    }

    public List<Film> getFilmActor(String lastName) {
        return filmRepository.findByLastName(lastName);
    }

    public List<Film> getByLikeTitle(String title) {
        System.out.println(filmRepository.findByLikeTitle(title).size());
        return filmRepository.findByLikeTitle(title);
    }

    public List<Film> getFilmGenre(String category) {
        System.out.println(filmRepository.findByCategory(category).size());
        return filmRepository.findByCategory(category);
    }

    public List<Film> getFilmDirector(String lastNameDirector) {
        System.out.println(filmRepository.findByLastNameDirector(lastNameDirector, Sort.by("year")).size());
        return filmRepository.findByLastNameDirector(lastNameDirector, Sort.by("year"));
    }

    public String deleteFilm(Long id) {
        filmRepository.deleteById(id);
        return "product removed !! " + id;
    }

    public Film updateFilm(Film film) {
        Film existingFilm = filmRepository.findById(film.getId()).orElse(null);
        existingFilm.setTitle(film.getTitle());
        existingFilm.setYear(film.getYear());
        existingFilm.setCountry(film.getCountry());
        return filmRepository.save(existingFilm);
    }

    public long countCategory(String category) {
        return filmRepository.countFilmByCategory(category);
    }

    public long countCountry(String country) {
        return filmRepository.countFilmByCountry(country);
    }

    public long countYear( int year){
        return filmRepository.countFilmByYear(year);
    }



}

