/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2024 Amir Syrgabaev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.kyljmeeski.plainweb;

import com.google.gson.*;
import com.kyljmeeski.plainweb.exception.MissingFieldException;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * A generic JSON deserializer using Gson library for deserializing JSON into Java objects.
 *
 * @param <T> The type of the Java object to deserialize into
 */
class GenericDeserializer<T> implements JsonDeserializer<T> {

    private final Class<T> clazz;

    /**
     * Constructs a GenericDeserializer for the specified class.
     *
     * @param clazz The class type to deserialize JSON into
     */
    public GenericDeserializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Deserializes JSON element into a Java object of type T.
     *
     * @param json    The JSON element to deserialize
     * @param typeOfT The type of the object to deserialize to
     * @param context The context for deserialization
     * @return The deserialized Java object
     * @throws JsonParseException If there is an error during deserialization
     */
    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        for (Field field : clazz.getDeclaredFields()) {
            if (!jsonObject.has(field.getName())) {
                throw new JsonParseException("Missing field: " + field.getName());
            }
        }

        return new Gson().fromJson(jsonObject, clazz);
    }

}

/**
 * Wrapper class for handling and deserializing request body content into Java objects.
 */
public class BodyWrapper {

    private final byte[] content;

    /**
     * Constructs a BodyWrapper with the specified Body content.
     *
     * @param body The Body instance containing the content to be wrapped
     */
    public BodyWrapper(Body body) {
        content = body.content();
    }

    /**
     * Deserializes the wrapped content into an object of the specified class using Gson.
     *
     * @param <T>   The type of the object to deserialize into
     * @param clazz The class type to deserialize the content into
     * @return The deserialized object
     * @throws MissingFieldException If there is a missing field during deserialization
     */
    public <T> T content(Class<T> clazz) throws MissingFieldException {
        if (content.length == 0) {
            throw new MissingFieldException("Request body expected to be not null.");
        }
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(clazz, new GenericDeserializer<>(clazz));
            Gson gson = gsonBuilder.create();
            return gson.fromJson(new String(content), clazz);
        } catch (JsonParseException exception) {
            throw new MissingFieldException(exception.getMessage());
        }
    }

}
