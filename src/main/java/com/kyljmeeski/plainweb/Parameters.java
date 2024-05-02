package com.kyljmeeski.plainweb;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Parameters {

    private final Map<String, String> params;

    public Parameters() {
        this(new HashMap<>());
    }

    public Parameters(Map<String, String> params) {
        this.params = params;
    }

    public void add(String key, String value) {
        params.put(key, value);
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(params.get(key));
    }

}
