package com.revature.exceptions;


// used in LoginDAO.passwordMatch (String password) method
public class MyPasswordNoMatchException extends Exception {
	
	
	public MyPasswordNoMatchException() {
        super();
    }
	
	public MyPasswordNoMatchException(String message) {
        super(message);
    }

    public MyPasswordNoMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyPasswordNoMatchException(Throwable cause) {
        super(cause);
    }

    public MyPasswordNoMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
	

}
