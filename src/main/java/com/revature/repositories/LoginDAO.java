package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.revature.exceptions.MyEmailNotFoundException;
import com.revature.exceptions.MyPasswordNoMatchException;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class LoginDAO {
	// Login DAO has 3 functions (based on username, password, or email provided) for verification purposes
	// 1. usernameFound (per username): for unique or existing or match
	// 2. passwordMatch (per username & password): for matching
	// 3. emailFound (per email): for unique or existing
	// 4. userIdFound (per username): for new user registration
	
	
	//hardcoding username/password - which you WON'T do in P1
	
	
// ++For DB Update: 1 ++++ which user_role_id's Username Found ++++++++++++++++++++++++++++++++++++++++++++++++
// ++++++++++ 220113 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	public int ers_usernameFound4dbUpdate (String username, int users_id) {	
		try(Connection conn = ConnectionFactory.getConnection()) {
    		// Initiate an empty ResultSet object that will store the results of our SQL query
    		ResultSet rs = null;
    		
    		// Write a query that we want to send to the database, and assign it to a String
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
     		//String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
    		
    		String sql = " SELECT \n"
    				+ "user_role_id \n"
    				+ "FROM ers_users\n"
    				//+ "LEFT JOIN ers_user_roles \n"
    				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
    				+ "WHERE ers_username = ? AND ers_users_id != ? ";

    		// schema name to be included. otherwise JDBC do not see the table
    		// Put the SQL query into a Statement object (The Connection object has a method for this)
    		// Statement statement = conn.createStatement();
    		// This time should use PreparedStatement to prevent SQL injection
    		PreparedStatement ps = conn.prepareStatement(sql);
    		// put the username parameter in the PreparedStatement to complete the SQL
    		ps.setString(1, username); // 1st question mark in SQL, its variable
    		ps.setInt(2,  users_id); // the user's prior user's username should be excluded for comparison
    		
    		// Execute the query, by putting the results into our ResultSet object
    		// The Statement object has a method that takes Strings to execute as a SQL query
    		//rs = statement.executeQuery(sql);
    		rs = ps.executeQuery(); // sql already included in ps on line 33
    		
    		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
    		
    		//Create an empty ArrayList to be filled with the data from the database
    		// since username is unique, just need a user object to take the sql results
    		//List<User> userList = new ArrayList<>();
    	
    		while(rs.next()) {
    			if(rs.wasNull()) {     // in case the result is null: no duplicate username found 220113
    				
    				return 0; // User with the username was not found
    				
    			} else {
    			
		    		//String  rsResult = rs.getString("ers_username");
		    		int user_role_idFound = rs.getInt("user_role_id");
		    		if (user_role_idFound > 0) {
		    			return user_role_idFound;  // indicating the username is used by another user at least
		    			// return true;
		    		}
    			}
    		}
//    		while(rs.next()) {
//    			// use the all args constructor to create a new User object from each returned row from the DB
//    			User u = new User(
//    				// we want to use rs.get from each column in the record
//    				//	rs.getInt("ers_user_id"),		// DB use only?
//    					rs.getString("ers_username"),  // 211231 says Null. why?
//    					rs.getString("user_first_name"),
//    					rs.getString("user_last_name"),
//    				//	rs.getString("ers_password"), // confidential?
//    					rs.getString("user_email"),
//    					rs.getInt("user_role_id")
//    					);
//    			// populate the ArrayList with each new User object
//    			//userList.add(u); // u is the new User object we created above
//    			userbyid = u;
//    			
//    			//Optional<User> userbyid = Optional.ofNullable(u);
//    		}
    		
    		
    		
    		
    		     			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethiong went wrong trying to verify username!");
			e.printStackTrace();
		}		
    return 0; // this username is available to use or not found
	//return false;
    		
    }
	

