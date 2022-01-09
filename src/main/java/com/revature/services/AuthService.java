package com.revature.services;

import com.revature.exceptions.RegistrationUnsuccessfulException;
import com.revature.models.User;
import com.revature.models.LoginDTO;
import com.revature.repositories.LoginDAO;
import com.revature.repositories.UserDAO;

import java.util.Optional;

/**
 * The AuthService should handle login and registration for the ERS application.
 *
 * {@code login} and {@code register} are the minimum methods required; however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Retrieve Currently Logged-in User</li>
 *     <li>Change Password</li>
 *     <li>Logout</li>
 * </ul>
 */
public class AuthService {

    /**
     * <ul>
     *     <li>Needs to check for existing users with username/email provided.</li>
     *     <li>Must throw exception if user does not exist.</li>
     *     <li>Must compare password provided and stored password for that user.</li>
     *     <li>Should throw exception if the passwords do not match.</li>
     *     <li>Must return user object if the user logs in successfully.</li>
     * </ul>
    */
	
	User luser = new User();
	LoginDAO ldao = new LoginDAO();
	//UserDTO uDTO = new UserDTO();
	
    public User userLogin(String username, String password) {
        
    	
    	try {
    		ul = ldao.login(username, password);
    				
    		int uid = luser.getErs_users_id();   		
    		//int urid = ul.getUser_role_id();
    		
 //   		boolean unameMatch = this.usernameMatch(username);
//    		boolean pwMatch = this.passwordMatch(password);
//    					
//    			if (unameMatch == true && pwMatch == true) {
//    		
    		
    		
    		
    		if (uid > 0 ) {
    			
    			return ul;	
    			
    		}
    	
    
    	} catch (RegistrationUnsuccessfulException e) {
    		e.getStackTrace();
    		System.out.println(e.toString());
    		System.out.println("Username does not exit!");
    		
    	}
    return null;
        
    }

// +++++++++++ pull requesting user info from DB
    
    
    
    
    
    
    
    
// ++++++++++++ verify username to be unique ++++++++++++++
    
    
    
    
    
    
    
    
    
    
// ++++++++++++ verify password to match ++++++++++++++++
    
    
    
    
    
    
    
    
    
// +++++++++++++verify email address to be unqiue ++++++++++++++
    
    
    
    
    
    
    // +++++++++++ To Do: add new user ++++++++++++++++++++++++++    
    
    /**
     * <ul>
     *     <li>Should ensure that the username/email provided is unique.</li>
     *     <li>Must throw exception if the username/email is not unique.</li>
     *     <li>Should persist the user object upon successful registration.</li>
     *     <li>Must throw exception if registration is unsuccessful.</li>
     *     <li>Must return user object if the user registers successfully.</li>
     *     <li>Must throw exception if provided user has a non-zero ID</li>
     * </ul>
     *
     * Note: userToBeRegistered will have an id=0, additional fields may be null.
     * After registration, the id will be a positive integer.
     */
    
        
//    public User register(User userToBeRegistered) {
//
//    	
//    	String un2ck = userToBeRegistered.getErs_username();
//   // if  	
//  // throw new  	UsernameNotUniqueException
//    	
//    	
//    	
//    	
//    	
//    	
//    	
//    	return null;
//    }
//
  
    
    
    /**
     * This is an example method signature for retrieving the currently logged-in user.
     * It leverages the Optional type which is a useful interface to handle the
     * possibility of a user being unavailable.
     */
    public Optional<User> exampleRetrieveCurrentUser() {
        return Optional.empty();
    }
}

