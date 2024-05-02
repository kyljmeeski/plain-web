package com.kyljmeeski.plainweb;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Headers {

    private final Map<String, String> headers;

    public Headers() {
        this(new HashMap<>());
    }

    public Headers(Map<String, String> headers) {
        this.headers = headers;
    }

    public void add(String key, String value) {
        headers.put(key, value);
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(headers.get(key));
    }

    @Override
    public String toString() {
        return headers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining("\r\n", "", "\r\n"));
    }

    public byte[] bytes() {
        return toString().getBytes();
    }

}
