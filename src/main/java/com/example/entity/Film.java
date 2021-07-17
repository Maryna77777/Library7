package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="film")

public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=2, max=50, message = "Title should be between 2 and 50 character")
    @NotEmpty(message = "Title should not be empty")
    @Column(name = "title")
    private String title;

    @Min(value = 1888, message = "Year should be greater 1888")
    @Max(value = 2121)
    @Column(name = "year")
    private int year;

    @NotEmpty(message = "Country should not be empty")
    @Column(name = "country")
    private String country;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACTOR_ID")
    )
    private Set<Actor> actors;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_genre",
            joinColumns = @JoinColumn(name = "FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "GENRE_ID")
    )
    private Set <Genre> genres;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_director",
            joinColumns = @JoinColumn(name = "FILM_ID"),
            inverseJoinColumns = @JoinColumn(name = "DIRECTOR_ID")
    )
    private Set <Director> filmDirectors = new HashSet<>();

    public Film() {
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Director> getFilmDirectors() {
        return filmDirectors;
    }

    public void setFilmDirectors(Set<Director> filmDirectors) {
        this.filmDirectors = filmDirectors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                //  ", actors=" + actors +
                //   ", genres=" + genres +
                //  ", filmDirectors=" + filmDirectors +
                '}';
    }


}
