package com.example.mapper;

import com.example.DTO.FilmMapperDTO;
import com.example.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper/*(uses = ActorMapper.class)*/

public interface FilmMapper {

    FilmMapper FILM_MAPPER = Mappers.getMapper(FilmMapper.class);

//    @Mapping(source = "actors", target = "actorsList")
//    @Mappings({
//            @Mapping(source = "actors", target = "actorsList"),
//            @Mapping(source = "genres", target = "genresList"),
//            @Mapping(source = "filmDirectors", target = "filmDirectorsList"),
//
//    })
    FilmMapperDTO fromFilm(Film film);
}
