package com.kyljmeeski.plainweb.response;

import com.kyljmeeski.plainweb.Body;
import com.kyljmeeski.plainweb.Headers;
import com.kyljmeeski.plainweb.HttpStatus;
import com.kyljmeeski.plainweb.Response;
import com.kyljmeeski.plainweb.body.JsonBody;

public class JsonResponse<T> implements Response {

    private final HttpStatus status;
    private final Headers headers;
    private final JsonBody<T> body;

    public JsonResponse(HttpStatus status, T body) {
        this(status, new JsonBody<>(body));
    }

    public JsonResponse(HttpStatus status, JsonBody<T> body) {
        this(status, new Headers(), body);
    }

    public JsonResponse(HttpStatus status, Headers headers, JsonBody<T> body) {
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
