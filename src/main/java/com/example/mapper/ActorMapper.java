package com.example.mapper;


import com.example.DTO.ActorDTO;
import com.example.entity.Actor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ActorMapper {
    ActorMapper ACTOR_MAPPER = Mappers.getMapper(ActorMapper.class);
    ActorDTO fromActor(Actor actor);
//    @InheritInverseConfiguration
//    Actor toActor(ActorMapperDTO actorMapperDTO);
}
