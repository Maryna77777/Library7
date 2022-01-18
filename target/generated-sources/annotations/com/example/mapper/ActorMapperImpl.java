package com.example.mapper;

import com.example.DTO.ActorDTO;
import com.example.entity.Actor;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-18T14:11:36+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
public class ActorMapperImpl implements ActorMapper {

    @Override
    public ActorDTO fromActor(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        ActorDTO actorDTO = new ActorDTO();

        actorDTO.setId( actor.getId() );
        actorDTO.setFirstName( actor.getFirstName() );
        actorDTO.setLastName( actor.getLastName() );

        return actorDTO;
    }
}
