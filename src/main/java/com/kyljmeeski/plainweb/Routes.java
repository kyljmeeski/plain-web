package com.kyljmeeski.plainweb;

import com.kyljmeeski.plainweb.response.EmptyResponse;
import com.kyljmeeski.plainweb.response.MethodNotAllowedResponse;
import com.kyljmeeski.plainweb.response.NotFoundResponse;

import java.util.HashMap;
import java.util.Map;

public class Routes {

    private final Map<String, Pair> routes = new HashMap<>();
    private final Response notFoundResponse = new NotFoundResponse();
    private final Response methodNotAllowedResponse = new MethodNotAllowedResponse();

    public Response response(Request request) {
        Pair pair = routes.get(request.path());
        if (pair == null) {
            return notFoundResponse;
        }
        if (pair.method == request.method()) {
            if (pair.route.handle(request) == null) {
                return new EmptyResponse();
            }
            return pair.route.handle(request);
        }
        return methodNotAllowedResponse;
    }

    public void addRoute(HttpMethod method, String path, Route route) {
        routes.put(path, new Pair(method, route));
    }

    private static class Pair {

        private final HttpMethod method;
        private final Route route;

        private Pair(HttpMethod method, Route route) {
            this.method = method;
            this.route = route;
        }

        public HttpMethod method() {
            return method;
        }

        public Route route() {
            return route;
        }

    }

}
