package com.hackerrank.github.exception;

/**
 * Created by guilherme-lima on 23/01/19.
 * https://github.com/guilherme-lima
 */
public class EventAlreadyExistsException extends RuntimeException {

    public EventAlreadyExistsException() {
        super("An event with the same id already exists.");
    }
}