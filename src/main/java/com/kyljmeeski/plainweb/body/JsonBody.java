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
