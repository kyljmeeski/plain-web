package com.kyljmeeski.plainweb.response;

import com.kyljmeeski.plainweb.Body;
import com.kyljmeeski.plainweb.Headers;
import com.kyljmeeski.plainweb.HttpStatus;
import com.kyljmeeski.plainweb.Response;
import com.kyljmeeski.plainweb.body.TextBody;

public class BadRequestResponse implements Response {

    private final String bodyText;
    private final Headers headers;

    public BadRequestResponse() {
        this("Bad Request.");
    }

    public BadRequestResponse(String bodyText) {
        this(bodyText, new Headers());
    }

    public BadRequestResponse(String bodyText, Headers headers) {
        this.bodyText = bodyText;
        this.headers = headers;
    }

    @Override
    public HttpStatus status() {
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    public Headers headers() {
        headers.add("Content-Type", "text/plain");
        headers.add("Content-Length", String.valueOf(bodyText.length()));
        return headers;
    }

    @Override
    public Body body() {
        return new TextBody(bodyText);
    }

    @Override
    public Response with(String key, String value) {
        headers.add(key, value);
        return this;
    }

}
