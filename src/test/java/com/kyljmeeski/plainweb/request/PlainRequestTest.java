package com.kyljmeeski.plainweb.request;

import com.kyljmeeski.plainweb.Body;
import com.kyljmeeski.plainweb.HttpMethod;
import com.kyljmeeski.plainweb.Request;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlainRequestTest {

    @Test
    public void test() {
        String requestString = "GET / HTTP/1.1\r\nConnection: close\r\n\r\n";
        Request request = new PlainRequest(requestString.getBytes());
        assertEquals(HttpMethod.GET, request.method());
        assertEquals("/", request.path());
    }

    @Test
    public void testWhenPathIsLongWithParams() {
        String requestString = "GET /uefa/laliga/barcelona?season=2018/19&round=10 HTTP/1.1\r\nConnection: close\r\n\r\n";
        Request request = new PlainRequest(requestString.getBytes());
        assertEquals("/uefa/laliga/barcelona", request.path());
        assertEquals("2018/19", request.params().get("season").orElse(""));
        assertEquals("10", request.params().get("round").orElse(""));
    }

    @Test
    public void testHeaders() {
        String requestString = "GET / HTTP/1.1\r\nConnection: close\r\n\r\n";
        Request request = new PlainRequest(requestString.getBytes());
        assertEquals("close", request.headers().get("Connection").orElse(""));
    }

    @Test
    public void testWhenNoBody() {
        String requestString = "GET / HTTP/1.1\r\nConnection: close\r\n\r\n";
        Request request = new PlainRequest(requestString.getBytes());
        assertEquals(0, request.body().content().length);
    }

    @Test
    public void testBody() {
        String text = "hello";
        String requestString = String.format("GET / HTTP/1.1\r\nContent-Type: text/plain\r\nContent-Length: %d\r\n\r\n%s", text.length(), text);
        Request request = new PlainRequest(requestString.getBytes());
        assertEquals(text.length(), request.body().content().length);
        assertArrayEquals(text.getBytes(), request.body().content());
    }

}