package com.kyljmeeski.plainweb;

public interface WebApp {

    void on(HttpMethod method, String path, Route route);

    void start();

}
