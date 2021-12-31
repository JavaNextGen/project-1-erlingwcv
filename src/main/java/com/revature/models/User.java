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
	private String user_enmail; 
	private Role user_role; // Not in DB ers_users table // emaployee 1, financie manager 2
	private int user_role_id; // DB ers_users_table emaployee 1, financie manager 2
	
	// no args constructor

    public User() {
        super();
    }

    /**
     * This includes the minimum parameters needed for the {@link com.revature.models.AbstractUser} class.
     * If other fields are needed, please create additional constructors.
     */
    public User(int id, String username, String password, Role role) {
        super(id, username, password, role);
    }
    
    
   // user id included for DB table ers_users (Role role to convert into user_role_id later)
    public User(int id, String username, String password, String user_f_name, String user_l_name, String u_email,  Role role) {
        super(id, username, password, role);
        //this.ers_users_id = id;
        //this.ers_username = username;
        //this.ers_password = password;
        this.user_first_name = user_f_name;
        this.user_last_name = user_l_name;
        this.user_enmail = u_email;
        //this.user_role = role;        
    }
    
    // all args MINUS ers_users_id: we have the ability later to add a user, whose ers_user_id is auto-generated!
    // User(String, String, String, String, int)
    public User(String username, String password, String user_f_name, String user_l_name, String u_email,  Role u_role) {
        super(username, password, u_role);
        
        this.ers_username = username;
        this.ers_password = password;
        this.user_first_name = user_f_name;
        this.user_last_name = user_l_name;
        this.user_enmail = u_email;
        this.user_role = u_role;
    }
    
    // constructor for Finance Manager to use to see All users
    // User(String, String, String, String, int)
    
    public User(String username, String user_f_name, String user_l_name, String u_email,  int user_role_id) {
        super();
        this.ers_username = username;   // it was missing and 211231 userbyid result was null
        this.user_first_name = user_f_name;
        this.user_last_name = user_l_name;
        this.user_enmail = u_email;
        this.user_role_id = user_role_id;
        //this.user_role = u_role;
    }
    
    
    // our User objects can be printed out (without user_id and password) -- returns a String describing the object
    
    @Override
	public String toString() {
		return "User [ers_username=" + ers_username + ", user_first_name=" + user_first_name + ", user_last_name="
				+ user_last_name + ", user_enmail=" + user_enmail + ", user_role_id=" + user_role_id + "]";
	}
    
    
    // Getters and setters so we can access and change the private variables up above
    
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

	public String getUser_enmail() {
		return user_enmail;
	}

	public void setUser_enmail(String user_enmail) {
		this.user_enmail = user_enmail;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ers_password == null) ? 0 : ers_password.hashCode());
		result = prime * result + ((ers_username == null) ? 0 : ers_username.hashCode());
		result = prime * result + ((user_enmail == null) ? 0 : user_enmail.hashCode());
		result = prime * result + ((user_first_name == null) ? 0 : user_first_name.hashCode());
		result = prime * result + ((user_last_name == null) ? 0 : user_last_name.hashCode());
		result = prime * result + user_role_id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (ers_password == null) {
			if (other.ers_password != null)
				return false;
		} else if (!ers_password.equals(other.ers_password))
			return false;
		if (ers_username == null) {
			if (other.ers_username != null)
				return false;
		} else if (!ers_username.equals(other.ers_username))
			return false;
		if (user_enmail == null) {
			if (other.user_enmail != null)
				return false;
		} else if (!user_enmail.equals(other.user_enmail))
			return false;
		if (user_first_name == null) {
			if (other.user_first_name != null)
				return false;
		} else if (!user_first_name.equals(other.user_first_name))
			return false;
		if (user_last_name == null) {
			if (other.user_last_name != null)
				return false;
		} else if (!user_last_name.equals(other.user_last_name))
			return false;
		if (user_role_id != other.user_role_id)
			return false;
		return true;
	}
    
	
	
	   
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