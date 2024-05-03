package com.kyljmeeski.plainweb.response;

import com.kyljmeeski.plainweb.Body;
import com.kyljmeeski.plainweb.Headers;
import com.kyljmeeski.plainweb.HttpStatus;
import com.kyljmeeski.plainweb.Response;
import com.kyljmeeski.plainweb.body.TextBody;

public class TextResponse implements Response {

    private final HttpStatus status;
    private final Headers headers;
    private final TextBody body;

    public TextResponse(HttpStatus status, String body) {
        this(status, new TextBody(body));
    }

    public TextResponse(HttpStatus status, TextBody body) {
        this(status, new Headers(), body);
    }

    public TextResponse(HttpStatus status, Headers headers, TextBody body) {
        this.status = status;
        this.headers = headers;
        this.body = body;
    }

    @Override
    public HttpStatus status() {
        return status;
    }

    @Override
    public Headers headers() {
        headers.add("Content-Type", body.type());
        headers.add("Content-Length", String.valueOf(body.content().length));
        return headers;
    }

    @Override
    public Body body() {
        return body;
    }

    @Override
    public Response with(String key, String value) {
        headers.add(key, value);
        return this;
    }
}
