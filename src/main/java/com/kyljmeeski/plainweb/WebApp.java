package com.kyljmeeski.plainweb;

import java.io.IOException;

/**
 * Interface representing a basic web application.
 */
public interface WebApp {


    /**
     * Registers a route handler for a specific HTTP method and path.
     *
     * @param method The HTTP method (GET, POST, etc.) for the route
     * @param path   The path pattern for the route
     * @param route  The handler function for processing requests to the route
     */
    void on(HttpMethod method, String path, Route route);

    /**
     * Starts the web application, listening for incoming connections.
     *
     * @throws IOException If an I/O error occurs while starting the server
     */
    void start() throws IOException;

}
