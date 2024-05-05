package com.kyljmeeski.plainweb.response;

import com.kyljmeeski.plainweb.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NotFoundResponseTest {

    @Test
    public void test() {
        Response response = new NotFoundResponse();
        assertEquals("Not Found.", new String(response.body().content()));
    }

}