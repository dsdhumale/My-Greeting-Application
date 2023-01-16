package com.bridgelabz.GreetingApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Greeting {
    @Id
    private long id;
    private String message;

    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }
    public Greeting(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Greeting addGreeting(Greeting greet) {
        return null;
    }
}
