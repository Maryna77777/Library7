package com.example.mapper;

import com.example.DTO.ActorMapperDTO;
import com.example.entity.Actor;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-03T12:52:54+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
public class ActorMapperImpl implements ActorMapper {

    @Override
    public ActorMapperDTO fromActor(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        ActorMapperDTO actorMapperDTO = new ActorMapperDTO();

        actorMapperDTO.setId( actor.getId() );
        actorMapperDTO.setFirstName( actor.getFirstName() );
        actorMapperDTO.setLastName( actor.getLastName() );

        return actorMapperDTO;
    }

    @Override
    public Actor toActor(ActorMapperDTO actorMapperDTO) {
        if ( actorMapperDTO == null ) {
            return null;
        }

        Actor actor = new Actor();

        actor.setId( actorMapperDTO.getId() );
        actor.setFirstName( actorMapperDTO.getFirstName() );
        actor.setLastName( actorMapperDTO.getLastName() );

        return actor;
    }
}
