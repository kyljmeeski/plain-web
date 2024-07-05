package com.kyljmeeski.plainweb.request;

import com.kyljmeeski.plainweb.*;
import com.kyljmeeski.plainweb.body.PlainBody;

import java.util.Arrays;

/**
 * Represents an HTTP request received by a web server, parsed from raw byte data.
 */
public class PlainRequest implements Request {

    private final byte[] bytes;

    /**
     * Constructs a PlainRequest object with the given byte array representing the HTTP request.
     *
     * @param bytes The byte array containing the HTTP request data
     */
    public PlainRequest(byte[] bytes) {
        this.bytes = bytes;
    }

    /**
     * Returns the HTTP method of the request (GET, POST, etc.).
     *
     * @return The HTTP method of the request
     */
    @Override
    public HttpMethod method() {
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == 32) {
                return HttpMethod.valueOf(new String(Arrays.copyOfRange(bytes, 0, i)));
            }
        }
//        todo: if there is no method found, then request is wrong, to something with it, instead of just returning null
        return null;
    }

    /**
     * Returns the path of the request URL.
     *
     * @return The path of the request URL
     */
    @Override
    public String path() {
//        todo: come up with something other than calling method(), now to extract path, extracting of method is required
        int start = method().name().length() + 1;
        for (int i = start; i < bytes.length; i++) {
            if (bytes[i] == 63 || bytes[i] == 32) {
                return new String(Arrays.copyOfRange(bytes, start, i));
            }
        }
//        todo: do something if no path is found, raise client side error maybe, instead of just return empty string
        return "";
    }

    /**
     * Returns the body of the request.
     *
     * @return The body of the request
     */
    //    todo: somehow document it, how this method works
    @Override
    public Body body() {
        String contentType = headers().get("Content-Type").orElse("text/plain");
        int contentLength;
        try {
            contentLength = Integer.parseInt(headers().get("Content-Length").orElse("0"));
        } catch (NumberFormatException exception) {
            contentLength = 0;
        }
        if (contentLength == 0) {
            return new PlainBody(new byte[0], "");
        }
        int i = 0;
        while (i < bytes.length - 3) {
            i ++;
            if (bytes[i] == '\r' && bytes[i + 1] == '\n' && bytes[i + 2] == '\r' && bytes[i + 3] == '\n') {
                break;
            }
        }
        return new PlainBody(Arrays.copyOfRange(bytes, i + 4, i + 4 + contentLength), contentType);
    }

    /**
     * Returns the parameters associated with the request.
     *
     * @return The parameters associated with the request
     */
    //    todo: somehow document it, how this method works
    @Override
    public Parameters params() {
        Parameters params = new Parameters();
        int cursor = method().name().length() + path().length() + 2;
        if (bytes[cursor - 1] != 63) {
            return params;
        }
        int checkPoint = cursor;
        String key = "", value = "";
        byte aByte;
        while ((aByte = bytes[cursor]) != 32) {
            if (aByte == 61) {
                key = new String(Arrays.copyOfRange(bytes, checkPoint, cursor));
                checkPoint = cursor + 1;
            } else if (aByte == 38) {
                value = new String(Arrays.copyOfRange(bytes, checkPoint, cursor));
                checkPoint = cursor + 1;
                params.add(key, value);
            }
            cursor ++;
        }
        value = new String(Arrays.copyOfRange(bytes, checkPoint, cursor));
        params.add(key, value);
        return params;
    }

    /**
     * Returns the headers of the request.
     *
     * @return The headers of the request
     */
    //    todo: somehow document it, how this method works
    @Override
    public Headers headers() {
        Headers headers = new Headers();
        int i = 0;
        int start = 0;
        boolean headerFound = false;
        String key = "";
        String value = "";
        while (true) {
            char aByte = (char) bytes[i];
            if (bytes[i] == '\r' && bytes[i + 1] == '\n') {
                if (!headerFound) {
                    headerFound = true;
                } else {
                    value = new String(Arrays.copyOfRange(bytes, start, i)).trim();
                    headers.add(key, value);
                }
                start = i + 2;
            }
            if (bytes[i] == ':') {
                key = new String(Arrays.copyOfRange(bytes, start, i)).trim();
                start = i + 1;
            }
            i ++;
            if (bytes[i] == '\r' && bytes[i + 1] == '\n' && bytes[i + 2] == '\r' && bytes[i + 3] == '\n') {
                value = new String(Arrays.copyOfRange(bytes, start, i)).trim();
                if (headerFound) {
                    headers.add(key, value);
                }
                break;
            }
        }
        return headers;
    }

}