//+++For DB Update: 2 ++++whether email +++++220113+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
		
	public boolean user_emailFound4dbUpdate (String regis_email, int users_id) {
			
			try(Connection conn = ConnectionFactory.getConnection()) {
	    		// Initiate an empty ResultSet object that will store the results of our SQL query
	    		ResultSet rs = null;
	    		
	    		// Write a query that we want to send to the database, and assign it to a String
	    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
	    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
	     		//String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
	    		
	    		String sql = " SELECT \n"
	    				+ "user_email \n"
	    				+ "FROM ers_users\n"
	    				//+ "LEFT JOIN ers_user_roles \n"
	    				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
	    				+ "WHERE user_email = ? AND ers_users_id != users_id";

	    		// schema name to be included. otherwise JDBC do not see the table
	    		// Put the SQL query into a Statement object (The Connection object has a method for this)
	    		// Statement statement = conn.createStatement();
	    		// This time should use PreparedStatement to prevent SQL injection
	    		PreparedStatement ps = conn.prepareStatement(sql);
	    		// put the username parameter in the PreparedStatement to complete the SQL
	    		ps.setString(1, regis_email); // 1st question mark in SQL, its variable
	    		ps.setInt(2, users_id); // check all records except for the user in question, since 
	    		// its prior email was unique
	    		
	    		// Execute the query, by putting the results into our ResultSet object
	    		// The Statement object has a method that takes Strings to execute as a SQL query
	    		//rs = statement.executeQuery(sql);
	    		rs = ps.executeQuery(); // sql already included in ps on line 33
	    		
	    		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
	    		
	    		//Create an empty ArrayList to be filled with the data from the database
	    		// since username is unique, just need a user object to take the sql results
	    		//List<User> userList = new ArrayList<>();
	    			while(rs.next()) {
	    				if (rs.wasNull()) {   // when the result is null: no duplicate email found
	    					throw new MyEmailNotFoundException("Email Not Existing at user update");
	    				//	return false; // unreadable code 220113
	    				} else {
	    					
	    				////String  rsResult = rs.getString("ers_username");
		        		////int ers_users_idFound = rs.getInt("ers_users_id");
		        		////String erspasswordFound = rs.getString("ers_password");
		    	   		
			        		String  rsMail = rs.getString("user_email");
			        		if (rsMail.equalsIgnoreCase(regis_email)== true) {
			        			return true;			
			        		}  else {
			        			throw new MyEmailNotFoundException("Email Address Not Found");		
			        		}
	    				}
		    				////if (erspasswordFound.equals(password) ) {
	        			////return ers_users_idFound;
	        			//// return true;
	        			////}  else {
	        			////throw new MyPasswordNoMatchException("Password No Match");		
	        		}
	    		} catch (MyEmailNotFoundException e) {
	    				return false;
	    				//e.printStackTrace();  // unreadable code after "return"
	    				//e.getLocalizedMessage();
	    				//System.out.println("Email Address Not Existing at update.");
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    				System.out.println("Somethiong went wrong trying to verify email!");
	    				e.printStackTrace();
	    				e.getLocalizedMessage();
	    		}
	    				
	    		
	     return false;
	    		
	    }

