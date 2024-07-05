package com.kyljmeeski.plainweb;

/**
 * Represents a route handler that processes incoming requests and returns a response.
 */
public interface Route {

    /**
     * Handles the incoming request and returns a response.
     *
     * @param request The incoming request to be processed
     * @return The response generated based on the request
     */
    Response handle(Request request);

}
