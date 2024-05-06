package com.kyljmeeski.plainweb;

import com.kyljmeeski.plainweb.request.PlainRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoutesTest {

    @Test
    public void testWhenNotFound() {
        HttpMethod method = HttpMethod.GET;
        String path = "/hello";


        String requestString = String.format("%s %s HTTP/1.1\r\n%s\r\n", method, path, new Headers());
        Request request = new PlainRequest(requestString.getBytes());

        Routes routes = new Routes();
        routes.addRoute(HttpMethod.GET, "/", new HomeRoute());
        Response response = routes.response(request);

        assertEquals(HttpStatus.NOT_FOUND, response.status());
    }

    @Test
    public void testWhenMethodNotAllowed() {
        HttpMethod method = HttpMethod.POST;
        String path = "/";


        String requestString = String.format("%s %s HTTP/1.1\r\n%s\r\n", method, path, new Headers());
        Request request = new PlainRequest(requestString.getBytes());

        Routes routes = new Routes();
        routes.addRoute(HttpMethod.GET, "/", new HomeRoute());
        Response response = routes.response(request);

        assertEquals(HttpStatus.METHOD_NOT_ALLOWED, response.status());
    }

    @Test
    public void testWhenResponseIsNull() {
        HttpMethod method = HttpMethod.GET;
        String path = "/";

        String text = "hello";
        Headers headers = new Headers();
        headers.add("Content-Type", "text/plain");
        headers.add("Content-Length", String.valueOf(text.length()));


        String requestString = String.format("%s %s HTTP/1.1\r\n%s\r\n%s", method, path, headers, text);
        Request request = new PlainRequest(requestString.getBytes());

        Routes routes = new Routes();
        routes.addRoute(HttpMethod.GET, "/", new HomeRoute());
        Response response = routes.response(request);

        assertEquals(HttpStatus.OK, response.status());
    }

    private static class HomeRoute implements Route {
        @Override
        public Response handle(Request request) {
            return null;
        }
    }

}