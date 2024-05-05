package com.kyljmeeski.plainweb.response;

import com.kyljmeeski.plainweb.Response;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyResponseTest {

    @Test
    public void test() {
        Response response = new EmptyResponse();
        assertEquals("", new String(response.body().content()));
        assertEquals("text/plain", response.body().type());
    }

}