// +++++++++++ NOT for DB Update: Optional GetUserByUsername

	
//	++++++Used when DB update is not involved++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public Optional<User> getUserByUsername (String username) {	
		try(Connection conn = ConnectionFactory.getConnection()) {
    		// Initiate an empty ResultSet object that will store the results of our SQL query
    		ResultSet rs = null;
    		
    		// Write a query that we want to send to the database, and assign it to a String
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
     		//String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
    		
    		String sql = " SELECT \n"
    				+ "(ers_username, \n"   // it was missing and 211231 userbyid result was null
    				+ "ers_password, \n"
    				+ "user_email, \n"
            		+ "user_role_id, \n" // User itself cannot change the role
            		+ "user_last_name, \n"
            		+ "user_first_name, \n"
            		+ "ers_users_id) \n"
    				+ "FROM ers_users\n"
    				//+ "LEFT JOIN ers_user_roles \n"
    				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
    				+ "WHERE ers_username = ?";

    		// schema name to be included. otherwise JDBC do not see the table
    		// Put the SQL query into a Statement object (The Connection object has a method for this)
    		// Statement statement = conn.createStatement();
    		// This time should use PreparedStatement to prevent SQL injection
    		PreparedStatement ps = conn.prepareStatement(sql);
    		// put the username parameter in the PreparedStatement to complete the SQL
    		ps.setString(1, username); // 1st question mark in SQL, its variable
    		
    		// Execute the query, by putting the results into our ResultSet object
    		// The Statement object has a method that takes Strings to execute as a SQL query
    		//rs = statement.executeQuery(sql);
    		rs = ps.executeQuery(); // sql already included in ps on line 33
    		System.out.println("LDAO -Get User by username: "+ rs.toString());
    		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
    		
    		//Create an empty ArrayList to be filled with the data from the database
    		// since username is unique, just need a user object to take the sql results
    		//List<User> userList = new ArrayList<>();
    		while(rs.next()) {
//    			if(rs.wasNull()) {
//    				return null; // no user found per username
//    			} else {
    				
    			
//		    		//String  rsResult = rs.getString("ers_username");
//		    		int user_role_idFound = rs.getInt("user_role_id");
//		    		if (user_role_idFound > 0) {
//		    			return user_role_idFound;
//		    			// return true;
		    		   		
//    		while(rs.next()) {
//    			// use the all args constructor to create a new User object from each returned row from the DB
    				User u = new User(
    				// we want to use rs.get from each column in the record
    					rs.getString("ers_username"),  // 211231 says Null. why? user not found per username provided
        				rs.getString("ers_password"), // confidential?
    					rs.getString("user_email"),
    					rs.getInt("user_role_id"), 
    					rs.getString("user_last_name"),
    					rs.getString("user_first_name"),
    					rs.getInt("ers_users_id")		// User constructor #07 220113 
    					);
//    			// populate the ArrayList with each new User object
//    			//userList.add(u); // u is the new User object we created above
//    			userbyid = u;
//    			
    			Optional<User> ou = Optional.ofNullable(u); // Optional User By Username
    			return ou;
				//}
     		}
 	} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethiong went wrong trying to verify username!");
			e.printStackTrace();
		}		
    return null;
    // return 0;
	//return false;
    		
    }

	
	
	
// 1 +++NOT for DB update ++++ Login Username Found method for "unique" or "found" answers =====================
		// to be called by services like login, createUser or updateUser
//		public boolean ers_usernameFound (String username) {
	//  +++++++ return user_role_id as found proof, as part of response to frontend	220110
//		++++++Used when DB update is not involved++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		public int ers_usernameFound (String username) {	
			try(Connection conn = ConnectionFactory.getConnection()) {
	    		// Initiate an empty ResultSet object that will store the results of our SQL query
	    		ResultSet rs = null;
	    		
	    		// Write a query that we want to send to the database, and assign it to a String
	    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
	    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
	     		//String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
	    		
	    		String sql = " SELECT \n"
	    				+ "user_role_id \n"
	    				+ "FROM ers_users\n"
	    				//+ "LEFT JOIN ers_user_roles \n"
	    				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
	    				+ "WHERE ers_username = ?";

	    		// schema name to be included. otherwise JDBC do not see the table
	    		// Put the SQL query into a Statement object (The Connection object has a method for this)
	    		// Statement statement = conn.createStatement();
	    		// This time should use PreparedStatement to prevent SQL injection
	    		PreparedStatement ps = conn.prepareStatement(sql);
	    		// put the username parameter in the PreparedStatement to complete the SQL
	    		ps.setString(1, username); // 1st question mark in SQL, its variable
	    		
	    		// Execute the query, by putting the results into our ResultSet object
	    		// The Statement object has a method that takes Strings to execute as a SQL query
	    		//rs = statement.executeQuery(sql);
	    		rs = ps.executeQuery(); // sql already included in ps on line 33
	    		
	    		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
	    		
	    		//Create an empty ArrayList to be filled with the data from the database
	    		// since username is unique, just need a user object to take the sql results
	    		//List<User> userList = new ArrayList<>();
	    		while(rs.next()) {
	    		//String  rsResult = rs.getString("ers_username");
	    		int user_role_idFound = rs.getInt("user_role_id");
	    		if (user_role_idFound > 0) {
	    			return user_role_idFound;
	    			// return true;
	    		}
	    		
	    		}
//	    		while(rs.next()) {
//	    			// use the all args constructor to create a new User object from each returned row from the DB
//	    			User u = new User(
//	    				// we want to use rs.get from each column in the record
//	    				//	rs.getInt("ers_user_id"),		// DB use only?
//	    					rs.getString("ers_username"),  // 211231 says Null. why?
//	    					rs.getString("user_first_name"),
//	    					rs.getString("user_last_name"),
//	    				//	rs.getString("ers_password"), // confidential?
//	    					rs.getString("user_email"),
//	    					rs.getInt("user_role_id")
//	    					);
//	    			// populate the ArrayList with each new User object
//	    			//userList.add(u); // u is the new User object we created above
//	    			userbyid = u;
//	    			
//	    			//Optional<User> userbyid = Optional.ofNullable(u);
//	    		}
	    		
	    		
	    		
	    		
	    		     			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Somethiong went wrong trying to verify username!");
				e.printStackTrace();
			}		
	    return 0;
		//return false;
	    		
	    }
	
	
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
// 2 ++++++++ Login User Password Match-per-Username/Password Method ++++++++++++++++++++	
// to be called by createUser or updateUser
	//public boolean ers_passwordMatch (String username, String password) {
