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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Represents a collection of key-value parameters.
 */
public class Parameters {

    private final Map<String, String> params;

    /**
     * Constructs an empty Parameters object.
     */
    public Parameters() {
        this(new HashMap<>());
    }

    /**
     * Constructs a Parameters object with the specified initial parameters.
     *
     * @param params The initial parameters to be added
     */
    public Parameters(Map<String, String> params) {
        this.params = params;
    }

    /**
     * Adds a parameter with the specified key and value.
     *
     * @param key   The parameter key
     * @param value The parameter value
     */
    public void add(String key, String value) {
        params.put(key, value);
    }

    /**
     * Retrieves the value of the parameter with the specified key, if present.
     *
     * @param key The parameter key
     * @return An Optional containing the parameter value, or empty if the parameter is not present
     */
    public Optional<String> get(String key) {
        return Optional.ofNullable(params.get(key));
    }

}
