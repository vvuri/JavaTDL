package ru.vvuri.allure;

import org.apache.commons.lang3.BooleanUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AllureTest {

    @Test
    public void firstTest() {
        Assert.assertEquals(2+2, 4);
    }

    @Test
    public void secondTest() {
        Assert.assertEquals("Hello " + "Allure", "Hello Allure");
    }

    @Test(enabled = false)
    public void randomTest() {
        Random random = new Random();
        Assert.assertTrue(BooleanUtils.toBoolean(random.nextInt(2)));
    }

}
