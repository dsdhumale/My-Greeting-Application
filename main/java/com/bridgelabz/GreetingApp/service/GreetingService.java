package com.bridgelabz.GreetingApp.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.GreetingApp.model.Greeting;
import com.bridgelabz.GreetingApp.model.User;
import com.bridgelabz.GreetingApp.repository.GreetingRepository;

@Service
public class GreetingService implements IGreeting {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepo;

    public Greeting newGreeting(String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @Override
    public Greeting addGreeting(User user) {
        System.out.println("Testing" + user.getFirstName().isEmpty());
        if (user.getFirstName().isEmpty()) {
            String msg = "World";
            user.setFirstName(msg);
            return greetingRepo
                    .save(new Greeting(counter.incrementAndGet(), String.format(template, user.getFirstName())));
        } else {
            return greetingRepo
                    .save(new Greeting(counter.incrementAndGet(), String.format(template, user.getFirstName())));
        }

    }

    
    @Override
    public Optional<Greeting> findGreeting(long id) {
        return greetingRepo.findById(id);
    }

    @Override
    public List<Greeting> findAllGreeting() {
        return greetingRepo.findAll();
    }

}
