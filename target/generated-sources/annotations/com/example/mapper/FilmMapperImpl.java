package com.example.mapper;

import com.example.DTO.FilmMapperDTO;
import com.example.entity.Film;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-03T12:52:54+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
public class FilmMapperImpl implements FilmMapper {

    @Override
    public FilmMapperDTO fromFilm(Film film) {
        if ( film == null ) {
            return null;
        }

        FilmMapperDTO filmMapperDTO = new FilmMapperDTO();

        if ( film.getId() != null ) {
            filmMapperDTO.setId( film.getId() );
        }
        filmMapperDTO.setTitle( film.getTitle() );
        filmMapperDTO.setYear( film.getYear() );
        filmMapperDTO.setCountry( film.getCountry() );

        return filmMapperDTO;
    }
}
