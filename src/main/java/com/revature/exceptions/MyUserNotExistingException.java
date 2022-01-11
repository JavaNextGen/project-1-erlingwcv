package com.revature.exceptions;

public class MyUserNotExistingException extends Exception {

	public MyUserNotExistingException() {
        super();
    }

    public MyUserNotExistingException(String message) {
        super(message);
    }

    public MyUserNotExistingException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyUserNotExistingException(Throwable cause) {
        super(cause);
    }

    public MyUserNotExistingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
	
	
	
	
}
