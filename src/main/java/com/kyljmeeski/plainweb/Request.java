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

/**
 * Represents an HTTP request received by a web server.
 */
public interface Request {

    /**
     * Returns the HTTP method of the request (GET, POST, etc.).
     *
     * @return The HTTP method of the request
     */
    HttpMethod method();

    /**
     * Returns the path of the request URL.
     *
     * @return The path of the request URL
     */
    String path();

    /**
     * Returns the parameters associated with the request.
     *
     * @return The parameters associated with the request
     */
    Parameters params();

    /**
     * Returns the headers of the request.
     *
     * @return The headers of the request
     */
    Headers headers();

    /**
     * Returns the body of the request.
     *
     * @return The body of the request
     */
    Body body();

}
