package com.revature.models;

import java.sql.Blob;
//import java.util.Date;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
//import java.time.LocalDateTime;

/**
 * This concrete Reimbursement class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>Description</li>
 *     <li>Creation Date</li>
 *     <li>Resolution Date</li>
 *     <li>Receipt Image</li>
 * </ul>
 *
 */
public class Reimbursement extends AbstractReimbursement {
	
	// set variables to private to protect privacy
	// fields for the Reimbursement table must match those in DB table ers_reimbursement
				
		private int reimb_id; //  serial PRIMARY KEY UNIQUE,
		private double reimb_amount; // decimal(16,2),
//		private String reimb_submitted; // timestamp, a String, not a class of Date or LocalDateTime
//		private String reimb_resolved; // timestamp,
		private Timestamp reimb_submitted; // timestamp, a String, not a class of Date or LocalDateTime
		private Timestamp reimb_resolved; // timestamp,

		
			// https://jdbc.postgresql.org/documentation/head/8-date-time.html
//		Table 5.1. Supported escaped numeric functions
//		PostgreSQL™ 	Java SE 8
//		DATE 	LocalDate
//		TIME [ WITHOUT TIMEZONE ] 	LocalTime
//		TIMESTAMP [ WITHOUT TIMEZONE ] 	LocalDateTime
//		TIMESTAMP WITH TIMEZONE 	OffsetDateTime
		// The timestamp is a string that represents a timestamp value in the format specified by format .
//		IYYY: ISO 8601 week-numbering year (4 or m...
//				YYYY: year in 4 digits
//				Pattern: Description
//
//				PostgreSQL TO_TIMESTAMP() Function By Practical Examples
//				https://www.postgresqltutorial.com › postgresql-to_timesta...
		
		
		private String reimb_description; //  varchar(250),
		private Blob reimb_receipt; // bytea, -- blob
		private int reimb_author; // int REFERENCES ers_users (ers_users_id), -- FOREIGN KEY: table (field)
		private int reimb_resolver; // int REFERENCES ers_users (ers_users_id),
		private int reimb_status_id; // int REFERENCES ers_reimbursement_status (reimb_status_id),
		private int reimb_type_id; // int REFERENCES ers_reimbursement_type (reimb_type_id) -- FOREIGN KEY
		
//      above fields are in the Reimbursement table
//		BELOW are fields to be used in reimbByStatus query
		private String reimb_status;
		
		
		
		
		//		reimb_author,
//		reimb_id;
		private String reimb_type;
//		reimb_amount, 
//		reimb_submitted, 
//		reimb_resolved, 
//		reimb_description, 
//		reimb_receipt, 
		private String user_last_name;
		private String user_first_name;
		private String user_email;
//		reimb_resolver
		
		

		
		// constructor for employee to create a reimbursement
		public Reimbursement (int author_id, double amount, String desc, Blob receipt, int type_id, int status_id)  {
			//super();
			this.reimb_author = author_id;  // int
			this.reimb_amount = amount; // double, required
			this.reimb_description = desc; // string required
			this.reimb_receipt = receipt; // blob
			this.reimb_type_id = type_id; // int required -reimb type
			this.reimb_status_id = status_id; // int required -reimb status
		}
		
// BLOB?	// constructor for employee to create a reimbursement without BLOB
				public Reimbursement (int author_id, double amount, String desc, int type_id, int status_id, Timestamp dSubm)  {
					//super();
					this.reimb_author = author_id;  // int per login
					this.reimb_amount = amount; // double, required per user
					this.reimb_description = desc; // string required per user
				//	this.reimb_receipt = receipt; // blob per user
					this.reimb_type_id = type_id; // int required -reimb type per user
					this.reimb_status_id = status_id; // int required -reimb status per sys
					this.reimb_submitted = dSubm; // Date submitted per sys
				}
		
		
		// constructor for employee to see all reimbursement transactions
		public Reimbursement (int author_id, int reimb_id, double amount, String desc, Blob receipt,
				int type_id, Timestamp dSubmitted, int status, Timestamp dResolved, int resolver_id )  {
			//super();
			this.reimb_author = author_id;  // int
			this.reimb_id = reimb_id; // reimb_id serial PRIMARY KEY UNIQUE,
			this.reimb_amount = amount; // double, required
			this.reimb_description = desc; // string required
			this.reimb_receipt = receipt; // blob
			this.reimb_type_id = type_id; // int required -reimb type
			this.reimb_submitted = dSubmitted; //	reimb_submitted timestamp,
			this.reimb_status_id = status; //	reimb_status_id int REFERENCES ers_reimbursement_status (reimb_status_id),
			this.reimb_resolved = dResolved; //			reimb_resolved timestamp,
			this.reimb_resolver = resolver_id; //	reimb_resolver int REFERENCES ers_users (ers_users_id),
		}
		
