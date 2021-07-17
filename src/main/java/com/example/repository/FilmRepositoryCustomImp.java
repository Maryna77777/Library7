//package com.example.repository;
//
//import com.example.entity.Film;
//import com.example.entity.Genre;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.Set;
//
//
//@Repository
//@Transactional
//public class FilmRepositoryCustomImp implements FilmRepositoryCustom {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public Film createFilm(Film film) {
//        for (Genre genre : film.getGenres()) {
//         //   genre.setFilms((Set<Film>) film);
  //              genre.setFilm(film);
//        }
//        entityManager.persist(film);
//        return film;
//    }


//@Transactional
//public long saveAFooAndBar() {
//        Foo foo = new Foo().setName("Foo 1");
//        Bar bar = new Bar().setName("Bar 1").setFoo(foo);
//        foo.getBars().add(bar);
//        return repository.save(foo).getId();
//        }
//
//@Transactional(readOnly = true)
//public void showFoo(long fooId) {
//        System.out.println(repository.findOne(fooId));
//        }
//
//@Transactional
//public void addNewBarToFoo(long fooId) {
//        Foo foo = repository.findOne(fooId);
//        foo.getBars().add(new Bar().setName("Bar 2").setFoo(foo));
//        }
//        }



//public Country update(int id, Country country) {
//        Country original = entityManager.find(Country.class, id);
//        if (original != null) {
//        original.setName(country.getName());
//        for (City city : original.getCities()) {
//        entityManager.remove(city);
//        }
//        original.getCities().clear();
//        for (City city : country.getCities()) {
//        city.setCountry(original);
//        original.getCities().add(city);
//        entityManager.persist(city);
//        }
//        entityManager.merge(original);
//        }
//        return original;
//        }
//}
