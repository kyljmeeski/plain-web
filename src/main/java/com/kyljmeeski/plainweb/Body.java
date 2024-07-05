package com.kyljmeeski.plainweb;

/**
 * Represents the body of an HTTP request or response.
 */
public interface Body {

    /**
     * Returns the content type of the body.
     *
     * @return The content type as a string
     */
    String type();

    /**
     * Returns the content of the body as a byte array.
     *
     * @return The content of the body
     */
    byte[] content();

}

