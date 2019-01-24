package com.hackerrank.github.repository;

import com.hackerrank.github.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by guilherme-lima on 23/01/19.
 * https://github.com/guilherme-lima
 */
public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findById(long id);
    List<Event> findAllByActor_Id(long actorId);
}