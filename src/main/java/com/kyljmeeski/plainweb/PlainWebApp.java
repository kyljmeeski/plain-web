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

public class PlainWebApp implements WebApp {

    private final int port;
    private final Routes routes;

    public PlainWebApp() {
        this(8080);
    }

    public PlainWebApp(int port) {
        this(port, new Routes());
    }

    public PlainWebApp(int port, Routes routes) {
        this.port = port;
        this.routes = routes;
    }

    @Override
    public void on(HttpMethod method, String path, Route route) {
        routes.addRoute(method, path, route);
    }

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
