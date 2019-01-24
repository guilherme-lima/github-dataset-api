package com.hackerrank.github.model;

import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by guilherme-lima on 23/01/19.
 * https://github.com/guilherme-lima
 */
@Data
@Entity
public class Actor implements Serializable {

    @Id @GeneratedValue
    private Long id;
    private String login;
    private String avatar;
    @Formula("Select count(1) From Event Where actorId = ?")
    private int eventsCount;
    @Formula("Select max(createdAt) From Event Where actorId = ?")
    private Timestamp latestEventTimeStamp;


    public Actor() {
    }

    public Actor(Long id, String login, String avatar) {
        this.id = id;
        this.login = login;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}