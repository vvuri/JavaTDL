package ru.vvuri.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.vvuri.springboot.SpringBootMyApplication;

import static org.testng.Assert.*;

@ActiveProfiles("test")  // find resources/application-test.yml and overwrite on application.yml
@SpringBootTest(classes = SpringBootMyApplication.class)
public class GreetingServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private GreetingService greetingService;

    @BeforeClass
    public void setUp() {
    }

    @AfterClass
    public void tearDown() {
    }

    @Test
    public void  testGreeting() {
        String expectedMessage = "Hello World test";
        assertEquals(expectedMessage, this.greetingService.greeting());
    }
}