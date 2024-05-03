package com.kyljmeeski.plainweb.body;

import com.kyljmeeski.plainweb.Body;

public class TextBody implements Body {

    private final String content;

    public TextBody(String content) {
        this.content = content;
    }

    @Override
    public String type() {
        return "text/plain";
    }

    @Override
    public byte[] content() {
        return content.getBytes();
    }

}
