package com.hackerrank.github.repository;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.ActorEventCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by guilherme-lima on 23/01/19.
 * https://github.com/guilherme-lima
 */
public interface ActorRepository extends JpaRepository<Actor, Long> {

    Optional<Actor> findById(long id);
    @Query("")
    List<ActorEventCount> countActorsEvents();
}