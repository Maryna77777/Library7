package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="director")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstNameDirector")
    private String firstNameDirector;
    @Column(name = "LAST_NAME_DIRECTOR")
    private String lastNameDirector;
    @Column(name = "NATIONALITY_DIRECTOR")
    private String nationalityDirector;
    @JsonIgnore
    @ManyToMany(mappedBy = "filmDirectors")
    private List<Film> films;

}
