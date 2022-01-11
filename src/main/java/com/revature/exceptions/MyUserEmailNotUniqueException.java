package com.revature.exceptions;

public class MyUserEmailNotUniqueException extends Exception {

	public MyUserEmailNotUniqueException() {
        super();
    }

    public MyUserEmailNotUniqueException(String message) {
        super(message);
    }

    public MyUserEmailNotUniqueException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyUserEmailNotUniqueException(Throwable cause) {
        super(cause);
    }

    public MyUserEmailNotUniqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

