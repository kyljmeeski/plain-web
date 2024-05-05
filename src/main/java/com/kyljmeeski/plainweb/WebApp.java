package com.kyljmeeski.plainweb;

import java.io.IOException;

public interface WebApp {

    void on(HttpMethod method, String path, Route route);

    void start() throws IOException;

}
