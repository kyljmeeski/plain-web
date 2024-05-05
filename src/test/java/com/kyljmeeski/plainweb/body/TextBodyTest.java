package com.kyljmeeski.plainweb.body;

import com.kyljmeeski.plainweb.Body;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextBodyTest {

    @Test
    public void test() {
        String text = "hello messi";
        Body body = new TextBody(text);
        assertEquals("text/plain", body.type());
        assertArrayEquals(text.getBytes(), body.content());
    }

}