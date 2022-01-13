package com.revature.models;

/**
 * This concrete User class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>First Name</li>
 *     <li>Last Name</li>
 *     <li>Email</li>
 *     <li>Phone Number</li>
 *     <li>Address</li>
 * </ul>
 *
 */
public class User extends AbstractUser {
	
	// fields for the User table must match those in DB table ers_users
	private int ers_users_id;
	private String ers_username;
	private String ers_password;
	private String user_first_name;
	private String user_last_name; 
	private String user_email; 
	private Role user_role; // Not in DB ers_users table // employee 1, finance manager 2
	private int user_role_id; // DB ers_users_table employee 1, finance manager 2
	
//01 +++	// no args constructor

    public User() {
        super();
    }

    /**
     * This includes the minimum parameters needed for the {@link com.revature.models.AbstractUser} class.
     * If other fields are needed, please create additional constructors.
     */
//02 ++++++
    public User(int id, String username, String password, Role role) {
        super(id, username, password, role);
    }
    
//03 ++++++   user1 user registration or update from FrontEnd 
   // user id included for DB table ers_users (Role role to convert into user_role_id later)
    public User(String username, String password, String u_email, Role role, String user_l_name, String user_f_name) {
    	this.ers_username = username;
        this.ers_password = password;
        this.user_email = u_email;
        this.user_role = role;  
        this.user_last_name = user_l_name;           
    	this.user_first_name = user_f_name;
    }
    
//04 ++++  user2 in user registration or via UserDAO insert 
    // all args MINUS ers_users_id: we have the ability later to add a user, whose ers_user_id is auto-generated!
    // User(String, String, String, String, int)
    public User(String username, String password, String u_email,  int u_role_id, String user_l_name, String user_f_name) {
        //super(username, password, u_role);  // 220112 for regis Insert user1 missing password
        
        this.ers_username = username;
        this.ers_password = password;
        this.user_email = u_email;
        this.user_role_id = u_role_id;
        this.user_last_name = user_l_name;
        this.user_first_name = user_f_name;
              
    }
 
//05 ++++  user presentation format 1: no password ++++++++ 220122 add password in    
    // constructor for (Finance Manager)  get All users or getUserByusername
    // User(String, String, String, String, int)  
    public User(String username, String password, String u_email,  int user_role_id, String user_l_name, String user_f_name, int ers_users_id) {
        //super();
        this.ers_username = username; 
        this.ers_password = password;// it was missing and 211231 userbyid result was null
        this.user_email = u_email;
        this.user_role_id = user_role_id;
        this.user_last_name = user_l_name;
        this.user_first_name = user_f_name;
        this.ers_users_id = ers_users_id;
        //this.user_role = u_role;
    }

 //06 ++++ user presentation format 2: no password, no ers_users_id   // 220122 user1 no password. restored. after fix toString
 //++++ dao method udm7 ++++++ 220112 UserDAO insert not using it
    // constructor for Finance Manager to use to see select username by users
    // User(String, String, String, String, int, int)  // Auth used it @220111  add password item @220112 
    public User(String username, String u_email, int user_role_id, String user_l_name, String user_f_name) {
//        super();
      this.ers_username = username;   // it was missing and 211231 userbyid result was null
//      this.ers_password = password;   // 220112 error when trying regis 
      this.user_email = u_email;
      this.user_role_id = user_role_id;
//    //this.user_role = u_role;
      this.user_last_name = user_l_name;
      this.user_first_name = user_f_name;
    }   
    
// //07 ++++++ DB to user owner for menu directing   
//    // Constructor
    public User(String ers_username, String ers_password, int user_role_id, String u_email, String user_l_name, String user_f_name, int ers_users_id) {
//        super();
        this.ers_username = ers_username;   // it was missing and 211231 userbyid result was null
        this.ers_password = ers_password;
        this.user_email = u_email;
        this.user_role_id = user_role_id;  // User itself cannot change the role
        this.user_last_name = user_l_name;
        this.user_first_name = user_f_name;
        this.ers_users_id = ers_users_id; // used as user identifier, user itself cannnot change it
//        //this.user_role = u_role;
    }
    
