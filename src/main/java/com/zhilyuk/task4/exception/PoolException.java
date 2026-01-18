package com.zhilyuk.task4.exception;

public class PoolException extends RuntimeException {
    public PoolException(String message) {
        super(message);
    }

    public PoolException() {
        super();
    }

    public PoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public PoolException(Throwable cause) {
        super(cause);
    }
}
