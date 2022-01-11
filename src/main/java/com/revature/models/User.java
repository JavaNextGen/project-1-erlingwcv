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
    
//03 ++++++    
   // user id included for DB table ers_users (Role role to convert into user_role_id later)
    public User(int id, String username, String password, String user_f_name, String user_l_name, String u_email,  Role role) {
        super(id, username, password, role);
        //this.ers_users_id = id;
        //this.ers_username = username;
        //this.ers_password = password;
        this.user_first_name = user_f_name;
        this.user_last_name = user_l_name;
        this.user_email = u_email;
        //this.user_role = role;        
    }
    
//04 ++++
    // all args MINUS ers_users_id: we have the ability later to add a user, whose ers_user_id is auto-generated!
    // User(String, String, String, String, int)
    public User(String username, String password, String user_f_name, String user_l_name, String u_email,  Role u_role) {
        super(username, password, u_role);
        
        this.ers_username = username;
        this.ers_password = password;
        this.user_first_name = user_f_name;
        this.user_last_name = user_l_name;
        this.user_email = u_email;
        this.user_role = u_role;
    }
 
//05 ++++     
    // constructor for Finance Manager to use to see All users
    // User(String, String, String, String, int)  
    public User(String username, String user_f_name, String user_l_name, String u_email,  int user_role_id) {
        super();
        this.ers_username = username;   // it was missing and 211231 userbyid result was null
        this.user_first_name = user_f_name;
        this.user_last_name = user_l_name;
        this.user_email = u_email;
        this.user_role_id = user_role_id;
        //this.ers_users_id = ers_users_id;
        //this.user_role = u_role;
    }

 //06 ++++     dao method udm7
    // constructor for Finance Manager to use to see select username by users
    // User(String, String, String, String, int, int)  // Auth used it 220111
    public User(String username, String user_f_name, String user_l_name, String u_email,  int user_role_id, int ers_users_id) {
        super();
        this.ers_username = username;   // it was missing and 211231 userbyid result was null
        this.user_first_name = user_f_name;
        this.user_last_name = user_l_name;
        this.user_email = u_email;
        this.user_role_id = user_role_id;
        this.ers_users_id = ers_users_id;
        //this.user_role = u_role;
    }   
    
 //07 ++++++   
    // Constructor for employee self update
    public User(int ers_users_id, String ers_username, String ers_password, String user_f_name, String user_l_name, String u_email) {
        super();
        this.ers_users_id = ers_users_id; // used as user identifier, user itself cannnot change it
        this.ers_username = ers_username;   // it was missing and 211231 userbyid result was null
        this.ers_password = ers_password;
        this.user_first_name = user_f_name;
        this.user_last_name = user_l_name;
        this.user_email = u_email;
    //    this.user_role_id = user_role_id;  // User itself cannot change the role
        //this.user_role = u_role;
    }
    
 //08 +++++   
    // Constructor for employee self update email only, inlcuding the first and last name
    public User(int ers_users_id, String user_f_name, String user_l_name, String u_email) {
        super();
        this.ers_users_id = ers_users_id; // used as user identifier, user itself cannnot change it
//        this.ers_username = ers_username;   // it was missing and 211231 userbyid result was null
//        this.ers_password = ers_password;
        this.user_first_name = user_f_name;
        this.user_last_name = user_l_name;
        this.user_email = u_email;
    //    this.user_role_id = user_role_id;  // User itself cannot change the role
        //this.user_role = u_role;
    }
    
    
    
//09 +++++++    
    // our User objects can be printed out (without user_id and password) -- returns a String describing the object
    // Constructor for passing successful user login to JS
    public User(int ers_users_id, String user_first_name, String user_last_name, int user_role_id) {
		// TODO Auto-generated constructor stub
    	
    	this.ers_users_id = ers_users_id;
    	this.user_first_name = user_first_name;
    	this.user_last_name = user_last_name;
    	this.user_role_id = user_role_id;
	}

 // 10 ++++++++   
 // Constructor for login password verification 
    public User(int ers_users_id, String user_password) {
        super();
        this.ers_users_id = ers_users_id; // used as user identifier, user itself cannnot change it
//        this.ers_username = ers_username;   // it was missing and 211231 userbyid result was null
        this.ers_password = ers_password;
//        this.user_first_name = user_f_name;
//        this.user_last_name = user_l_name;
//       this.user_email = u_email;
    //    this.user_role_id = user_role_id;  // User itself cannot change the role
        //this.user_role = u_role;
    }
    
    
    
	@Override
	public String toString() {
		return "User [ers_username=" + ers_username + ", user_first_name=" + user_first_name + ", user_last_name="
				+ user_last_name + ", user_email=" + user_email + ", user_role_id=" + user_role_id + "]";
	}
    
    
    // Getters and setters so we can access and change the private variables up above
    
    
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