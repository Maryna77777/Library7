package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="actor")
public class Actor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name="ACTOR_ID")
    private long id;
    @NotBlank
    @Column(name = "FIRST_NAME")
    private String firstName;
    @NotBlank
    @Column(name = "LAST_NAME")
    private String lastName;
    @NotBlank
    @Column(name = "NATIONALITY")
    private String nationality;
    @JsonIgnore
    @ManyToMany(mappedBy = "actors")
    private List<Film> films;

}
