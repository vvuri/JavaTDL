package ru.vvuri.core;

import org.testng.annotations.Test;

public class TestSimpleTypes {
    public String toString(Object o) {
        return o.getClass().getName() + "@" +
                Integer.toHexString(System.identityHashCode(o));
    }

    @Test
    public void getInt() {
        int i = 1;
        System.out.println(toString(i));
        System.out.println(System.identityHashCode(i));
    }
}
