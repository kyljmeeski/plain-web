package com.kyljmeeski.plainweb;

import com.kyljmeeski.plainweb.exception.MissingFieldException;
import com.kyljmeeski.plainweb.request.PlainRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class BodyWrapperTest {

    @Test
    public void test() throws MissingFieldException {
        String body = "{\"name\": \"messi\", \"age\": 36}";
        String requestString = String.format("POST /player HTTP/1.1\r\nContent-Type: application/json\r\nContent-Length: %d\r\n\r\n%s", body.length(), body);
        Request request = new PlainRequest(requestString.getBytes());
        Player player = new BodyWrapper(request.body()).content(Player.class);
        Player expectedPlayer = new Player("messi", 36);
        assertEquals(expectedPlayer, player);
    }

    private static class Player {
        private final String name;
        private final int age;

        private Player(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Player player = (Player) obj;
            return name.equals(((Player) obj).name) && age == ((Player) obj).age;
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + age;
            return result;
        }
    }

}