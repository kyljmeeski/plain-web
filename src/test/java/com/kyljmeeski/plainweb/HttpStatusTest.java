package com.kyljmeeski.plainweb;

import org.junit.Test;

import static org.junit.Assert.*;

public class HttpStatusTest {

    @Test
    public void test() {
        String expected = "HTTP/1.1 200 OK\r\n";
        HttpStatus status = HttpStatus.OK;
        assertEquals(expected, status.toString());
        assertArrayEquals(expected.getBytes(), status.bytes());
    }

}