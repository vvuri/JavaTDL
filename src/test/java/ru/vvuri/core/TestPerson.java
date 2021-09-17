package test.java.ru.vvuri.core;

import main.java.ru.vvuri.core.Person;
import org.testng.annotations.Test;

public class TestPerson {

    @Test
    public void getOnePerson() {
        Person person;
        person = new Person("Ivan", 18);
    }
}
