package com.revature.exceptions;

public class MyEmailNotFoundException extends Exception {
	
	//MyEmailNotFoundException  
	
	public MyEmailNotFoundException() {
        super();
    }
	
	public MyEmailNotFoundException(String message) {
        super(message);
    }

    public MyEmailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyEmailNotFoundException(Throwable cause) {
        super(cause);
    }

    public MyEmailNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
