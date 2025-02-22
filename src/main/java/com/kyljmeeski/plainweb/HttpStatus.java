/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2024 Amir Syrgabaev
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.kyljmeeski.plainweb;

/**
 * Represents standard HTTP status codes with their corresponding phrases.
 */
public enum HttpStatus {

    CONTINUE(100, "Continue"), SWITCHING_PROTOCOLS(101, "Switching Protocols"), PROCESSING(102, "Processing"), EARLY_HITS(103, "Early hints"),

    OK(200, "OK"), CREATED(201, "Created"), ACCEPTED(202, "Accepted"), NON_AUTHORITATIVE_INFORMATION(203, "Non Authoritative Information"),
    NO_CONTENT(204, "No Content"), RESET_CONTENT(205, "Reset Content"), PARTIAL_CONTENT(206, "Partial Content"), MULTI_STATUS(207, "Multi Status"),
    ALREADY_REPORTED(208, "Already Reported"), IM_USED(226, "I'm Used"),

    MULTIPLE_CHOICES(300, "Multiple Choices"), MOVED_PERMANENTLY(301, "Moved Permanently"), FOUND(302, "Found"), SEE_OTHER(303, "See Other"),
    NOT_MODIFIED(304, "Not Modified"), TEMPORARY_REDIRECT(307, "Temporary Redirect"), PERMANENT_REDIRECT(307, "Permanent Redirect"),

    BAD_REQUEST(400, "Bad Request"), UNAUTHORIZED(401, "Unauthorized"), PAYMENT_REQUIRED(402, "Payment Required"), FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"), METHOD_NOT_ALLOWED(405, "Method Not Allowed"), NOT_ACCEPTABLE(406, "Not Acceptable"),
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"), REQUEST_TIMEOUT(408, "Request Timeout"), CONFLICT(409, "Conflict"), GONE(410, "Gone"),
    LENGTH_REQUIRED(411, "Length Required"), PRECONDITION_FAILED(412, "Precondition Failed"), PAYLOAD_TOO_LARGE(413, "Payload Too Large"), URI_TOO_LONG(414, "URI Too Long"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media-Type"), RANGE_NOT_SATISFIABLE(416, "Range Not Satisfiable"), EXPECTATION_FAILED(417, "Expectation Failed"),
    IM_A_TEAPOT(418, "I'm a Teapot"), MISDIRECTED_REQUEST(421, "Misdirected Request"), UNPROCESSABLE_CONTENT(422, "Unprocessable Content"), LOCKED(423, "Locked"),
    FAILED_DEPENDENCY(424, "Failed Dependency"), TOO_EARLY(425, "Too Early"), UPGRADE_REQUIRED(426, "Upgrade Required"), PRECONDITION_REQUIRED(428, "Precondition Required"),
    TOO_MANY_REQUESTS(429, "Too Many Requests"), REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"), UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons"),

    INTERNAL_SERVICE_ERROR(500, "Internal Service Error"), NOT_IMPLEMENTED(501, "Not Implemented"), BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"), GATEWAY_TIMEOUT(504, "Gateway Timeout"), HTTP_VERSION_NOT_SUPPORTED(505, "Http Version Not Supported"),
    VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"), INSUFFICIENT_STORAGE(507, "Insufficient Storage"), LOOP_DETECTED(508, "Loop Detected"),
    NOT_EXTENDED(510, "Not Extended"), NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required");

    private final int code;
    private final String phrase;

    /**
     * Constructs an HttpStatus enum with the specified status code and phrase.
     *
     * @param code   The HTTP status code
     * @param phrase The corresponding phrase for the status code
     */
    HttpStatus(int code, String phrase) {
        this.code = code;
        this.phrase = phrase;
    }

    /**
     * Returns the HTTP status code.
     *
     * @return The HTTP status code
     */
    public int code() {
        return code;
    }

    /**
     * Returns the corresponding phrase for the HTTP status code.
     *
     * @return The corresponding phrase
     */
    public String phrase() {
        return phrase;
    }

    /**
     * Returns a string representation of the HTTP status in the format "HTTP/1.1 code phrase\r\n".
     *
     * @return A string representation of the HTTP status
     */
    @Override
    public String toString() {
        return "HTTP/1.1 " + code + " " + phrase + "\r\n";
    }

    /**
     * Returns the HTTP status as a byte array representation.
     *
     * @return The HTTP status as a byte array
     */
    public byte[] bytes() {
        return toString().getBytes();
    }

}
