package com.revature.util;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
// import com.revature.util.ConnectionFactory; // why never used? 211224: because  the same package

import com.revature.models.User;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import com.revature.models.User;


public class ConnectionFactoryTest {

    private static ConnectionFactory connectionFactory; // why connectionFacgtory never used? 211224

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        connectionFactory = ConnectionFactory.getInstance();
    }

    @Test
    // 211224 passed
    public void testConnectionFactoryIsAbleToGetConnection() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();

        assertThat(conn, instanceOf(Connection.class));
        
        
        System.out.println("SQL conn good");
        
//        ResultSet rs = null;
//
//		// Write a query that we want to send to the database, and assign it to a String
//		String sql = "SELECT * FROM ers_users;";
//		// Put the SQL query into a Statement object (The Connection object has a method for this)
//		Statement statement = conn.createStatement();
//		// Execute the query, by putting the results into our ResultSet object
//		// The Statement object has a method that takes Strings to execute as a SQL query
//		
//		rs = statement.executeQuery(sql);
//		
//		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
//		
//		//Create an empty ArrayList to be filled with the data from the database
//		//Optional<List<User>> oul = Optional.empty();
//		List<User> userList = new ArrayList<>();
//		//oul = Optional.ofNullable(userList);
//		
//		
//		// while there are results in the ResultSet..
//		while(rs.next()) {
//			// use the all args constructor to create a new User object from each returned row from the DB
//			User u = new User(
//				// we want to use rs.get fro each column in the record
//				//	rs.getInt("ers_user_id"),		// DB use only
//					rs.getString("ers_username"),  // confidential
//					rs.getString("user_first_name"),
//					rs.getString("user_last_name"),
//				//	rs.getString("ers_password"), // confidential
//					rs.getString("user_email"),
//					rs.getInt("user_role_id")
//					);
//			// populate the ArrayList with each new User object
//			userList.add(u); // u is the new User object we created above
//			System.out.println(u.toString());
//		
//        
//    }
}
