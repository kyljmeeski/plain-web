package com.kyljmeeski.plainweb.response;

import com.kyljmeeski.plainweb.Body;
import com.kyljmeeski.plainweb.Headers;
import com.kyljmeeski.plainweb.HttpStatus;
import com.kyljmeeski.plainweb.Response;
import com.kyljmeeski.plainweb.body.TextBody;

public class NotFoundResponse implements Response {

    private final String bodyText;
    private final Headers headers;

    public NotFoundResponse() {
        this("Not Found.");
    }

    public NotFoundResponse(String bodyText) {
        this(bodyText, new Headers());
    }

    public NotFoundResponse(String bodyText, Headers headers) {
        this.bodyText = bodyText;
        this.headers = headers;
    }

    @Override
    public HttpStatus status() {
        return HttpStatus.NOT_FOUND;
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
