package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name= "GENRE_ID")
    private Long id;
    @Column(name = "CATEGORY")
    private String category;

    @JsonIgnore
    @ManyToMany(mappedBy = "genres")
    private List<Film> films;

}
