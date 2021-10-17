package ru.vvuri.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMyApplication {

    public static void main(String[] args) {
        // создается основной Spring context и в него передаются аргументы
        SpringApplication.run(SpringBootMyApplication.class, args);
    }
}
