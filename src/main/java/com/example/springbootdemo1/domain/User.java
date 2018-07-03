package com.example.springbootdemo1.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lufei on 18/4/9.
 */
@Table(name = "user")
public class User {
    @Id
    private String id;

    @Column(name = "user_name")
    private String username;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
