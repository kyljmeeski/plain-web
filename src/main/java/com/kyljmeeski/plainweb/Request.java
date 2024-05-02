package com.kyljmeeski.plainweb;

public interface Request {

    HttpMethod method();

    String path();

    Parameters params();

    Headers headers();

    Body body();

}
