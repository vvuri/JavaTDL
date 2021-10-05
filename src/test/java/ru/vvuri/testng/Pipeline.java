package ru.vvuri.testng;

import org.testng.annotations.*;

public class Pipeline {

    @BeforeSuite
    public void beforeSuite() {
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println(name);
    }

    @BeforeTest
    public void beforeTest() {
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println(name);
    }

    @Test
    public void runFirstTest() {
        System.out.println("Run Test First");
    }

    @Test
    public void runSecondTest() {
        System.out.println("Run Test Second");
    }

    @AfterTest
    public void afterTest() {
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println(name);
    }
}
