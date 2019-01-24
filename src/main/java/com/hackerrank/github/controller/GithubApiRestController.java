package com.hackerrank.github.controller;

import com.hackerrank.github.controller.dto.ActorDto;
import com.hackerrank.github.controller.dto.DtoConverter;
import com.hackerrank.github.controller.dto.EventDto;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.service.ActorService;
import com.hackerrank.github.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by guilherme-lima on 23/01/19.
 * https://github.com/guilherme-lima
 */
@RestController
@RequiredArgsConstructor
public class GithubApiRestController {

    private static final String ERASE_EVENTS_ENDPOINT = "/eraseAllEvents";
    private static final String EVENTS_ENDPOINT = "/events";
    private static final String EVENTS_BY_ACTOR_ID_ENDPOINT = "/events/actors/{actorId}";
    private static final String ACTORS_ENDPOINT = "/actors";
    private static final String ACTORS_MAX_STREAK_ENDPOINT = "/actors/streak";

    private final DtoConverter dtoConverter;
    private final EventService eventService;
    private final ActorService actorService;

    @DeleteMapping(ERASE_EVENTS_ENDPOINT)
    @ResponseStatus(HttpStatus.OK)
    public void eraseAllEvents() {
        eventService.eraseAllEvents();
    }

    @PostMapping(EVENTS_ENDPOINT)
    @ResponseStatus(HttpStatus.CREATED)
    public EventDto add(@RequestBody @Valid final EventDto eventDto) {
        return dtoConverter.convertToDto(eventService.addEvent(dtoConverter.convertToEntity(eventDto)));
    }

    @GetMapping(EVENTS_ENDPOINT)
    @ResponseStatus(HttpStatus.OK)
    public List<EventDto> findAll() {
        return eventService.findAllEvents()
                .stream()
                .map(dtoConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(EVENTS_BY_ACTOR_ID_ENDPOINT)
    @ResponseStatus(HttpStatus.OK)
    public List<EventDto> findByActorId(@PathVariable long actorId) {
        return eventService.findAllEventsByActorId(actorId)
                .stream()
                .map(dtoConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @PutMapping(ACTORS_ENDPOINT)
    @ResponseStatus(HttpStatus.OK)
    public ActorDto updateActorAvatarUrl(@RequestBody final ActorDto actorDto) {
        return dtoConverter.convertToDto(actorService.updateActorAvatarUrl(dtoConverter.convertToEntity(actorDto)));
    }

    @GetMapping(ACTORS_ENDPOINT)
    public List<ActorDto> findAllActorsOrderedByMaxEvents() {
        return actorService.findAllActorsOrderedByMaxEvents()
                .stream()
                .map(dtoConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(ACTORS_MAX_STREAK_ENDPOINT)
    public List<ActorDto> findAllActorsOrderedByMaxStreak() {
        return actorService.findAllActorsOrderedByMaxStreak()
                .stream()
                .map(dtoConverter::convertToDto)
                .collect(Collectors.toList());
    }
}