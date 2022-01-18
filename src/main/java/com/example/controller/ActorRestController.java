package com.example.controller;


import com.example.DTO.ActorDTO;
import com.example.DTO.FilmDTO;
import com.example.entity.Actor;
import com.example.entity.Film;
import com.example.repository.ActorRepository;
import com.example.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorRestController {
    @Autowired
    ActorService actorService;

    @Autowired
    private ActorRepository actorRepository;

    @PostMapping("/addActor")
    public Actor addActor (@RequestBody Actor actor) {
        return actorService.saveActor(actor);
    }

    @GetMapping("/findActorFilm/{title}")
    public List<Actor> findActorFilm (@PathVariable String title){
        return actorService.findActorFilm(title);
    }

    @PostMapping("/addActors")
    public List<Actor> addActors(@RequestBody List<Actor> actorList) {
        return actorService.saveActor(actorList);
    }

    @GetMapping("/allActors")
    public List<Actor> findAllActors() {
        return actorService.getActor ();
    }

    @GetMapping("/actorsAll")
    public List<ActorDTO> getAllActor(){
        ActorDTO actorDTO = new ActorDTO();
        return actorDTO.getActorDTOList(actorRepository.findAll());
    }

    @GetMapping("/allActorsFilm")
    public List<ActorDTO> getAllActorFilm(){

        return actorService.getAllActorFilm();
    }

    @GetMapping("/actorById/{id}")
    public Actor findActorById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    @GetMapping("/actorByName/{lastName}")
    public Actor findActorByLastName(@PathVariable String lastName) {
        return actorService.getActorByLastName(lastName);
    }

    @PutMapping("/updateActor")
    public Actor updateActor(@RequestBody Actor actor) {
        return actorService.updateActor(actor);
    }

    @DeleteMapping("/deleteActor/{id}")
    public String deleteActor(@PathVariable Long id) {
        return actorService.deleteActor(id);
    }

}