package com.bridgelabz.GreetingApp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.GreetingApp.model.Greeting;
import com.bridgelabz.GreetingApp.service.GreetingService;
import com.bridgelabz.GreetingApp.service.IGreeting;

@RestController
public class MyGreetingController {

    @Autowired
    private GreetingService greetingService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @GetMapping(value = {"/greeting", "/greeting/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/param/{name}")
    public Greeting greetingParam(@PathVariable String name){
        return new Greeting(counter.incrementAndGet(),
                   String.format(template, name));
    }

    @GetMapping("/simple")
    public String newGreeting(){
        return greetingService.newGreeting();

    }

    
}
