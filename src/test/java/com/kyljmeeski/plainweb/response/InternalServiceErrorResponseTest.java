package com.kyljmeeski.plainweb.response;

import com.kyljmeeski.plainweb.Response;
import org.junit.Test;

import static org.junit.Assert.*;

public class InternalServiceErrorResponseTest {

    @Test
    public void test() {
        Response response = new InternalServiceErrorResponse();
        assertEquals("Internal Service Error.", new String(response.body().content()));
    }

}