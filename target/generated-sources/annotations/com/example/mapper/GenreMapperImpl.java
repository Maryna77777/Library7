package com.example.mapper;

import com.example.DTO.ActorDTO;
import com.example.DTO.FilmDTO;
import com.example.DTO.GenreDTO;
import com.example.entity.Actor;
import com.example.entity.Film;
import com.example.entity.Genre;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-18T16:58:20+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreDTO fromGenre(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDTO genreDTO = new GenreDTO();

        if ( genre.getId() != null ) {
            genreDTO.setId( genre.getId() );
        }
        genreDTO.setCategory( genre.getCategory() );
        genreDTO.setFilms( filmListToFilmDTOList( genre.getFilms() ) );

        return genreDTO;
    }

    protected List<FilmDTO> filmListToFilmDTOList(List<Film> list) {
        if ( list == null ) {
            return null;
        }

        List<FilmDTO> list1 = new ArrayList<FilmDTO>( list.size() );
        for ( Film film : list ) {
            list1.add( filmToFilmDTO( film ) );
        }

        return list1;
    }

    protected ActorDTO actorToActorDTO(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        ActorDTO actorDTO = new ActorDTO();

        actorDTO.setId( actor.getId() );
        actorDTO.setFirstName( actor.getFirstName() );
        actorDTO.setLastName( actor.getLastName() );
        actorDTO.setFilms( filmListToFilmDTOList( actor.getFilms() ) );

        return actorDTO;
    }

    protected List<ActorDTO> actorListToActorDTOList(List<Actor> list) {
        if ( list == null ) {
            return null;
        }

        List<ActorDTO> list1 = new ArrayList<ActorDTO>( list.size() );
        for ( Actor actor : list ) {
            list1.add( actorToActorDTO( actor ) );
        }

        return list1;
    }

    protected FilmDTO filmToFilmDTO(Film film) {
        if ( film == null ) {
            return null;
        }

        FilmDTO filmDTO = new FilmDTO();

        if ( film.getId() != null ) {
            filmDTO.setId( film.getId() );
        }
        filmDTO.setTitle( film.getTitle() );
        filmDTO.setYear( film.getYear() );
        filmDTO.setCountry( film.getCountry() );
        filmDTO.setActors( actorListToActorDTOList( film.getActors() ) );

        return filmDTO;
    }
}
