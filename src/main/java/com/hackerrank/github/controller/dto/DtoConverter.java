package com.hackerrank.github.controller.dto;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Created by guilherme-lima on 24/01/19.
 * https://github.com/guilherme-lima
 */
@Component
@RequiredArgsConstructor
public class DtoConverter {

    private final ModelMapper modelMapper;

    public Event convertToEntity(EventDto eventDto) {
        return modelMapper.map(eventDto, Event.class);
    }

    public EventDto convertToDto(Event event) {
        return modelMapper.map(event, EventDto.class);
    }

    public Actor convertToEntity(ActorDto actorDto) {
        return modelMapper.map(actorDto, Actor.class);
    }

    public ActorDto convertToDto(Actor actor) {
        return modelMapper.map(actor, ActorDto.class);
    }
}