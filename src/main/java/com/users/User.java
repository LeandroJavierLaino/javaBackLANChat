package com.users;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;

    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format("User [ id='%s',  username='%s' ]", this.id, this.username);
    }
}
