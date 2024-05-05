package com.kyljmeeski.plainweb.response;

import com.kyljmeeski.plainweb.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MethodNotAllowedResponseTest {

    @Test
    public void test() {
        Response response = new MethodNotAllowedResponse();
        assertEquals("Method Not Allowed.", new String(response.body().content()));
    }

}