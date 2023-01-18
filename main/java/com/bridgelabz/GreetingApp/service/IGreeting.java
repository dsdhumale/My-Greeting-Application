package com.bridgelabz.GreetingApp.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.GreetingApp.model.Greeting;
import com.bridgelabz.GreetingApp.dto.User;

public interface IGreeting {

    public Greeting newGreeting(String name);

    public Greeting addGreeting(User user);

    public Optional<Greeting> findGreeting(long id);

    public List<Greeting> findAllGreeting();

    public void deleteGreetingId(long id);
}
