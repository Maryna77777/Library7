package com.example.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ActorDTO {
    private long id;
    private String firstName;
    private String lastName;
    private List<FilmDTO> films;
}
