package com.hackerrank.github.controller.dto;

import lombok.Data;

/**
 * Created by guilherme-lima on 24/01/19.
 * https://github.com/guilherme-lima
 */
@Data
public class RepoDto {

    private Long id;
    private String name;
    private String url;
}