package com.revature.results;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.models.UserNRole;
import com.revature.util.ConnectionFactory;

// M7 getAllUsers, M9 getAllByUsername
public class FMuserViews {

	 public List<UserNRole> getAllUsers() {
		try(Connection conn = ConnectionFactory.getConnection()) {
			// Initiate an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			// Write a query that we want to send to the database, and assign it to a String
			//String sql = "SELECT * FROM rev1p211206.ers_users;";
			//String sql = "SELECT * FROM ers_users";
			//ers_username,
			//user_email, 
			//user_role,
			//user_last_name, 
			//user_first_name,
			//ers_users_id 
			//FROM ers_users
			//LEFT JOIN ers_user_roles 
			//ON ers_users.user_role_id = ers_user_roles.ers_user_role_id
			//ORDER BY user_last_name;
			String sql = " SELECT \n"
					+ "ers_username,\n"
					+ "user_email, \n"
					+ "user_role, \n"
					+ "user_last_name, \n"
					+ "user_first_name, \n"
					+ "ers_users_id \n"
					+ "FROM ers_users \n"
					+ "LEFT JOIN ers_user_roles \n"
					+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
					+ "ORDER BY user_last_name ";
				      		
		//	// schema name to inlcude, so JDBC can see the table
		//	// Put the SQL query into a Statement object (The Connection object has a method for this)
			Statement statement = conn.createStatement(); // no sql as parameter
		//      		
		//	// Execute the query, by putting the results into our ResultSet object
		//	// The Statement object has a method that takes Strings to execute as a SQL query
			rs = statement.executeQuery(sql);
		//	
		//	// All the above makes a call to our database. Now we need to store the data in an ArrayList.
		//	
		//	//Create an empty ArrayList to be filled with the data from the database
			//Optional<List<User>> oul = Optional.empty();
		//	        		
			List<UserNRole> userList = new ArrayList<>();
		//	//Optional<List<User>> oul = Optional.ofNullable(userList);
		//	//oul = Optional.ofNullable(userList);
		//	
		//	
		//// if(oul.isPresent()) {
		//	// while there are results in the ResultSet..
			while(rs.next()) {
		//		// use the all args constructor to create a new User object from each returned row from the DB
				UserNRole unr = new UserNRole(
		//			// we want to use rs.get fro each column in the record
					//	rs.getInt("ers_user_id"),		// DB use only
						rs.getString("ers_username"),  // confidential
						rs.getString("user_email"),
						rs.getString("user_role"),
						rs.getString("user_last_name"),
						rs.getString("user_first_name"),
						rs.getInt("ers_users_id")
		//			//	rs.getString("ers_password"), // confidential
	

						);
		//		// populate the ArrayList with each new User object
				userList.add(unr); // u is the new User object we created above
		//		//System.out.println(u.getUsername());
		//		////System.out.println(u.toString());
		//		}
		// // if Optional.isPresent() is true
		//	// when there are no more results in rs, the while loop will break
		//	// then return the populated ArrayList of Users
		//	//// return Optional.ofNullable(u);
		//	System.out.println("UserDAO alluser return having no records is " + userList.isEmpty());
		//	return Optional.ofNullable(userList);
		//	//return Optional.ofNullable(oul.get());
			}	
		} catch (SQLException e) {
			System.out.println("Somethiong went wrong selecting all users!");
			e.printStackTrace();
		}
		//
		//return Optional.empty();
		return null;
	}
}