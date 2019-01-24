package com.hackerrank.github.exception;

/**
 * Created by guilherme-lima on 24/01/19.
 * https://github.com/guilherme-lima
 */
public class ActorLoginUpdateNotAllowedException extends RuntimeException {

    public ActorLoginUpdateNotAllowedException() {
        super("Actor's login update is not allowed.");
    }
}