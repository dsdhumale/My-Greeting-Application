package com.bridgelabz.GreetingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.GreetingApp.model.Greeting;

@Repository
public interface GreetingRepository  extends JpaRepository<Greeting, Long>{
    
}
