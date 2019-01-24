package com.hackerrank.github.service;

import com.hackerrank.github.exception.ActorLoginUpdateNotAllowedException;
import com.hackerrank.github.exception.ActorNotFoundException;
import com.hackerrank.github.model.Actor;
import com.hackerrank.github.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by guilherme-lima on 24/01/19.
 * https://github.com/guilherme-lima
 */
@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    public Actor updateActorAvatarUrl(final Actor actor) {
        Optional<Actor> retrievedActor = actorRepository.findById(actor.getId());
        if (retrievedActor.isPresent())
            if (retrievedActor.get().getLogin().equals(actor.getLogin()))
                return actorRepository.save(actor);
            else
                throw new ActorLoginUpdateNotAllowedException();
        throw new ActorNotFoundException();
    }

    public List<Actor> findAllActorsOrderedByMaxEvents() {
        List<Sort.Order> orders = Arrays.asList(
                new Sort.Order(Sort.Direction.DESC, "eventsCount"),
                new Sort.Order(Sort.Direction.DESC, "latestEventTimeStamp"),
                new Sort.Order(Sort.Direction.ASC, "login")
        );
        return actorRepository.findAll(new Sort(orders));
    }

    public List<Actor> findAllActorsOrderedByMaxStreak() {
        return null;
    }
}