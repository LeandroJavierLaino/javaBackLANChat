package com.messages;

import org.springframework.data.annotation.Id;

public class Message {
    @Id
    private String id;

    private String username;
    private String userMessage;

    public Message(String username, String userMessage) {
        this.username = username;
        this.userMessage = userMessage;
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
        return String.format("Message[ id='%s', username='%s', userMessage='%s']", this.id, this.username,
                this.userMessage);
    }

}
