package com.kyljmeeski.plainweb;

import com.kyljmeeski.plainweb.request.PlainRequest;
import com.kyljmeeski.plainweb.response.EmptyResponse;
import com.kyljmeeski.plainweb.response.InternalServiceErrorResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Implementation of the {@link WebApp} interface using plain HTTP.
 */
public class PlainWebApp implements WebApp {

    private final int port;
    private final Routes routes;

    /**
     * Constructs a PlainWebApp instance with default port 8080.
     */
    public PlainWebApp() {
        this(8080);
    }

    /**
     * Constructs a PlainWebApp instance with the specified port.
     *
     * @param port The port number for the server to listen on
     */
    public PlainWebApp(int port) {
        this(port, new Routes());
    }

    /**
     * Constructs a PlainWebApp instance with the specified port and routes.
     *
     * @param port   The port number for the server to listen on
     * @param routes The initial routes configuration
     */
    public PlainWebApp(int port, Routes routes) {
        this.port = port;
        this.routes = routes;
    }

    /**
     * Registers a route handler for a specific HTTP method and path.
     *
     * @param method The HTTP method (GET, POST, etc.) for the route
     * @param path   The path pattern for the route
     * @param route  The handler function for processing requests to the route
     */
    @Override
    public void on(HttpMethod method, String path, Route route) {
        routes.addRoute(method, path, route);
    }

    /**
     * Starts the web server and begins listening for incoming connections.
     *
     * @throws IOException If an I/O error occurs while starting the server
     */
    @Override
    public void start() throws IOException {
        System.out.println("Server started at port: " + port);
        ServerSocket server = new ServerSocket(port);
        while (true) {
            try (
                    Socket socket = server.accept();
                    InputStream input = socket.getInputStream();
                    OutputStream output = socket.getOutputStream()
            ) {
                Request request;
                Response response;
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                byte[] data = new byte[1024];
                int nRead;
                while ((nRead = input.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                    if (nRead < data.length) {
                        break;
                    }
                }
                buffer.flush();
                byte[] inputData =  buffer.toByteArray();
                if (inputData.length > 1) {
                    try {
                        request = new PlainRequest(inputData);
                        response = routes.response(request);
                    } catch (Exception exception) {
//                        todo: use BadRequestResponse as well; for that specific client error specific exceptions should be caught
                        response = new InternalServiceErrorResponse();
                    }
                    output.write(
                            String.format(
                                    "HTTP/1.1 %d %s\r\n", response.status().code(), response.status().phrase()
                            ).getBytes()
                    );
                    output.write(response.headers().bytes());
                    output.write("\r\n".getBytes());
                    output.write(response.body().content());
                    output.flush();
                }
            }
        }
    }

}
