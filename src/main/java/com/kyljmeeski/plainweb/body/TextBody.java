package com.kyljmeeski.plainweb.body;

import com.kyljmeeski.plainweb.Body;

/**
 * Represents the body of an HTTP request or response with text content.
 */
public class TextBody implements Body {

    private final String content;

    /**
     * Constructs a TextBody object with the specified text content.
     *
     * @param content The text content of the body
     */
    public TextBody(String content) {
        this.content = content;
    }

    /**
     * Returns the content type of the body.
     *
     * @return The content type as a string
     */
    @Override
    public String type() {
        return "text/plain";
    }

    /**
     * Returns the content of the body as a byte array.
     *
     * @return The content of the body
     */
    @Override
    public byte[] content() {
        return content.getBytes();
    }

}
