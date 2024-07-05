package com.kyljmeeski.plainweb;

/**
 * Represents an HTTP request received by a web server.
 */
public interface Request {

    /**
     * Returns the HTTP method of the request (GET, POST, etc.).
     *
     * @return The HTTP method of the request
     */
    HttpMethod method();

    /**
     * Returns the path of the request URL.
     *
     * @return The path of the request URL
     */
    String path();

    /**
     * Returns the parameters associated with the request.
     *
     * @return The parameters associated with the request
     */
    Parameters params();

    /**
     * Returns the headers of the request.
     *
     * @return The headers of the request
     */
    Headers headers();

    /**
     * Returns the body of the request.
     *
     * @return The body of the request
     */
    Body body();

}
