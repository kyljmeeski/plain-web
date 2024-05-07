package com.kyljmeeski.plainweb.body;

import com.kyljmeeski.plainweb.Body;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonBodyTest {

    @Test
    public void test() {
        Player player = new Player("messi", 36);
        Body body = new JsonBody<>(player);
        assertEquals("application/json", body.type());
        assertArrayEquals(player.toString().getBytes(), body.content());
    }

    private static class Player {
        private final String name;
        private final int age;

        private Player(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("{\"name\":\"%s\",\"age\":%d}", name, age);
        }
    }

}