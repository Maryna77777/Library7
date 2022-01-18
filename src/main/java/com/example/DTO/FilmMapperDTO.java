package com.example.DTO;

import com.example.entity.Director;
import com.example.entity.Genre;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FilmMapperDTO {
    private long id;
    private String title;
    private int year;
    private String country;
    private List<ActorDTO> actorsList;

//    private List<Genre> genreList;
//    private List<Director> filmDirectorsList;
}
