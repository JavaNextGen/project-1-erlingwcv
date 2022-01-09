package com.revature.models;

public class UserNRole{
	private String ers_username;
	private String user_email; 
	private String user_role;
	private String user_last_name;
	private String user_first_name;
	private int ers_users_id;
	
	
// No Args Constructor	
	public UserNRole() {
		super();
		//this.user_role = user_role;
		}
	
// Fin Mgr View Constructor
	public UserNRole(String ers_username, String user_email, String user_role, String user_last_name,
			String user_first_name, int ers_users_id) {
		this.ers_username = ers_username;
		this.user_email = user_email;
		this.user_role = user_role;
		this.user_last_name = user_last_name;
		this.user_first_name = user_first_name;
		this.ers_users_id = ers_users_id;
		
		}
	
	
	
	
	
	
	
	// getter and setter
	
	public String getErs_username() {
		return ers_username;
	}

	public void setErs_username(String ers_username) {
		this.ers_username = ers_username;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public int getErs_users_id() {
		return ers_users_id;
	}

	public void setErs_users_id(int ers_users_id) {
		this.ers_users_id = ers_users_id;
	}

	public String getUser_role() {
		return user_role;
	}

	

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	
	
	
	
}


//ers_username,
//user_email, 
//user_role,
//user_last_name, 
//user_first_name,
//ers_users_id 
//FROM ers_users
//LEFT JOIN ers_user_roles 
//ON ers_users.user_role_id = ers_user_roles.ers_user_role_id
//ORDER BY user_last_name;
