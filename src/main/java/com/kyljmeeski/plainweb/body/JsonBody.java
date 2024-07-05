package com.kyljmeeski.plainweb.body;

import com.google.gson.Gson;
import com.kyljmeeski.plainweb.Body;

/**
 * Represents an HTTP body that serializes the content object to JSON format.
 *
 * @param <T> The type of content object to be serialized to JSON
 */
public class JsonBody<T> implements Body {

    private final T content;

    /**
     * Constructs a JsonBody object with the specified content object.
     *
     * @param content The content object to be serialized to JSON
     */
    public JsonBody(T content) {
        this.content = content;
    }

    /**
     * Returns the content of the body as a byte array.
     *
     * @return The content of the body
     */
    @Override
    public byte[] content() {
        return new Gson().toJson(content).getBytes();
    }

    /**
     * Returns the content type of the body.
     *
     * @return The content type as a string
     */
    @Override
    public String type() {
        return "application/json";
    }

}
