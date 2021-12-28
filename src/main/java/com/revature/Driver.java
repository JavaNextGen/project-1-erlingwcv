package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Menu;
import com.revature.models.Role;
// import com.revature.models.Menu;
import com.revature.util.ConnectionFactory;

public class Driver {

    public static void main(String[] args) {
    	
    	
    	// Testing database connectivity
    	try (Connection conn = ConnectionFactory.getConnection()) {
    		System.out.println("Database conneciton succesful!");
    	} catch (SQLException e) {
    		
    		System.out.println("Database conneciton failed!");
    		e.printStackTrace();
    	}
    	
    	
    	System.out.println(Role.FINANCE_MANAGER);
    	
    	//Here is the actual functionality of our application ===================
    	
    	
    	
    	// Instantiate a menu object
    	Menu menu = new Menu();
    	
    	
    	// Use the Menu Class's displayMenu() method to give the user the menu
    	menu.finMgrMenu();
    	
    	// This is our entire main method (until we learn Javalin in Week 4)
    	
    	
    	// all of the complicated menu logic is hidden in the Menu Class... power of Abstraction!!
    	
    }
}
