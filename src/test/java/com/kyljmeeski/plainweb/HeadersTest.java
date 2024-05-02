package com.kyljmeeski.plainweb;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeadersTest {

    @Test
    public void test() {
        Headers headers = new Headers();
        headers.add("Accept", "*/*");
        assertEquals("*/*", headers.get("Accept").orElse(""));
        assertEquals("Accept: */*\r\n", headers.toString());
        assertArrayEquals("Accept: */*\r\n".getBytes(), headers.bytes());
    }

}