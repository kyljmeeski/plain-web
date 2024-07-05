package com.kyljmeeski.plainweb;

/**
 * Represents an HTTP response returned by a web server.
 */
public interface Response {

    /**
     * Returns the HTTP status of the response.
     *
     * @return The HTTP status of the response
     */
    HttpStatus status();

    /**
     * Returns the headers associated with the response.
     *
     * @return The headers associated with the response
     */
    Headers headers();

    /**
     * Returns the body of the response.
     *
     * @return The body of the response
     */
    Body body();

    /**
     * Adds a header with the specified key and value to the response.
     *
     * @param key   The key of the header
     * @param value The value of the header
     * @return The updated response object
     */
    Response with(String key, String value);

}
