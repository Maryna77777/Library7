package com.example.service;

import com.example.DTO.DirectorDTO;
import com.example.DTO.FilmDTO;
import com.example.entity.Director;
import com.example.entity.Film;
import com.example.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    public Director saveDirector(Director director) {
        return   directorRepository.save(director);
    }

    public List<Director> saveDirectors(List<Director> directors) {
        return directorRepository.saveAll(directors);
    }



    public Director getDirectorById(Long id) {
        return directorRepository.findById(id).orElse(null);
    }

    public Director getDirectorByLastName(String lastNameDirector) {
        return directorRepository.findByLastNameDirector(lastNameDirector);
    }

    public Director updateDirector (Director director) {
        Director existingDirector = directorRepository.findById(director.getId()).orElse(null);
        existingDirector.setFirstNameDirector (director.getFirstNameDirector());
        existingDirector.setLastNameDirector(director.getLastNameDirector());
        existingDirector.setNationalityDirector(director.getNationalityDirector());
        return directorRepository.save(existingDirector);
    }

    public String deleteDirector(Long id) {
        directorRepository.deleteById(id);
        return "product removed !! " + id;
    }

    public List<Director> getDirector() {

        return directorRepository.findAll(Sort.by("lastNameDirector"));
    }

    public List<DirectorDTO> getAllDirectorFilm() {
        DirectorDTO directorDTO = new DirectorDTO();
        return directorDTO.getDirectorDTOList(directorRepository.findAll());
    }

    public Page<Director> getDirectorPage(Pageable pageable) {
        return directorRepository.findAll(pageable) ;
    }
}