// +++++++ return ers_users_id as match proof, as part of response to frontend
	public int ers_passwordMatch (String username, String password) {
		
		try(Connection conn = ConnectionFactory.getConnection()) {
    		// Initiate an empty ResultSet object that will store the results of our SQL query
    		ResultSet rs = null;
    		
    		// Write a query that we want to send to the database, and assign it to a String
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
     		//String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
    		
    		String sql = " SELECT \n"
    				+ "ers_users_id, \n"
    				+ "ers_password \n"
    				+ "FROM ers_users\n"
    				//+ "LEFT JOIN ers_user_roles \n"
    				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
    				+ "WHERE ers_username = ?";

    		// schema name to be included. otherwise JDBC do not see the table
    		// Put the SQL query into a Statement object (The Connection object has a method for this)
    		// Statement statement = conn.createStatement();
    		// This time should use PreparedStatement to prevent SQL injection
    		PreparedStatement ps = conn.prepareStatement(sql);
    		// put the email parameter in the PreparedStatement to complete the SQL
    		ps.setString(1, username); // 1st question mark in SQL, its variable
    		
    		// Execute the query, by putting the results into our ResultSet object
    		// The Statement object has a method that takes Strings to execute as a SQL query
    		//rs = statement.executeQuery(sql);
    		rs = ps.executeQuery(); // sql already included in ps on line 33
    		System.out.println(rs);
    		
    		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
    		
    		//Create an empty ArrayList to be filled with the data from the database
    		// since username is unique, just need a user object to take the sql results
    		//List<User> userList = new ArrayList<>();
    		while(rs.next()) {
        		//String  rsResult = rs.getString("ers_username");
        		int ers_users_idFound = rs.getInt("ers_users_id");
        		String erspasswordFound = rs.getString("ers_password");
        		
        			if (erspasswordFound.equals(password) ) {
        			return ers_users_idFound;
        			// return true;
        			}  else {
        			
        			throw new MyPasswordNoMatchException("Password No Match");		
        			}
        	}
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethiong went wrong trying to verify password!");
			e.printStackTrace();
		} catch (MyPasswordNoMatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Password Incorrect. Try Again");
		} 	
    return 0;
	//return false;

	}

