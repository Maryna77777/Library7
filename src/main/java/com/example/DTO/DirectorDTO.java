package com.example.DTO;

import com.example.entity.Actor;
import com.example.entity.Director;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@Getter
@Setter
public class DirectorDTO {
    private long id;
    private String firstNameDirector;
    private String lastNameDirector;
    private List<FilmDTO> filmsList;


    @Transactional
    public List<DirectorDTO> getDirectorDTOList(List<Director> directorList) {
        List<DirectorDTO> directorDTOList = new ArrayList<>();
        for (Director director : directorList) {
            filmsList = new ArrayList<>();
            DirectorDTO directorDTO = new DirectorDTO();
            directorDTO.setId(director.getId());
            directorDTO.setFirstNameDirector(director.getFirstNameDirector());
            directorDTO.setLastNameDirector(director.getLastNameDirector());

            director.getFilms().forEach((film)->{
                FilmDTO filmsDTO = new FilmDTO();
                filmsDTO.setId(film.getId());
                filmsDTO.setTitle(film.getTitle());
                filmsDTO.setYear(film.getYear());
                filmsDTO.setCountry(film.getCountry());
                filmsList.add(filmsDTO);
            });
            directorDTO.setFilmsList(filmsList);
            directorDTOList.add(directorDTO);
        }
        return directorDTOList;
    }
}
