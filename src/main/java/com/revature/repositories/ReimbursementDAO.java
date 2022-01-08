package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReimbursementDAO {

    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     */
    public Optional<Reimbursement> getById(int id) {
        return Optional.empty();
    }

    // start 211231 ===================== Fin Mgr: Get By Status required ==============================================
    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
    public List<Reimbursement> getByStatus(Status status) {
        
    	try(Connection conn = ConnectionFactory.getConnection()) {
    		// Initiate an empty ResultSet object that will store the results of our SQL query
    		// ResultSet rs = null;  // cannot do here, it will never get populated 220102
    		    		
    		// Write a query that we want to send to the database, and assign it to a String
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = username;"; // SQL stmt not taken as concatenated strings
    		// String sql = "SELECT * FROM rev1p211206.ers_users WHERE ers_username = ?";
     		//String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
    		
    		//switch (status.toString()) {
    		//case "Pending":
    		//String sql = "SELECT * FROM mv_reimb_by_status"; // working if not wrapped by other lines
    		//java.sql.Statement ss = conn.createStatement(); // working paired with above and below
    		//rs = ss.executeQuery(sql); //working good with above
    		
    		// now just select Reimbursement table
    		String sql = "SELECT * FROM rev1p211206.ers_reimbursement WHERE reimb_status_id = ? ORDER BY reimb_author";
    		
    			
    		//	break;
    		//}
    		
    		//String sql = "SELECT * FROM mv_reimb_by_status WHERE ers_reimbursement.reimb_status_id = ?";
    		

    		// schema name to be included. otherwise JDBC do not see the table
    		// Put the SQL query into a Statement object (The Connection object has a method for this)
    		// Statement statement = conn.createStatement();
    		// This time should use PreparedStatement to prevent SQL injection
    		//PreparedStatement ps = conn.prepareStatement(sql);
    		PreparedStatement ps = conn.prepareStatement(sql);
    		
    		 
    		
    		// put the username parameter in the PreparedStatement to complete the SQL
    		//ps.setString(1, username); // 1st question mark in SQL, its variable
    		System.out.println(status.toString());
    		if (status.toString().contentEquals("Pending")) {
    		
    		
    			ps.setInt(1, 1); // 1st question mark in SQL, its variable
    		}
    		
    		if (status.toString().contentEquals("Approved")) {
        		
        		ps.setInt(1, 2); // 1st question mark in SQL, its variable
        		}
    		
    		if (status.toString().contentEquals("Denied")) {
        		
        		 ps.setInt(1, 3); // 1st question mark in SQL, its variable
        		}
    		// Execute the query, by putting the results into our ResultSet object
    		// The Statement object has a method that takes Strings to execute as a SQL query
    		//rs = statement.executeQuery(sql);
    		//rs = ps.executeQuery(); // sql already included in ps on line 33
    		//rs = ps.executeUpdate(); // sql already included in ps on line 33
    		ResultSet rs = ps.executeQuery();
    		
    		// All the above makes a call to our database. Now we need to store the data in an ArrayList.
    		
    		//Create an empty ArrayList to be filled with the data from the database
    		// since username is unique, just need a user object to take the sql results
    		//List<User> userList = new ArrayList<>();
    		List<Reimbursement> reimblist = new ArrayList<>();
    		//User userbyid = new User();
    		
    		// while there are results in the ResultSet..
    		while(rs.next()) {
    			// use the all args constructor to create a new User object from each returned row from the DB
    			//User u = new User(
    			Reimbursement r = new Reimbursement(
    			// we want to use rs.get from each column in the recordset
    					rs.getInt("reimb_id"),                  // Constructor from reimb table 220102
    					rs.getDouble("reimb_amount"), 
    					rs.getTimestamp("reimb_submitted"), 
    					rs.getTimestamp("reimb_resolved"), 
    					rs.getString("reimb_description"), 
    					rs.getBlob("reimb_receipt"),
    	 				rs.getInt("reimb_author"),
    					rs.getInt("reimb_resolver"),
    					rs.getInt("reimb_status_id"),
    					rs.getInt("reimb_type_id")               // Constructor from reimb table 220102
    					);
    			
//    			rs.getString("reimb_status"), //mv_reimb_by_status
//				rs.getInt("reimb_author"),
//				rs.getInt("reimb_id"),
//				rs.getString("reimb_type"),
//				rs.getDouble("reimb_amount"), 
//				rs.getTimestamp("reimb_submitted"), 
//				rs.getTimestamp("reimb_resolved"), 
//				rs.getString("reimb_description"), 
//				rs.getBlob("reimb_receipt"), 
//				rs.getString("user_last_name"),
//				rs.getString("user_first_name"),
//				rs.getString("user_email"),
//				rs.getInt("reimb_resolver")
//		
    			// populate the ArrayList with each new User object
    			//userList.add(u); // u is the new User object we created above
    			reimblist.add(r);
    			
    			//Optional<User> userbyid = Optional.ofNullable(u);
    		}
    		
    		// when there are no more results in rs, the while loop will break
    		// then return the populated ArrayList of Users
    		//return userbyid; // error msg: cannot be resolved to a variable
    		//return Optional.of(userbyid);
    		//return Optional.ofNullable(reimblist);
    		return reimblist;
    				
    	} catch (SQLException e) {
    		System.out.println("Somethiong went wrong selecting reimbursements by status!");
    		e.printStackTrace();
    	}
    	
        //return Optional.empty();
        
    
    	
    	
    	    	
    	return Collections.emptyList();
    }

    
    // ================= Process Reimbursement by Fin Manager =========Menu item2=================================
    // * After processing, the reimbursement will have its status changed to either APPROVED or DENIED.
    
    
    
    
    
// ===== Menu E1 Done 211231 create a Reimbursement =======by Employee =================================================================
    
//    this.reimb_author = author_id;  // int
//	this.reimb_amount = amount; // double, required
//	this.reimb_description = desc; // string required
//	this.reimb_receipt = receipt; // blob
//	this.reimb_type_id = type_id; // int required -reimb type
//    
    
    // NO BLOB new request
    public void create(Reimbursement newReimb) {
    	
    	try(Connection conn  = ConnectionFactory.getConnection()) {
    		String sql = "INSERT INTO ers_reimbursement (reimb_author, reimb_amount, reimb_description, reimb_type_id, reimb_status_id, reimb_submitted) VALUES (?,?,?,?,?,?)";
    		// insert by fields only, not by SQL stmt
    		PreparedStatement ps = conn.prepareStatement(sql);
   		// parameter for reach question mark per order above 
       		ps.setInt(1, newReimb.getReimb_author());  // required entry: auth id
    		ps.setDouble(2, newReimb.getReimb_amount());  // required entry: amount
    		ps.setString(3, newReimb.getReimb_description()); // required entry: desc
    		ps.setInt(4, newReimb.getReimb_type_id());   // required type id
       		ps.setInt(5, newReimb.getReimb_status_id());     // required entry: status id
    		ps.setTimestamp(6, newReimb.getReimb_submitted());  // sys added submission date
       		
    		// executeUpdate, not execute query    		
    		ps.executeUpdate();  // 
    		
  		
    		System.out.println("Reimbursement entry Successful! --reimbDAO");		// shown after closed and opened after the above correction 211229
    		//ps.close();
    		
    		} catch(SQLException e) {
    			System.out.println("Reimbursement entry has failed. --reimbDAO");
    			e.printStackTrace();
    		}
 	
//    		if (Optional.ofNullable(userToBeRegistered) == null) {
//    			// 220101
//    	
//    			// noRegis("User registration not completed. Please try again.");
//    		}
    	
    }
    
    
    
 // ==== Menu E5 WIP 220102 =============== E Update Reimb ======= Problem: DB results null   
    
    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     */
    // employee update reimbursement made earlier if the status is not Approved
    
    public Reimbursement update(Reimbursement unprocessedReimbursement) {
    	
    	
//    	/**
//         * Update actor's last name based on actor's id
//         *
//         * @param id
//         * @param lastName
//         * @return the number of affected rows
//         */
//        public int updateLastName(int id, String lastName) {
//            String SQL = "UPDATE actor "
//                    + "SET last_name = ? "
//                    + "WHERE actor_id = ?";
//
            	int affectedrows = 0;

//    	String SQL = "UPDATE ers_reimbursement "
//    			+ "SET reimb_amount = ?, reimb_description = ? reimb_submitted = ?"
//    			+ "WHERE reimb_id = ? "
//    			+ " AND reimb_status_id = 1";
    	
    	String SQL = "UPDATE ers_reimbursement SET reimb_amount = ?, reimb_description = ? reimb_submitted = ? WHERE (reimb_id = ? AND reimb_status_id = 1)";
    	
    	
    	        try (Connection conn = ConnectionFactory.getConnection()
                    ) {
    	        PreparedStatement pstmt = conn.prepareStatement(SQL);	
                pstmt.setDouble(1, unprocessedReimbursement.getReimb_amount());
                pstmt.setString(2, unprocessedReimbursement.getReimb_description());
                pstmt.setTimestamp(3, unprocessedReimbursement.getReimb_submitted());
                pstmt.setInt(4, unprocessedReimbursement.getReimb_id());
                
                int myrid = unprocessedReimbursement.getReimb_id();
                
                System.out.println(unprocessedReimbursement.getReimb_submitted());
                System.out.println("myrid is " + myrid);
 
                //pstmt.executeUpdate(SQL);  // what syntax error?, then changed to no int version. Still 10:52pm 220102
                affectedrows = pstmt.executeUpdate();
                System.out.println("Rows affected "+ affectedrows);
                //pstmt.executeUpdate();
                //pstmt.execute();
                //pstmt.close();
                
                String sqlCheck = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
                PreparedStatement upps = conn.prepareStatement(sqlCheck);
           
                upps.setInt(1, myrid);
    			//Statement s = conn.createStatement();
    			ResultSet rs = upps.executeQuery();
    			
    			//ChallengeEmployee updatedChallengeEmployee = new ChallengeEmployee(
    			
    			Reimbursement nR = new Reimbursement(	
    						rs.getInt("reimb_id"),
    						rs.getDouble("reimb_amount"),
    						rs.getString("reimb_description"),
    						rs.getBlob("reimb_receipt"),
    						rs.getInt("reimb_type_id"),
    						rs.getInt("reimb_author"),
    						rs.getTimestamp("reimb_submitted")
    					);
                System.out.println("User " + nR.getUser_first_name() + "has updated his/her trxn id " + nR.getReimb_id());
    			return nR; 

            } catch (SQLException ex) {
            	System.out.println("Your reimbursement update has failed.");
            	ex.printStackTrace();
                System.out.println(ex.getMessage());
        }
				return null;
    }            
}    	       
   