// ++++++++For search when DB  update is NOT involved  220113++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++ check username uniqueness, excluding userInSession: where users id != sessionUserid
// 3 ++++++++++++++ User Email Found Method for "unique" answers	+++++++++++++++++++++++++++++
	
	public boolean user_emailFound (String regis_email) {
		
		try(Connection conn = ConnectionFactory.getConnection()) {
    		// Initiate an empty ResultSet object that will store the results of our SQL query
    		ResultSet rs = null;
    		
    		// Write a query that we want to send to the database, and assign it to a String
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
     		//String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
    		
    		String sql = " SELECT \n"
    				+ "user_email \n"
    				+ "FROM ers_users\n"
    				//+ "LEFT JOIN ers_user_roles \n"
    				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
    				+ "WHERE user_email = ?";

    		// schema name to be included. otherwise JDBC do not see the table
    		// Put the SQL query into a Statement object (The Connection object has a method for this)
    		// Statement statement = conn.createStatement();
    		// This time should use PreparedStatement to prevent SQL injection
    		PreparedStatement ps = conn.prepareStatement(sql);
    		// put the username parameter in the PreparedStatement to complete the SQL
    		ps.setString(1, regis_email); // 1st question mark in SQL, its variable
    		
    		// Execute the query, by putting the results into our ResultSet object
    		// The Statement object has a method that takes Strings to execute as a SQL query
    		//rs = statement.executeQuery(sql);
    		rs = ps.executeQuery(); // sql already included in ps on line 33
    		
    		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
    		
    		//Create an empty ArrayList to be filled with the data from the database
    		// since username is unique, just need a user object to take the sql results
    		//List<User> userList = new ArrayList<>();
    			while(rs.next()) {
        		////String  rsResult = rs.getString("ers_username");
        		////int ers_users_idFound = rs.getInt("ers_users_id");
        		////String erspasswordFound = rs.getString("ers_password");
    	   		
	        		String  rsMail = rs.getString("user_email");
	        		if (rsMail.equalsIgnoreCase(regis_email)== true) {
	        			return true;			
	        		}  else {
	        			throw new MyEmailNotFoundException("Email Address Not Found");		
	        		}
       		
    				////if (erspasswordFound.equals(password) ) {
        			////return ers_users_idFound;
        			//// return true;
        			////}  else {
        			////throw new MyPasswordNoMatchException("Password No Match");		
        		}
    		} catch (MyEmailNotFoundException e) {
    				e.printStackTrace();
    				e.getLocalizedMessage();
    				System.out.println("Email Address Not Found.");
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    				System.out.println("Somethiong went wrong trying to verify email!");
    				e.printStackTrace();
    				e.getLocalizedMessage();
    		}
    				
    		
     return false;
    		
    }
	
	
	
// ++++status: wip 220113+++++++++ Login Session Identity Match by ers_users_id and user_role_id
	// 2 ++++++++ Login User Password Match-per-Username/Password Method ++++++++++++++++++++	
	// to be called by createUser or updateUser
// // based on	//public boolean ers_passwordMatch (String username, String password) {
	// +++++++ return result ers_users_id, status "User Logged In" as match proof, as part of response to frontend
	
//	public int ersusersidNuserroleidMatch (int userid, int roleid) {
//			
//			try(Connection conn = ConnectionFactory.getConnection()) {
//	    		// Initiate an empty ResultSet object that will store the results of our SQL query
//	    		ResultSet rs = null;
//	    		
//	    		// Write a query that we want to send to the database, and assign it to a String
//	    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
//	    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
//	     		//String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
//	    		
//	    		String sql = " SELECT \n"
//	    				+ "ers_users_id, \n"
//	    				+ "user_role_id \n"
//	    				+ "FROM ers_users\n"
//	    				//+ "LEFT JOIN ers_user_roles \n"
//	    				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
//	    				+ "WHERE ers_users_id = ? AND user_role_id =? ";
//
//	    		// schema name to be included. otherwise JDBC do not see the table
//	    		// Put the SQL query into a Statement object (The Connection object has a method for this)
//	    		// Statement statement = conn.createStatement();
//	    		// This time should use PreparedStatement to prevent SQL injection
//	    		PreparedStatement ps = conn.prepareStatement(sql);
//	    		// put the email parameter in the PreparedStatement to complete the SQL
//	    		/////ps.setString(1, username); // 1st question mark in SQL, its variable
//				ps.setInt(1, userid);
//				ps.setInt(2, roleid);
//	    		
//	    		// Execute the query, by putting the results into our ResultSet object
//	    		// The Statement object has a method that takes Strings to execute as a SQL query
//	    		//rs = statement.executeQuery(sql);
//	    		rs = ps.executeQuery(); // sql already included in ps on line 33
//	    		System.out.println(rs);
//	    		
//	    		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
//	    		
//	    		//Create an empty ArrayList to be filled with the data from the database
//	    		// since username is unique, just need a user object to take the sql results
//	    		//List<User> userList = new ArrayList<>();
//	    		while(rs.next()) {
//	        		//String  rsResult = rs.getString("ers_username");
//	        		int ers_users_idFound = rs.getInt("ers_users_id");
//	        		int user_role_idFound = rs.getInt("user_role_id");
//	        		
//	        			if (erspasswordFound.equals(password) ) {
//	        			return ers_users_idFound;
//	        			// return true;
//	        			}  else {
//	        			
//	        			throw new MyPasswordNoMatchException("Password No Match");		
//	        			}
//	        	}
//	    		
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				System.out.println("Somethiong went wrong trying to verify password!");
//				e.printStackTrace();
//			} catch (MyPasswordNoMatchException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("Password Incorrect. Try Again");
//			} 	
//	    return 0;
//		//return false;
//
//		}

	

// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// ++++++++ Below is playground
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
						
////4 +++++++ Login User ID Found method for user before registration =====================
//	// to be called by services like login, createUser or updateUser
//	public boolean ers_users_idFound (String username) {
//		
//		try(Connection conn = ConnectionFactory.getConnection()) {
// 		// Initiate an empty ResultSet object that will store the results of our SQL query
// 		ResultSet rs = null;
// 		
// 		// Write a query that we want to send to the database, and assign it to a String
// 		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
// 		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
//  		//String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
// 		
// 		String sql = " SELECT \n"
// 				+ "ers_users_id \n"
// 				+ "FROM ers_users\n"
// 				//+ "LEFT JOIN ers_user_roles \n"
// 				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
// 				+ "WHERE ers_username = ?";
//
// 		// schema name to be included. otherwise JDBC do not see the table
// 		// Put the SQL query into a Statement object (The Connection object has a method for this)
// 		// Statement statement = conn.createStatement();
// 		// This time should use PreparedStatement to prevent SQL injection
// 		PreparedStatement ps = conn.prepareStatement(sql);
// 		// put the username parameter in the PreparedStatement to complete the SQL
// 		ps.setString(1, username); // 1st question mark in SQL, its variable
// 		
// 		// Execute the query, by putting the results into our ResultSet object
// 		// The Statement object has a method that takes Strings to execute as a SQL query
// 		//rs = statement.executeQuery(sql);
// 		rs = ps.executeQuery(); // sql already included in ps on line 33
// 		
// 		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
// 		
// 		//Create an empty ArrayList to be filled with the data from the database
// 		// since username is unique, just need a user object to take the sql results
// 		//List<User> userList = new ArrayList<>();
// 		int rsResult = rs.getInt("ers_users_id");
// 		
// 		if (rsResult >0) {
// 			return true;
// 		}     			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Somethiong went wrong trying to register username!");
//			e.printStackTrace();
//		}		
// return false;
// 		
// }
				
		
// =========== Login 1 to grant a user access to corresponding ERS menus   ==================================================
// ++++++ Decision making should be in service layer. DAO areas should be a set of tools from DB data				
//	public User login(String username, String password) { // username should be unique in DB
//		try(Connection conn = ConnectionFactory.getConnection()) {
//					
//					
//					//Typically, you'll want to validate username/password against some username/password in the DATABASE.
//					//So in your P1, you'd be sending the data sent into the LoginDTO... 
//					//and most likely doing some DAO method that uses those values to check for matching values in the DB.
//					//soooooo we probably need a DAO method that has something like: 
//						//"select * from users where username = ? and password = ?" and then insert the values of the DTO for parameters
//					
//					//public boolean login(String username, String password) {
//					//	
//					//	//this is hardcoding - telling Java exactly what values make for a valid login
//					//	//in reality, you'll check the database for a username/password to see if a record exists
//					//	if(username.equals("user") && password.equals("password")) {
//							
//					//		return true; //true indicates successful login
//							
//			// should return Role so corresponding menu can be presented to user
//	
////		boolean unameMatch = this.usernameMatch(username);
////		boolean pwMatch = this.passwordMatch(password);
////					
////			if (unameMatch == true && pwMatch == true) {
////					
//			// Initiate an empty ResultSet object that will store the results of our SQL query		
//					ResultSet rs = null;
//					
//					// Write a query that we want to send to the database, and assign it to a String
//					// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
//					// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
//			 		//String sql = "SELECT * FROM ers_users WHERE ers_username = ? ers_password =? ";
//					String sql = " SELECT \n"
//		    				+ "ers_user_id, \n"
//							+ "user_role_id\n"
//		    				+ "FROM ers_users\n"
//		    				//+ "LEFT JOIN ers_user_roles \n"
//		    				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
//		    				+ "WHERE ers_username = ?";
//					//+ "WHERE ers_username = ? ers_password =? ";
//			
//					// schema name to be included. otherwise JDBC do not see the table
//					// Put the SQL query into a Statement object (The Connection object has a method for this)
//					// Statement statement = conn.createStatement();
//					// This time should use PreparedStatement to prevent SQL injection
//					PreparedStatement ps = conn.prepareStatement(sql);
//					// put the username parameter in the PreparedStatement to complete the SQL
//					ps.setString(1, username); // 1st question mark in SQL, its variable
//					//ps.setString(2, password); // 1st question mark in SQL, its variable
//					
//					// Execute the query, by putting the results into our ResultSet object
//					// The Statement object has a method that takes Strings to execute as a SQL query
//					//rs = statement.executeQuery(sql);
//					rs = ps.executeQuery(); // sql already included in ps on line 33
//					
//					// All the above makes a call to our database. Now we need to store the data in an ArrayList.
//					
//					//if (rs.wasNull()== false) {
//						// while there are results in the ResultSet..
//					//try {	
//							while(rs.next()) {
//							// use the all args constructor to create a new User object from each returned row from the DB
//							User loginUser = new User(
//// fix constructor for?			// we want to use rs.get from each column in the record
////									rs.getInt("ers_user_id"),		// DB use only?
////									rs.getString("ers_username"),  // 211231 says Null. why?
////									rs.getString("ers_password"), // confidential?
////									rs.getString("user_first_name"),
////									rs.getString("user_last_name"),
////									rs.getString("user_email"),
////									rs.getInt("user_role_id")
//									);
//							// populate the ArrayList with each new User object
//							return loginUser;
//								 
//							}
//			}
//							//} catch (SQLException e) {	
//												
//					//	System.out.println("Username and/or Password did not match");
//					//	e.printStackTrace();
//					//}
//					
//					// when there are no more results in rs, the while loop will break
//					// then return the populated ArrayList of Users
//					//return userbyid; // error msg: cannot be resolved to a variable
//					//return Optional.of(userbyid);
//					//return Optional.ofNullable(userbyid);
//							
//			} catch (SQLException e) {
//					System.out.println("Somethiong went wrong during logging by username!");
//					e.printStackTrace();
//			}
//				
//	return null;
//		 
//
//	}	
//	
//		
//		
	

}


