package com.hackerrank.github.exception;

/**
 * Created by guilherme-lima on 23/01/19.
 * https://github.com/guilherme-lima
 */
public class ActorNotFoundException extends RuntimeException {

    public ActorNotFoundException() {
        super("Actor not found.");
    }
}