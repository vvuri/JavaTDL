package ru.vvuri.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greeting() {
        return "Hello World";
    }

}
