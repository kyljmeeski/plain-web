package com.kyljmeeski.plainweb.body;

import com.kyljmeeski.plainweb.Body;

public class PlainBody implements Body {

    private final byte[] content;
    private final String type;

    public PlainBody(byte[] content, String type) {
        this.content = content;
        this.type = type;
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public byte[] content() {
        return content;
    }

}
