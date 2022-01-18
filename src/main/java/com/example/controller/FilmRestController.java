package com.example.controller;

import com.example.DTO.FilmDTO;
import com.example.DTO.FilmMapperDTO;
import com.example.entity.Actor;
import com.example.entity.Director;
import com.example.entity.Film;
import com.example.repository.FilmRepository;
import com.example.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/film")
public class FilmRestController {

    @Autowired
    private FilmService service;
    @Autowired
    private FilmRepository filmRepository;

    @PostMapping("/addFilm")
    public Film addFilm(@Valid @RequestBody Film film, BindingResult bindingResult) {
        return service.saveFilm(film);
    }

//    @PostMapping("/addFilmA")
//    public Film addFilmA (@Valid @RequestBody Film film, BindingResult bindingResult) {
//        return service.save1(film);
//    }
//    @PostMapping("/addFilmAct")
//    public List<Film> addFilmsAct (@Valid @RequestBody List<Film> filmList, BindingResult bindingResult) {
//        return service.save2(filmList);
//    }

    @PostMapping("/addFilms")
    public List<Film> addFilms(@RequestBody @Valid List<Film> filmList) {
        return service.saveFilm(filmList);
    }

    @GetMapping("/allFilms")
    public List<Film> findAllFilms() {
        return service.getFilm();
    }

    @GetMapping("/all")
    public List<FilmDTO> getAllFilm() {

        return service.getAllFilmActor();
    }

    @GetMapping("/all1")
    public List<FilmMapperDTO> getAllFilms() {
        return service.getAllFilm1();
    }

    @GetMapping("/allFilmsPage")
    public Page<Film> findAllFilmPage(@PageableDefault(sort = "title", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.getFilmPage(pageable);
    }

    @GetMapping("/filmById/{id}")
    public Film findFilmById(@PathVariable Long id) {
        return service.getFilmById(id);
    }

    @GetMapping("/findByLikeTitle/{title}")
    public List<Film> findByLikeTitle(@PathVariable String title) {
        return service.getByLikeTitle(title);
    }

    @GetMapping("/findByCountry/{country}")
    public List<Film> findByCountry(@PathVariable String country) {
        return service.getByCountry(country);
    }

    @GetMapping("/filmByTitle/{title}")
    public Film findFilmByTitle(@PathVariable String title) {
        return service.getByTitle(title);
    }

    @PutMapping("/updateFilm")
    @RequestMapping(value = "/updateFilm", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Film updateFilm(@Valid @RequestBody Film film, BindingResult bindingResul) {
        return service.updateFilm(film);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Long id) {
        return service.deleteFilm(id);
    }

    @GetMapping("/filmByYear/{year}")
    public List<Film> findFilmByYear(@PathVariable int year) {
        return service.findByYear(year);
    }

    @GetMapping("/findFilmGenre/{category}")
    public List<Film> findFilmGenre(@PathVariable String category) {
        return service.getFilmGenre(category);
    }

    @GetMapping("/count/FilmGenre/{category}")
    public long countFilmGenre(@PathVariable String category) {
        return service.countCategory(category);
    }

    @GetMapping("/count/FilmGenreId/{id}")
    public long countFilmGenre(@PathVariable Long id) {
        return service.countCategoryId(id);
    }

    @GetMapping("/count/FilmCountry/{country}")
    public long countFilmCountry(@PathVariable String country) {
        return service.countCountry(country);
    }

    @GetMapping("/count/FilmYear/{year}")
    public long countFilmYear(@PathVariable int year ) {
        return service.countYear(year);
    }

    @GetMapping("/findFilmActor/{lastName}")
    public List<Film> findFilmActor(@PathVariable String lastName) {
        return service.getFilmActor(lastName);
    }

    @GetMapping("/findFilmDirector/{lastNameDirector}")
    public List<Film> findFilmDirector(@PathVariable String lastNameDirector) {
        return service.getFilmDirector(lastNameDirector);
    }

//    @GetMapping("count")
//    public  long countFilm(){
//        return service.count();
//    }



}
//    @RequestMapping(value = "/addFilm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity <Film> addFilm (@Valid @RequestBody Film film, BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//        {
//            bindingResult
//                    .getFieldErrors()
//                    .forEach(f -> System.out.println(f.getField() + ": " + f.getDefaultMessage()));
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//        this.service.saveFilm(film);
//        return new ResponseEntity<>(film, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/createFilmGenre")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Film createFilmGenre(@RequestBody Film film) {
//        return service.createFilm (film);
//    }


//    @PostMapping("/addFilmAndActor1")
//    @RequestMapping(value = "/addFilmActor",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public Film addFilmAndActor1 (@RequestBody Film film) {
//        return service.saveFilmAndActor(film);
//    }

//    @PostMapping("/addFilmActor")
//    @RequestMapping(value = "/addFilmActor",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public Film addFilmAndActor (@RequestBody Film film, Actor actor) {
//        return service.createFilmAndActor(film, actor);
//    }

//    @PostMapping("/saveFA")
//    public Film saveFA (@RequestBody Film film){
//        return service.createFA(film);
//    }
//     @PutMapping("/updateFilmActor")
//    @RequestMapping(value = "/updateFilm", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public Film updateFilmActor (@Valid @RequestBody Film film, Actor actor, BindingResult bindingResul) {
//        return service.updateFilmActor(film, actor);
//    }
