package com.kyljmeeski.plainweb;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Represents HTTP headers as a collection of key-value pairs.
 */
public class Headers {

    private final Map<String, String> headers;

    /**
     * Constructs an empty Headers object.
     */
    public Headers() {
        this(new HashMap<>());
    }

    /**
     * Constructs a Headers object with the specified initial headers.
     *
     * @param headers The initial headers to be added
     */
    public Headers(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * Adds a header with the specified key and value.
     *
     * @param key   The header key
     * @param value The header value
     */
    public void add(String key, String value) {
        headers.put(key, value);
    }

    /**
     * Retrieves the value of the header with the specified key, if present.
     *
     * @param key The header key
     * @return An Optional containing the header value, or empty if the header is not present
     */
    public Optional<String> get(String key) {
        return Optional.ofNullable(headers.get(key));
    }

    /**
     * Returns a string representation of the headers in the format "key: value\r\n".
     *
     * @return A string representation of the headers
     */
    @Override
    public String toString() {
        return headers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining("\r\n", "", "\r\n"));
    }

    /**
     * Returns the headers as a byte array representation.
     *
     * @return The headers as a byte array
     */
    public byte[] bytes() {
        return toString().getBytes();
    }

}
