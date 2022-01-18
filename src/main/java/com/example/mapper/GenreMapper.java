package com.example.mapper;


import com.example.DTO.GenreDTO;
import com.example.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface GenreMapper {
    GenreMapper Genre_MAPPER = Mappers.getMapper(GenreMapper.class);
    GenreDTO fromGenre(Genre genre);
}
