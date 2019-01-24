package com.hackerrank.github.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by guilherme-lima on 24/01/19.
 * https://github.com/guilherme-lima
 */
@Data
public class EventDto {

    @NotNull
    private Long id;
    private String type;
    private ActorDto actor;
    private RepoDto repo;
    private Timestamp createdAt;
}