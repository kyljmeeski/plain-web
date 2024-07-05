package com.kyljmeeski.plainweb.response;

import com.kyljmeeski.plainweb.Body;
import com.kyljmeeski.plainweb.Headers;
import com.kyljmeeski.plainweb.HttpStatus;
import com.kyljmeeski.plainweb.Response;
import com.kyljmeeski.plainweb.body.TextBody;

/**
 * Represents an HTTP response with text content.
 */
public class TextResponse implements Response {

    private final HttpStatus status;
    private final Headers headers;
    private final TextBody body;

    /**
     * Constructs a TextResponse with the specified status and text body.
     *
     * @param status The HTTP status of the response
     * @param body   The text body of the response
     */
    public TextResponse(HttpStatus status, String body) {
        this(status, new TextBody(body));
    }

    /**
     * Constructs a TextResponse with the specified status and text body.
     *
     * @param status The HTTP status of the response
     * @param body   The text body of the response
     */
    public TextResponse(HttpStatus status, TextBody body) {
        this(status, new Headers(), body);
    }

    /**
     * Constructs a TextResponse with the specified status, headers, and text body.
     *
     * @param status  The HTTP status of the response
     * @param headers The headers associated with the response
     * @param body    The text body of the response
     */
    public TextResponse(HttpStatus status, Headers headers, TextBody body) {
        this.status = status;
        this.headers = headers;
        this.body = body;
    }

    /**
     * Returns the HTTP status of the response.
     *
     * @return The HTTP status of the response
     */
    @Override
    public HttpStatus status() {
        return status;
    }

    /**
     * Returns the headers associated with the response.
     *
     * @return The headers associated with the response
     */
    @Override
    public Headers headers() {
        headers.add("Content-Type", body.type());
        headers.add("Content-Length", String.valueOf(body.content().length));
        return headers;
    }

    /**
     * Returns the body of the response.
     *
     * @return The body of the response
     */
    @Override
    public Body body() {
        return body;
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
