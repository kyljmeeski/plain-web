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

import com.kyljmeeski.plainweb.Body;

/**
 * Represents the body of an HTTP request or response with plain byte content.
 */
public class PlainBody implements Body {

    private final byte[] content;
    private final String type;

    /**
     * Constructs a PlainBody object with the specified content and content type.
     *
     * @param content The byte array representing the content of the body
     * @param type    The content type of the body
     */
    public PlainBody(byte[] content, String type) {
        this.content = content;
        this.type = type;
    }

    /**
     * Returns the content type of the body.
     *
     * @return The content type as a string
     */
    @Override
    public String type() {
        return type;
    }

    /**
     * Returns the content of the body as a byte array.
     *
     * @return The content of the body
     */
    @Override
    public byte[] content() {
        return content;
    }

}
