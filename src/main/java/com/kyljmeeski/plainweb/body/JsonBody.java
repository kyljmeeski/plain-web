package com.kyljmeeski.plainweb.body;

import com.google.gson.Gson;
import com.kyljmeeski.plainweb.Body;

public class JsonBody<T> implements Body {

    private final T content;

    public JsonBody(T content) {
        this.content = content;
    }

    @Override
    public byte[] content() {
        return new Gson().toJson(content).getBytes();
    }

    @Override
    public String type() {
        return "application/json";
    }

}
