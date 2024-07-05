package com.kyljmeeski.plainweb.response;

import com.kyljmeeski.plainweb.Body;
import com.kyljmeeski.plainweb.Headers;
import com.kyljmeeski.plainweb.HttpStatus;
import com.kyljmeeski.plainweb.Response;
import com.kyljmeeski.plainweb.body.TextBody;

/**
 * Represents an HTTP response indicating an internal server error (500 Internal Server Error).
 */
public class InternalServiceErrorResponse implements Response {

    private final String bodyText;
    private final Headers headers;

    /**
     * Constructs an InternalServiceErrorResponse with a default body text "Internal Service Error." and default headers.
     */
    public InternalServiceErrorResponse() {
        this("Internal Service Error.");
    }

    /**
     * Constructs an InternalServiceErrorResponse with the specified body text and default headers.
     *
     * @param bodyText The text content of the response body
     */
    public InternalServiceErrorResponse(String bodyText) {
        this(bodyText, new Headers());
    }

    /**
     * Constructs an InternalServiceErrorResponse with the specified body text and headers.
     *
     * @param bodyText The text content of the response body
     * @param headers  The headers associated with the response
     */
    public InternalServiceErrorResponse(String bodyText, Headers headers) {
        this.bodyText = bodyText;
        this.headers = headers;
    }

    /**
     * Returns the HTTP status of the response.
     *
     * @return The HTTP status of the response
     */
    @Override
    public HttpStatus status() {
        return HttpStatus.INTERNAL_SERVICE_ERROR;
    }

    /**
     * Returns the headers associated with the response.
     *
     * @return The headers associated with the response
     */
    @Override
    public Headers headers() {
        headers.add("Content-Type", "text/plain");
        headers.add("Content-Length", String.valueOf(bodyText.length()));
        return headers;
    }

    /**
     * Returns the body of the response.
     *
     * @return The body of the response
     */
    @Override
    public Body body() {
        return new TextBody(bodyText);
    }

    /**
     * Adds a header with the specified key and value to the response.
     *
     * @param key   The key of the header
     * @param value The value of the header
     * @return The updated response object
     */
    @Override
    public Response with(String key, String value) {
        headers.add(key, value);
        return this;
    }

}
