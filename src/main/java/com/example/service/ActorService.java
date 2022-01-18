package com.example.service;

import com.example.DTO.ActorDTO;
import com.example.entity.Actor;
import com.example.repository.ActorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public List<Actor> saveActor(List<Actor> actors) {
        return actorRepository.saveAll(actors);
    }

    public List<Actor> getActor() {
        System.out.println(actorRepository.findAll().size());
        return actorRepository.findAll();
    }

    public Actor getActorById(Long id) {
        return actorRepository.findById(id).orElse(null);
    }

    public Actor getActorByLastName(String lastName) {
        return actorRepository.findByLastName(lastName);
    }

    public List<Actor> findActorFilm (String title){return actorRepository.findActorByFilm(title);}

    public Actor updateActor (Actor actor) {
        Actor existingActor = actorRepository.findById(actor.getId()).orElse(null);
        existingActor.setFirstName (actor.getFirstName());
        existingActor.setLastName(actor.getLastName());
        existingActor.setNationality(actor.getNationality());
        return actorRepository.save(existingActor);
    }

    public String deleteActor(Long id) {
        actorRepository.deleteById(id);
        return "product removed !! " + id;
    }
}
