package com.kyljmeeski.plainweb.response;

import com.kyljmeeski.plainweb.HttpStatus;
import com.kyljmeeski.plainweb.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BadRequestResponseTest {

    @Test
    public void test() {
        String errorMessage = "Something is wrong.";
        Response response = new BadRequestResponse(errorMessage);
        assertEquals(HttpStatus.BAD_REQUEST, response.status());
        assertEquals(errorMessage, new String(response.body().content()));
    }

}