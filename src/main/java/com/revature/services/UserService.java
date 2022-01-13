package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.exceptions.MyAccountUnauthorizedException;
import com.revature.exceptions.MyUserEmailNotUniqueException;
import com.revature.exceptions.RegistrationUnsuccessfulException;
import com.revature.exceptions.UsernameNotUniqueException;
import com.revature.models.User;
import com.revature.models.UserNRole;
import com.revature.repositories.LoginDAO;
import com.revature.repositories.UserDAO;
import com.revature.results.FMuserViews;



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
	FMuserViews uView = new FMuserViews();
	
	
//===== +++++++ Convert Role from String to int +++++++from Javalin to DB++++++++++++++++++++
		public int userRoleStringToId(String role) {
			switch (role) {
			case "EMPLOYEE":
				return 1;
			case "FINANCE_MANAGER":
				return 2;
			default:
				return 1;
			}	
		}

	
//220113 ++++++++  User Self Update User Info by ers_users_id ++++++++as Manager or as Employ ++++++++++++++++++++++++++		

	    public User selfUpdate(User userToBeUpdated) {
	    //public User selfUpdate(User userToBeUpdated, int SessionUserId, int SessionRoleId) { // assume verified
	    	//// actions include
//////	    	1. assume (next version to make sure) ers_users_id and user_role_id correct
//////		   	2. various verifications like registration
//////	      3. Insert to DB
//////	    	4. Get user_role_id and ers_users_id and pack them as a thin user to Regis Auth controller 
//////	    	
////   // if  	
//	////  // throw new  	UsernameNotUniqueException.
	    User user2 = new User(); // to find userId by username4Auth
	    User user3 = new User();  // assembled to send back to controller
		LoginDAO ldao = new LoginDAO();
		UserDAO udao = new UserDAO();
	
//		// Display what is received about the user1 from Client
		String username = userToBeUpdated.getErs_username();  // use it get user id afer insert by calling GetByUsername 
		String password = userToBeUpdated.getErs_password();
		//int roleid = userToBeUpdated.getUser_role_id();
		String email = userToBeUpdated.getUser_email(); 
		String lname = userToBeUpdated.getUser_last_name();
		String fname = userToBeUpdated.getUser_first_name();
		
		int sessionUserid = userToBeUpdated.getErs_users_id();
		// confirm the session by verifying it with the userId by getbyusername
		Optional<User> ouser2 = udao.username4Auth(username);
		user2 = ouser2.get();
		int usersid = user2.getErs_users_id();
		int roleid = user2.getUser_role_id();
		
		user2.setErs_username(username);
		user2.setErs_password(password);
		user2.setUser_email(email);
		//user2.setUser_role_id(roleid);   // user_role_id no change
		user2.setUser_last_name(lname);
		user2.setUser_first_name(fname);
		//user2.setErs_users_id(usersid); ers_users_id no change
		System.out.println("selfUpdate user2 toString" + user2.toString());
		
//		User afterU = new User();
//		Optional<User> onewU = Optional.ofNullable(newU);
////// not working		//	Optional<User> onewU =  new Optional<User>();
//		onewU = udao.username4Auth(username);

		
		
		
		boolean updateSuccess;
		try {
			int unf = ldao.ers_usernameFound(username);
			boolean uef = ldao.user_emailFound(email);
			// provide ers_users_id, if found by username
			if (sessionUserid != usersid) {
				
				throw new MyAccountUnauthorizedException("Unauthorized Session!");
			}
			
			if (unf > 0 && unf != usersid)	{
				
				throw new UsernameNotUniqueException("Username Not Unique.");
			// verify whether password is matched	
//			} else if (usersid != 0 ) {
//				throw new NewUserHasNonZeroIdException("New User Has Non-Zero ID");
//				
			} else if (uef == true && unf != usersid) {
				throw new MyUserEmailNotUniqueException("User Email Not Unique");
			} else {
//				// self update the user in session			
//+++++++++++++++	// regisSuccess = udao.updateSelf(userToBeUpdated);
					updateSuccess = udao.updateSelf(user3);
					   System.out.println("selfUpdate user2 Success? "+updateSuccess);  // 220113
					if (updateSuccess == true ) {
						
//						User afterU = new User();
//						Optional<User> onewU = Optional.ofNullable(newU);
//	//// not working		//	Optional<User> onewU =  new Optional<User>();
//						onewU = udao.username4Auth(username);
//						newU = onewU.get();
//						usersid = newU.getErs_users_id();
//						// gather info to send to frontend
						user3.setUser_role_id(roleid);
						user3.setErs_users_id(usersid);
						
						
						return user3;
				
					}
		    		throw new RegistrationUnsuccessfulException("User Self Update Failed.");
				   }	
			
		} catch (MyAccountUnauthorizedException e) {
			e.getStackTrace();
			e.getLocalizedMessage();
			System.out.println("user self Update failed: Account Access Unauthorized.");
		}
			catch (UsernameNotUniqueException e) {
			e.getStackTrace();
			e.getLocalizedMessage();
			System.out.println("User Does Not Exist.");}
//		  catch (NewUserHasNonZeroIdException e) {
//			e.getStackTrace();
//			e.getLocalizedMessage();
//			System.out.println("The Passwords Do Not Match."); }
		  catch (MyUserEmailNotUniqueException e) {
			  e.getStackTrace();
			  e.getLocalizedMessage();
			  System.out.println("User Email Not Unique");}
		  catch (RegistrationUnsuccessfulException e) {
			  e.getStackTrace();
			  e.getLocalizedMessage();
			  System.out.println("User Self Update Failed.");
		  
		  }
////		  catch (RegistrationUnsuccessfulException e) {
////			e.getStackTrace();
////			e.getLocalizedMessage();
////			System.out.println(e.toString());
////			System.out.println("Username does not exit!");
//			
		//}
		return null;
	//    
	    }
		
		
		
	


//+++++++ fin mgr == getbyUserName 211231 done +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		/**
		 *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
	     */

		
		
		
//	public Optional<User> getByUsername(String username) {
//		
//		return uDAO.getByUsername(username);
//		
//		//return Optional.empty();
//	}
	
// ===== fin manager to get all users  ============================================
	// Done getAllUsers 211231
//	public Optional<List<User>> getAllUsers() {
//		
//		return uDAO.getAllUsers();
//		
		// for (User u : allUsers) {
		//	System.out.println(e);
		// return Optional.empty();
	public List<UserNRole> getAllUsers() {
			
			return uView.getAllUsers();
		
		
		
	}
	

	
	
	
	
	
}

