package com.example.repository;

import com.example.entity.Film;
import com.example.entity.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public interface FilmRepository extends JpaRepository <Film,Long> {

//    List<Film> findAll(Sort sort );

    Page<Film> findAll(Pageable pageable);

    Film findByTitle(String title);

    @Query("select f from Film f where f.title like %:title%")
    List<Film> findByLikeTitle(@Param("title") String title);


    @Query("select  f from Film f join f.genres g where g.category = :category")
    List<Film> findByCategory(@Param("category") String category);

    @Query("select  f from Film f join f.filmDirectors d where d.lastNameDirector = :lastNameDirector  ")
    List<Film> findByLastNameDirector(@Param("lastNameDirector") String lastNameDirector, Sort sort);

    List<Film> findByYear(int year);
    //@Query("select f from Film f join f.filmDirectors d where  f.year=:year ")
    //     List<Film> findByYear(@Param("year") int year, Sort sort) ;

    List<Film> findByCountry(String country);

  // Film updateFilmActor (Film film);

    @Query("select  f from Film f join f.actors a where  a.lastName = :lastName")
    List<Film> findByLastName(@Param("lastName") String lastName);

}





