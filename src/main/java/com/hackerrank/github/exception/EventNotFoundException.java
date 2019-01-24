package com.hackerrank.github.exception;

/**
 * Created by guilherme-lima on 23/01/19.
 * https://github.com/guilherme-lima
 */
public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException() {
        super("EventDto not found.");
    }
}