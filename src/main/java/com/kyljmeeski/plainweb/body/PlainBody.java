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
