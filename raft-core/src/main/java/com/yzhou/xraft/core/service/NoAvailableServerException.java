package com.yzhou.xraft.core.service;

public class NoAvailableServerException extends RuntimeException {

    public NoAvailableServerException(String message) {
        super(message);
    }

}
