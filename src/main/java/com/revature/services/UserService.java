package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.models.User;
import com.revature.repositories.UserDAO;



/**
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required; 
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get Users by Email</li>
 *     <li>Get All Users</li>
 * </ul>
 */
public class UserService {
	
	UserDAO uDAO = new UserDAO();

	/**
	 *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
     */
	
	// Done getbyUserName 211231 ================================================================

	public Optional<User> getByUsername(String username) {
		
		return uDAO.getByUsername(username);
		
		//return Optional.empty();
	}
	
// ===== finance manager to get all users  ============================================
	// Done getAllUsers 211231
	public Optional<List<User>> getAllUsers() {
		
		return uDAO.getAllUsers();
		
		// for (User u : allUsers) {
		//	System.out.println(e);
		
		
		
		
		// return Optional.empty();
	}
	
	//start 211231
	//create new user by username...===================================================
	public void createUser(User newu) {
		
		uDAO.create(newu);
		
		//return Optional.empty();
	}
	
// ==== Menu E 2 ===== Employee Self Update User Info ================================
    
    public User eUserUpdate(User unupdated) {
    	
    	return uDAO.eupdate(unupdated);
    	
    }
	
	
	
	
	
}