//======== User Email Check Method ==========================================	
	// to be called by createUser or updateUser
//	public boolean emailUnique (String email) {
//	
//		try(Connection conn = ConnectionFactory.getConnection()) {
// 		// Initiate an empty ResultSet object that will store the results of our SQL query
// 		ResultSet rs = null;
// 		
// 		// Write a query that we want to send to the database, and assign it to a String
// 		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
// 		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
//  		//String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
// 		
// 		String sql = " SELECT \n"
// 				+ "user_email,\n"
// 				+ "FROM ers_users\n"
// 				//+ "LEFT JOIN ers_user_roles \n"
// 				//+ "ON ers_users.user_role_id = ers_user_roles.ers_user_role_id\n"
// 				+ "WHERE user_email = ?";
//
// 		// schema name to be included. otherwise JDBC do not see the table
// 		// Put the SQL query into a Statement object (The Connection object has a method for this)
// 		// Statement statement = conn.createStatement();
// 		// This time should use PreparedStatement to prevent SQL injection
// 		PreparedStatement ps = conn.prepareStatement(sql);
// 		// put the email parameter in the PreparedStatement to complete the SQL
// 		ps.setString(1, email); // 1st question mark in SQL, its variable
// 		
// 		// Execute the query, by putting the results into our ResultSet object
// 		// The Statement object has a method that takes Strings to execute as a SQL query
// 		//rs = statement.executeQuery(sql);
// 		rs = ps.executeQuery(); // sql already included in ps on line 33
// 		
// 		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
// 		
// 		//Create an empty ArrayList to be filled with the data from the database
// 		// since username is unique, just need a user object to take the sql results
// 		//List<User> userList = new ArrayList<>();
// 		String  rsResult = rs.getString("user_email");
// 		if (rsResult.equalsIgnoreCase(email)== false) {
// 			return true;
// 		}     			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Somethiong went wrong trying to verify emailaddress!");
//			e.printStackTrace();
//		}		
// return false;
//
//	};
//

