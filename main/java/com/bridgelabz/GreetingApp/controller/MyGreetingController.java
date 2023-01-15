package com.bridgelabz.GreetingApp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.GreetingApp.model.Greeting;

@RestController
public class MyGreetingController {

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
    
    
}
