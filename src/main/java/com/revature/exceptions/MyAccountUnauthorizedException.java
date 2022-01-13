package com.revature.exceptions;

public class MyAccountUnauthorizedException extends Exception {

	public MyAccountUnauthorizedException() {
        super();
    }
	
	public MyAccountUnauthorizedException(String message) {
        super(message);
    }

    public MyAccountUnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyAccountUnauthorizedException(Throwable cause) {
        super(cause);
    }

    public MyAccountUnauthorizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

	
}