 //08 +++++ User Self Update, by ers_users_id, excluding user_role_id   ++++status: WIP++220113++++++++++++++
//    // Constructor for user self update user info only
    public User(int ers_users_id, String ers_username, String ers_password, String u_email, String user_l_name, String user_f_name) {
        //super();
        this.ers_users_id = ers_users_id; // used as user identifier, user itself cannnot change it
        this.ers_username = ers_username;   // it was missing and 211231 userbyid result was null
        this.ers_password = ers_password;
        this.user_email = u_email;
    	this.user_last_name = user_l_name;
        this.user_first_name = user_f_name;
    }
    
    
    
////09 +++++++    
//    // our User objects can be printed out (without user_id and password) -- returns a String describing the object
//    // Constructor for passing successful user login to JS
//    public User(int ers_users_id, String user_first_name, String user_last_name, int user_role_id) {
//		// TODO Auto-generated constructor stub
//    	
//    	this.ers_users_id = ers_users_id;
//    	this.user_first_name = user_first_name;
//    	this.user_last_name = user_last_name;
//    	this.user_role_id = user_role_id;
//	}

 // 10 ++++++++   
// // Constructor for login password verification 
//    public User(int ers_users_id, String user_password) {
////        super();
//        this.ers_users_id = ers_users_id; // used as user identifier, user itself cannnot change it
////        this.ers_username = ers_username;   // it was missing and 211231 userbyid result was null
//        this.ers_password = ers_password;
////        this.user_first_name = user_f_name;
////        this.user_last_name = user_l_name;
////       this.user_email = u_email;
//    //    this.user_role_id = user_role_id;  // User itself cannot change the role
//        //this.user_role = u_role;
//    }
    
    
// ++++++++++ 220112 password missing here, so regis user1 has no password    
//	@Override
//	public String toString() {
//		return "User [ers_username=" + ers_username + ", user_first_name=" + user_first_name + ", user_last_name="
//				+ user_last_name + ", user_email=" + user_email + ", user_role_id=" + user_role_id + "]";
//	}
    
    
    // Getters and setters so we can access and change the private variables up above
    
    
  
// ++++++++++ 220112 add password back in toString    
    @Override
	public String toString() {
		return "User [ers_users_id=" + ers_users_id + ", ers_username=" + ers_username + ", ers_password="
				+ ers_password + ", user_first_name=" + user_first_name + ", user_last_name=" + user_last_name
				+ ", user_email=" + user_email + ", user_role=" + user_role + ", user_role_id=" + user_role_id + "]";
	}

    public int getErs_users_id() {
    	return ers_users_id;
    }
    
    
	public void setErs_users_id(int ers_users_id) {
    	this.ers_users_id = ers_users_id;
    }
    
    
	public String getErs_username() {
		return ers_username;
	}

	public void setErs_username(String ers_username) {
		this.ers_username = ers_username;
	}

	public String getErs_password() {
		return ers_password;
	}

	public void setErs_password(String ers_password) {
		this.ers_password = ers_password;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Role getUser_role() {
		int checkUserRoleID = user_role_id;
				
		switch (checkUserRoleID) {
		case 1: 
			return Role.EMPLOYEE;	
			// break;
		case 2: 
			return Role.FINANCE_MANAGER;
			// break;
		default:
			return Role.EMPLOYEE;
		}
		
		// return user_role;
	}

	public void setUser_role(Role user_role) {
		this.user_role = user_role;
	}

	public int getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}

    
    
    
    
    // HashCode() and equals() are necessary if we want to compare (test the equality of ) our objects
    // per data pulled out of our DB ers_users table
	
	

	
	
	
	   
    // method to convert enum Role to user_role_id, for DB query
    
    public int enumRoleToInt () {
    	Role roleInput = this.getUser_role();
    	int user_role_id = 1;
    	
    	switch (roleInput) {
    	case EMPLOYEE: 
    		user_role_id = 1;
    		break;
    	case FINANCE_MANAGER:
    		user_role_id = 2;
    		break;
    	default:
    		user_role_id = 1;
    		break;
    	}
    	return user_role_id;
    }
}