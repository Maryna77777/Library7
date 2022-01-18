package com.example.DTO;



import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@EnableTransactionManagement
@Getter
@Setter
public class GenreDTO {
    private long id;
    private String category;
    private List<FilmDTO> films;

}
