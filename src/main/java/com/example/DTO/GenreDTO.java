package com.example.DTO;


import com.example.entity.Actor;
import com.example.entity.Genre;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@Getter
@Setter
public class GenreDTO {
    private long id;
    private String category;
    private List<FilmDTO> filmsList;

    @Transactional
    public List<GenreDTO> getGenreDTOList(List<Genre> genreList) {
        List<GenreDTO> genreDTOList = new ArrayList<>();
        for (Genre genre : genreList) {
            filmsList = new ArrayList<>();
            GenreDTO genreDTO = new GenreDTO();
            genreDTO.setId(genre.getId());
            genreDTO.setCategory(genre.getCategory());

            genre.getFilms().forEach((film)->{

                FilmDTO filmsDTO = new FilmDTO();
                filmsDTO.setId(film.getId());
                filmsDTO.setTitle(film.getTitle());
                filmsDTO.setYear(film.getYear());
                filmsDTO.setCountry(film.getCountry());
                filmsList.add(filmsDTO);
            });
            genreDTO.setFilmsList(filmsList);
            genreDTOList.add(genreDTO);
        }
        return genreDTOList;
    }

}
