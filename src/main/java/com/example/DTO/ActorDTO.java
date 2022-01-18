package com.example.DTO;

import com.example.entity.Actor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@Getter
@Setter
public class ActorDTO {
    private long id;
    private String firstName;
    private String lastName;
    private List<FilmDTO> filmsList;

    @Transactional
    public List<ActorDTO> getActorDTOList(List<Actor> actorsList) {
        List<ActorDTO> actorDTOList = new ArrayList<>();
        for (Actor actor : actorsList) {
            filmsList = new ArrayList<>();
            ActorDTO actorDTO = new ActorDTO();
            actorDTO.setId(actor.getId());
            actorDTO.setFirstName(actor.getFirstName());
            actorDTO.setLastName(actor.getLastName());

            actor.getFilms().forEach((film)->{
         //   for (Film film : actor.getFilms()) {
                FilmDTO filmsDTO = new FilmDTO();
                filmsDTO.setId(film.getId());
                filmsDTO.setTitle(film.getTitle());
                filmsDTO.setYear(film.getYear());
                filmsDTO.setCountry(film.getCountry());
                filmsList.add(filmsDTO);
            });
            actorDTO.setFilmsList(filmsList);
            actorDTOList.add(actorDTO);
        }
        return actorDTOList;
    }
}

