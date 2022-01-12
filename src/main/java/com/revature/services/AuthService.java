package com.revature.services;

import com.revature.exceptions.MyPasswordNoMatchException;
import com.revature.exceptions.MyUserEmailNotUniqueException;
import com.revature.exceptions.MyUserNotExistingException;
import com.revature.exceptions.NewUserHasNonZeroIdException;
import com.revature.exceptions.RegistrationUnsuccessfulException;
import com.revature.exceptions.UsernameNotUniqueException;
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
	
	
// 1 =============== whether to approve login and send user info for the next step 
	
    public User userLogin(LoginDTO logindto) {
    	User u2Ctx = new User();
    	LoginDAO ldao = new LoginDAO();
    	//UserDAO udao = new UserDAO();   // not needed if just return a slim user with role_id & user_id
    	
    	String username = logindto.getErs_username();
    	String password = logindto.getErs_password();
    	  	
    	  	
    	try {
//    		boolean unf = ldao.ers_usernameFound(username);
//    		boolean upm = ldao.ers_passwordMatch(username, password);
//    		to make the verification results more useful, the the data type changed
//			from boolean to int    		
    		int unf = ldao.ers_usernameFound(username);
    		System.out.println("current u2ctx userRoleId is " + unf);
    		int upm = ldao.ers_passwordMatch(username, password);
    		System.out.println("current u2ctx userId is " + upm);
    		// verify whether username is found
    		//if (unf == false )	{
    		if (unf == 0 )	{	
    			throw new MyUserNotExistingException("User Does Not Exist.");
    		// verify whether password is matched	
    		//} else if (upm == false ) {
    		} else if (upm == 0 ) {	
    			throw new MyPasswordNoMatchException("The Passwords Do Not Match");
    			
    		//} else if ((unf == true) && (upm == true)) {
    		} else if ((unf >0) && (upm >0)) {
    			//Optional<User> ou2Ctx = udao.getByUsername(username);
    				u2Ctx.setUser_role_id(unf);
    				u2Ctx.setErs_users_id(upm);
//    				int uid = u2Ctx.getErs_users_id();   		
//    	    		int urid = u2Ctx.getUser_role_id(); 
    		
    	    		// If userID is greater than 0, DB has records for the user
    	    		//if (uid > 0 ) {
    				//System.out.println(u2Ctx.toString());  // it did not show up in console
    	    		return u2Ctx;	
    			
    	    		//}
    	    		
    			   }	
    		
    	} catch (MyUserNotExistingException e) {
    		e.getStackTrace();
    		System.out.println("User Does Not Exist.");}
    	  catch (MyPasswordNoMatchException e) {
    		e.getStackTrace();
    		System.out.println("The Passwords Do Not Match."); }
    	  catch (RegistrationUnsuccessfulException e) {
    		e.getStackTrace();
    		System.out.println(e.toString());
    		System.out.println("Username does not exit!");
    		
    	}
    return null;
        
    }

// +++++++++++ pull requesting user info from DB
   
    
    
    
    
// ++++++++++++ verify username to be unique ++++++++++++++
    
    
    
    
     
    
    
    
// ++++++++++++ verify password to match ++++++++++++++++
    
    
    
    
    
    
    
    
    
// +++++++++++++verify email address to be unique ++++++++++++++
    
    
    
    
    
    
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
     * 
     */
    
    
    /**
     * <ul>
       *     <li>Should throw an exception if the creation is unsuccessful.</li> ++++ if UserDAO insert return is false
     *     <li>Should return a User object with an updated ID.</li> +++++++ It comes from UserDAO GetByUsername
     * </ul>
     *
     * Note: The userToBeRegistered will have an id=0, and username and password will not be null.
     * Additional fields may be null.
     */
        
    public User register(User userToBeRegistered) {
// actions include
//    	1. convert Role to int
//	   	2. various verifications 
//      3. Insert to DB
//    	4. Get user_role_id and ers_users_id and pack them as a thin user to Regis Auth controller 
//    	
//    	String un2ck = userToBeRegistered.getErs_username();
//   // if  	
//  // throw new  	UsernameNotUniqueException
    User u2Ctx = new User();
	LoginDAO ldao = new LoginDAO();
	UserDAO udao = new UserDAO();
	
	// Display what is received about the new user
	String username = userToBeRegistered.getErs_username();  // use it get user id afer insert by calling GetByUsername 
	String password = userToBeRegistered.getErs_password();
	int roleid = userToBeRegistered.getUser_role_id();
	int usersid = userToBeRegistered.getErs_users_id();
	String email = userToBeRegistered.getUser_email();  	
	  	
	boolean regisSuccess;
	try {
		int unf = ldao.ers_usernameFound(username);
		boolean uef = ldao.user_emailFound(email);
		// verify whether username is found
		if (unf > 0 )	{
			
			throw new UsernameNotUniqueException("Username Not Unique.");
		// verify whether password is matched	
		} else if (usersid != 0 ) {
			throw new NewUserHasNonZeroIdException("New User Has Non-Zero ID");
			
		} else if (uef == true) {
			throw new MyUserEmailNotUniqueException("User Email Not Unique");
		} else {
			// insert a new user in			
				regisSuccess = udao.create(userToBeRegistered);
				if (regisSuccess == true ) {
					User newU = new User();
					Optional<User> onewU = Optional.ofNullable(newU);
// not working		//	Optional<User> onewU =  new Optional<User>();
					onewU = udao.getByUsername(username);
					newU = onewU.get();
					usersid = newU.getErs_users_id();
					// gather info to send to frontend
					u2Ctx.setUser_role_id(roleid);
					u2Ctx.setErs_users_id(usersid);
					
					return u2Ctx;
			
	    		}
	    		throw new RegistrationUnsuccessfulException("Registration Failed.");
			   }	
		
	} catch (UsernameNotUniqueException e) {
		e.getStackTrace();
		e.getLocalizedMessage();
		System.out.println("User Does Not Exist.");}
	  catch (NewUserHasNonZeroIdException e) {
		e.getStackTrace();
		e.getLocalizedMessage();
		System.out.println("The Passwords Do Not Match."); }
	  catch (MyUserEmailNotUniqueException e) {
		  e.getStackTrace();
		  e.getLocalizedMessage();
		  System.out.println("User Email Not Unique");}
	  catch (RegistrationUnsuccessfulException e) {
		  e.getStackTrace();
		  e.getLocalizedMessage();
		  System.out.println("Registration Failed.");
	  
	  }
//	  catch (RegistrationUnsuccessfulException e) {
//		e.getStackTrace();
//		e.getLocalizedMessage();
//		System.out.println(e.toString());
//		System.out.println("Username does not exit!");
		
	//}
	return null;
    
    }

    
    
    /**
     * This is an example method signature for retrieving the currently logged-in user.
     * It leverages the Optional type which is a useful interface to handle the
     * possibility of a user being unavailable.
     */
    public Optional<User> exampleRetrieveCurrentUser() {
        return Optional.empty();
    }
}

