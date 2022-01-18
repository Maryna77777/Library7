package com.example.service;

import com.example.DTO.ActorDTO;
import com.example.DTO.FilmDTO;
import com.example.DTO.FilmMapperDTO;
import com.example.entity.Actor;
import com.example.entity.Director;
import com.example.entity.Film;
import com.example.entity.Genre;
import com.example.mapper.FilmMapper;

import com.example.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    public List<Film> saveFilm(List<Film> films) {
        return filmRepository.saveAll(films);
    }

//    public Film createFilmAndActor (Film film,Actor actor) {
//      //  film.getActors().addAll((Collection<? extends Actor>) actor);
//        film.getActors().add(actor);
//        actor.getFilms().add(film);
//        return filmRepository.save(film);
//    }

    public List<FilmMapperDTO> getAllFilm1() {
        List<FilmMapperDTO> filmMapperDTOList = new ArrayList<>();
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

    public List<FilmDTO> getAllFilmActor() {
        FilmDTO filmDTO = new FilmDTO();
        return filmDTO.getFilmDTOList(filmRepository.findAll(Sort.by("title")));
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
//        for (Film film : filmRepository.findByCategory (category)) {
//            System.out.println(film.toString());
//        }
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

    public long countCategoryId(Long id) {
        return filmRepository.countFilmByCategoryById(id);
    }

    public long countCountry(String country) {
        return filmRepository.countFilmByCountry(country);
    }

    public long countYear( int year){
        return filmRepository.countFilmByYear(year);
    }



}

