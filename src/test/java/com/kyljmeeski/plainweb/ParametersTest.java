package com.kyljmeeski.plainweb;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParametersTest {

    @Test
    public void test() {
        Parameters params = new Parameters();
        String name = "messi";
        int age = 36;
        params.add("name", name);
        params.add("age", String.valueOf(age));
        assertEquals(name, params.get("name").orElse(""));
        assertEquals(age, Integer.parseInt(params.get("age").orElse("")));
    }

}