package com.kyljmeeski.plainweb.body;

import com.kyljmeeski.plainweb.Body;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlainBodyTest {

    @Test
    public void test() {
        String type = "text/plain";
        String content = "hello";

        Body body = new PlainBody(content.getBytes(), type);
        assertEquals(type, body.type());
        assertArrayEquals(content.getBytes(), body.content());
    }

    @Test
    public void testEmptyBody() {
        Body body = new PlainBody(new byte[0], "");
        assertArrayEquals(new byte[0], body.content());
    }

}