package com.messages;

import org.springframework.data.annotation.Id;

public class Message {
    @Id
    private String id;

    private String username;
    private String userMessage;
    private String date;

    public Message(String username, String userMessage, String date) {
        this.username = username;
        this.userMessage = userMessage;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getMessage() {
        return this.userMessage;
    }

    @Override
    public String toString() {
        return String.format("Message[ id='%s', username='%s', userMessage='%s', date='%s']", this.id, this.username,
                this.userMessage, this.date);
    }

}
