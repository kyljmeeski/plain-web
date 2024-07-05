package com.kyljmeeski.plainweb;

import com.kyljmeeski.plainweb.response.EmptyResponse;
import com.kyljmeeski.plainweb.response.MethodNotAllowedResponse;
import com.kyljmeeski.plainweb.response.NotFoundResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages registered routes and handles incoming requests by matching them to registered routes.
 */
public class Routes {

    private final Map<String, Pair> routes = new HashMap<>();
    private final Response notFoundResponse = new NotFoundResponse();
    private final Response methodNotAllowedResponse = new MethodNotAllowedResponse();

    /**
     * Generates a response for the given request by matching it against registered routes.
     *
     * @param request The incoming request to be processed
     * @return The generated response based on the request and registered routes
     */
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

    /**
     * Adds a new route with the specified HTTP method and path.
     *
     * @param method The HTTP method of the route (GET, POST, PUT, etc.)
     * @param path   The path pattern for the route
     * @param route  The handler for the route
     */
    public void addRoute(HttpMethod method, String path, Route route) {
        routes.put(path, new Pair(method, route));
    }


    /**
     * Private inner class to represent a pair of HTTP method and Route handler.
     */
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
