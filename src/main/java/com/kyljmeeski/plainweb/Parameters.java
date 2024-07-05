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
