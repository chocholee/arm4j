package com.arm4j.core.exception;

public class HttpURLConnRequestException extends RuntimeException {

    public HttpURLConnRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpURLConnRequestException(String message) {
        super(message);
    }

    public HttpURLConnRequestException() {
    }

}
