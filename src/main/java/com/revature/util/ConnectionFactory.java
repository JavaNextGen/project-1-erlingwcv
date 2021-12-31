package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>This ConnectionFactory class follows the Singleton Design Pattern and facilitates obtaining a connection to a Database for the ERS application.</p>
 * <p>Following the Singleton Design Pattern, the provided Constructor is private, and you obtain an instance via the {@link ConnectionFactory#getInstance()} method.</p>
 */

// This class contains the Java logic that gets a connection to our database
public class ConnectionFactory {

    private static ConnectionFactory instance;

    private ConnectionFactory() {
        super();
    }

    /**
     * <p>This method follows the Singleton Design Pattern to restrict this class to only having 1 instance.</p>
     * <p>It is invoked via:</p>
     *
     * {@code ConnectionFactory.getInstance()}
     */
    public static ConnectionFactory getInstance() {
        if(instance == null) {
            instance = new ConnectionFactory();
        }

        return instance;
    }

    /**
     * <p>The {@link ConnectionFactory#getConnection()} method is responsible for leveraging a specific Database Driver to obtain an instance of the {@link java.sql.Connection} interface.</p>
     * <p>Typically, this is accomplished via the use of the {@link java.sql.DriverManager} class.</p>
     */
    public static Connection getConnection() throws SQLException {
    	
    	// for compatibility with other technologies, we need to register our PostgreSQL Driver
    	// This makes our Java application aware of the database Driver we are using
    	try {
    		
    		// Dbeaver postgres Edit Connection /Edit Driver Settings org.postgresql.Driver
    		
    		
    		Class.forName("org.postgresql.Driver"); // try to find and return postgreSQL Driver class
    	} catch (ClassNotFoundException e) {
    		System.out.println("SQL Driver Not Found!");
    		e.printStackTrace(); // this to print error message to the console
    	}
    	
    	
    	// we need to provide our database credentials
    	// hard-coding now. Later may be put into Environment Variables
    	
    	// the url per our database schema
    	String url = "jdbc:postgresql://localhost:5432/postgres?Schema=rev1p211206"; // database schema Script-7 in Dbeaver
    	// postgre does not like upper case in schema name
    	//String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=revP1_211206"; // database is my schema name
    	// postgresql username
    	String username = "postgres";
    	// postgresql installation password
    	String password = "password";
    	
    	// This actually returns my Connection object: note the return type is Connection
    	return DriverManager.getConnection(url, username, password);
    	
        //return null; this is the default before actual coding
    }
}
