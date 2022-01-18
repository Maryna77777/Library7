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
@Table(name="director")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  @Column(name="DIRECTOR_ID")
    private long id;
    @Column(name = "firstNameDirector")
    private String firstNameDirector;
    @Column(name = "LAST_NAME_DIRECTOR")
    private String lastNameDirector;
    @Column(name = "NATIONALITY_DIRECTOR")
    private String nationalityDirector;
    //   @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "filmDirector")
    //   private Set <Film> films;
    @JsonIgnore
    @ManyToMany(mappedBy = "filmDirectors")
    private List<Film> films;

}
