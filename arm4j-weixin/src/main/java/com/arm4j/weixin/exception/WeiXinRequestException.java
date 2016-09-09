package com.arm4j.weixin.exception;

public class WeiXinRequestException extends Exception {

    public WeiXinRequestException() {
    }

    public WeiXinRequestException(String message) {
        super(message);
    }

    public WeiXinRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeiXinRequestException(Throwable cause) {
        super(cause);
    }
}
