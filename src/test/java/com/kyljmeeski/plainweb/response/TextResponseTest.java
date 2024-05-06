package com.kyljmeeski.plainweb.response;

import com.kyljmeeski.plainweb.HttpStatus;
import com.kyljmeeski.plainweb.Response;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextResponseTest {

    @Test
    public void test() {
        String text = "hello messi";
        Response response = new TextResponse(HttpStatus.OK, text);
        assertEquals(text.length(), Integer.parseInt(response.headers().get("Content-Length").orElse("")));
        assertEquals("text/plain", response.body().type());
        assertEquals(text, new String(response.body().content()));
        response.with("Cookie", "cookies");
        assertEquals("cookies", response.headers().get("Cookie").orElse(""));
    }

}