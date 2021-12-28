package com.revature;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class TestUsersTable211227 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		    Connection conn = ConnectionFactory.getConnection();
    		// Initiate an empty ResultSet object that will store the results of our SQL query
    		ResultSet rs = null;
    		// Write a query that we want to send to the database, and assign it to a String
    		
    		String sql = "SELECT * FROM ers_users"; // 211228 removed first semi colon relation "ers_users" not exists
    		//String sql = "SELECT * FROM ers_users;"; // 211227 error msg: relation ers_users does not exists
    		// Put the SQL query into a Statement object (The Connection object has a method for this)
    		Statement statement = conn.createStatement();
    		// Execute the query, by putting the results into our ResultSet object
    		// The Statement object has a method that takes Strings to execute as a SQL query
    		rs = statement.executeQuery(sql);
    		
    		// All the above makes a call to our database. Now we need to store the dat in an ArrayList.
    		
    		//Create an empty ArrayList to be filled with the data from the database
    		//Optional<List<User>> oul = Optional.empty();
    		List<User> userList = new ArrayList<>();
    		//oul = Optional.ofNullable(userList);
    		
    		
    		// while there are results in the ResultSet..
    		while(rs.next()) {
    			// use the all args constructor to create a new User object from each returned row from the DB
    			User u = new User(
    				// we want to use rs.get fro each column in the record
    				//	rs.getInt("ers_user_id"),		// DB use only
    					rs.getString("ers_username"),  // confidential
    					rs.getString("user_first_name"),
    					rs.getString("user_last_name"),
    				//	rs.getString("ers_password"), // confidential
    					rs.getString("user_email"),
    					rs.getInt("user_role_id")
    					);
    			// populate the ArrayList with each new User object
    			userList.add(u); // u is the new User object we created above
    			System.out.println(u);
    		}

	}

}
