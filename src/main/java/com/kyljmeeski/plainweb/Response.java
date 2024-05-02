package com.kyljmeeski.plainweb;

public interface Response {

    HttpStatus status();

    Headers headers();

    Body body();

}