		// constructor for fin manager to get reimbursements by status -materialized view?
		public Reimbursement(String reimb_status, int reimb_author, int reimb_id, String reimb_type, 
				double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved, String reimb_description, 
				Blob reimb_receipt, String user_last_name, String user_first_name, String user_email, int reimb_resolver) {
			
			this.reimb_status = reimb_status; 
			this.reimb_author = reimb_author;
			this.reimb_id = reimb_id;
			this.reimb_type = reimb_type;
			this.reimb_amount = reimb_amount;
			this.reimb_submitted = reimb_submitted;
			this.reimb_resolved = reimb_resolved;
			this.reimb_description = reimb_description;
			this.reimb_receipt = reimb_receipt;
			this.user_last_name = user_last_name;
			this.user_first_name = user_first_name;
			this.user_email = user_email;
			this.reimb_resolver = reimb_resolver;
			
		}
		
//		reimb_id serial PRIMARY KEY UNIQUE,
//		reimb_amount decimal(16,2),
//		reimb_submitted timestamp,
//		reimb_resolved timestamp,
//		reimb_description varchar(250),
//		reimb_receipt bytea, -- blob
//		reimb_author int REFERENCES ers_users (ers_users_id), -- FOREIGN KEY: table (field)
//		reimb_resolver int REFERENCES ers_users (ers_users_id),
//		reimb_status_id int REFERENCES ers_reimbursement_status (reimb_status_id),
//		reimb_type_id int REFERENCES ers_reimbursement_type (reimb_type_id) -- FOREIGN KEY
//		
		
	
	
		// no args constructors
		public Reimbursement() {
			super();
		}

    
    	// minimum fields constructor
    /**
     * This includes the minimum parameters needed for the {@link com.revature.models.AbstractReimbursement} class.
     * If other fields are needed, please create additional constructors.
     */
		public Reimbursement(int id, Status status, User author, User resolver, double amount) {
			super(id, status, author, resolver, amount);
		}

		
// ======== Constructor from reimb table 220102 ============	
		
	public Reimbursement(int reimb_id, double reimb_amount, Timestamp reimb_submitted, 
			Timestamp reimb_resolved, String reimb_description, Blob reimb_receipt,
			int reimb_auther, int reimb_resolver, int reimb_status_id, int reimb_type_id) {
		// TODO Auto-generated constructor stub
		
		
	}

	
// ======= Constructor for employee update reimbursement menu item ======220102===============================	
	public Reimbursement(int reimb_id, double reimb_amount, String reimb_description, Blob reimb_receipt, int reimb_type_id, int reimb_author, Timestamp reimb_submitted) {
		// TODO Auto-generated constructor stub
	}

	// === getters and setters	
	
	
	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	public String getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
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

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	
	
	
	
	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public double getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}

	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}

	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}

	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public Blob getReimb_receipt() {
		return reimb_receipt;
	}

	public void setReimb_receipt(Blob reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}

	public int getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}

	public int getReimb_resolver() {
		return reimb_resolver;
	}

	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

	public int getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_receipt=" + reimb_receipt + ", reimb_author=" + reimb_author + ", reimb_resolver="
				+ reimb_resolver + ", reimb_status_id=" + reimb_status_id + ", reimb_type_id=" + reimb_type_id + "]";
	}
    
    
    
    
    
}
