package com.bridgelabz.GreetingApp.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.GreetingApp.model.Greeting;
import com.bridgelabz.GreetingApp.model.User;
import com.bridgelabz.GreetingApp.service.GreetingService;
import com.bridgelabz.GreetingApp.service.IGreeting;

@RestController
public class MyGreetingController {

    @Autowired
    private IGreeting greet;

    @Autowired
    private GreetingService greetingService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = { "/greeting", "/greeting/home" })
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/param/{name}")
    public Greeting greetingParam(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @GetMapping("/simple")
    public Greeting newGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return greet.newGreeting(name);
    }

    @PostMapping("/add")
    public Greeting addGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setFirstName(name);
        return greet.addGreeting(user);
    }

    @GetMapping("/{id}")
    public Optional<Greeting> findGreeting(@PathVariable long id){
        return greet.findGreeting(id);
    }

    @GetMapping("/findAll")
    public List<Greeting> findAllGreeting(){
        return greet.findAllGreeting();
    }


}
