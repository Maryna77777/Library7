package com.example.DTO;

import com.example.entity.Actor;
import com.example.entity.Film;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@EnableTransactionManagement
@Getter
@Setter
public class FilmDTO {
    private long id;
    private String title;
    private int year;
    private String country;
    private List<ActorDTO> actorsList;

    @Transactional
    public List<FilmDTO> getFilmDTOList(List<Film> filmList){
        List<FilmDTO> filmDTOList = new ArrayList<>();

        for (Film film: filmList ){
            actorsList = new ArrayList<>();

            FilmDTO filmDTO = new FilmDTO();
            filmDTO.setId(film.getId());
            filmDTO.setTitle(film.getTitle());
            filmDTO.setYear(film.getYear());
            filmDTO.setCountry(film.getCountry());

            film.getActors().forEach((actor)->{
     //       for ( Actor actor : film.getActors()){
                ActorDTO actorsDTO = new ActorDTO();
                actorsDTO.setId(actor.getId());
                actorsDTO.setFirstName(actor.getFirstName());
                actorsDTO.setLastName(actor.getLastName());
                actorsList.add(actorsDTO);
            });
            filmDTO.setActorsList(actorsList);
            filmDTOList.add(filmDTO);
        }
        return filmDTOList;
    }

}
