package org.example.data;

public class Message {
    User user;
    String message;

    public Message(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
