package com.hackerrank.github.service;

import com.hackerrank.github.exception.EventAlreadyExistsException;
import com.hackerrank.github.exception.EventNotFoundException;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guilherme-lima on 24/01/19.
 * https://github.com/guilherme-lima
 */
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public void eraseAllEvents() {
        eventRepository.deleteAll();
    }

    public Event addEvent(final Event event) {
        if (eventRepository.exists(event.getId()))
            throw new EventAlreadyExistsException();
        return eventRepository.save(event);
    }

    public List<Event> findAllEvents() {
        return eventRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

    public List<Event> findAllEventsByActorId(final long actorId) {
        List<Event> eventList = eventRepository.findAllByActor_Id(actorId);
        if (eventList.isEmpty())
            throw new EventNotFoundException();
        return eventList;
    }
}