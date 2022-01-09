//package com.revature.usermenus;
//
//import com.revature.models.Reimbursement;
//import com.revature.models.Status;
//import com.revature.models.User;
//import com.revature.repositories.UserDAO;
//import com.revature.services.ReimbursementService;
//import com.revature.services.UserService;
//import com.revature.util.ConnectionFactory;
//
//import java.nio.file.FileSystemNotFoundException;
//import java.sql.Blob;
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.OffsetDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.Optional;
//import java.util.Scanner;	
//
//// Done by 211231
//// Start 12/15/2021
//// Soft Due date:
//// Hard Due date: 
////This Menu Class will have a displayMenu() method that displays the menu to the user and
//	// lets them interact with the menu
//	// The menu will make use of the Scanner class to take user inputs in order to travel
//	// through the menu options
//
//
//public class CLImenu {
//	
//	static String cUserName;
//	static String cPassword;
//
//	static int user_id;
//	
//	// All of the menu display options and control are contained within this method
//	UserService us = new UserService(); // use its methods on menu items selected
//	//UserDAO uDAO = new UserDAO(); // DAO cannot be seen by users
//	ReimbursementService rms = new ReimbursementService(); // Users can only see services
//	
//	
//	Scanner scan = new Scanner(System.in);  // Scanner object to parse user input
//
//	public void userMenu( ) {
//		// ============= include user id? =================================
//		// should take a parameter for user_id
//		
//		//UserService us = new UserService();
//		//ReimbursementService rms = new ReimbursementService();
//		
//		boolean displayMenu = true; // to toggle with the menu will continue after user input
//		//Scanner scan = new Scanner(System.in);  // Scanner object to parse user input
//		
//		// First, let's give the user a pretty greeting :)
//		
//		System.out.println("=============================================================");
//		System.out.println("Hello User, Welcome to The Employee Reimbursment System (ERS)");
//		System.out.println("=============================================================");
//		
//		// display the menu as long as variable displayMenu == true
//		// This is going to hold and display all the menu options until displayMneu == false
//		
//		while(displayMenu) {
//			
//			// Menu options
//			// per folder .services/UserService.java
//			
//			// =======Employee Menu===========To be coded ===============================================================================
//			System.out.println("Type the number that represents your selection: ");
//			System.out.println("1. Create User 220101");
//			System.out.println("2. Update User Information");
//			System.out.println("3. Review All Reimbursement Entries");
//			System.out.println("4. Create New Reimbursement Entry");
//			System.out.println("5. Update Unprocessed Reimbursements (by Reimb id)");
//			System.out.println("6. Exit: Log out the ERS Employee's Menu");
//			
//			//parse user input after they choose a menu option, and put it into a 
//			// String variable
//			
//			String input = scan.nextLine();
//			
//			// Ben to add more comments here once we do DATABASE CONNECTIVITY
//			
//			switch ("E"+input) {
//			
//			case "E1": {
//				
//				System.out.println("220101: Create User");
//				User anewu = new User();
//				
//				System.out.println("Enter your user info and enter/return after each entry:");
//				System.out.println("Username at the next login (required):");
//				String username = scan.nextLine();
//				anewu.setErs_username(username);
//				System.out.println("Password at the next login (required): "); 
//				String password = scan.nextLine();
//				anewu.setErs_password(password); 
//				System.out.println("Your First Name: ");
//				String fname = scan.nextLine();
//				anewu.setUser_first_name(fname);
//				System.out.println("Your Last Name: ");
//				String lname = scan.nextLine();
//				anewu.setUser_last_name(lname); 
//				System.out.println("Your valid email address (required): ");
//				String email = scan.nextLine();
//				anewu.setUser_enmail(email);
//				System.out.println("Your Role: 1 for Employee, 2 for Finance Manager (required): ");
//				int role_id = scan.nextInt();
//				anewu.setUser_role_id(role_id);				
//				
//				
//				us.createUser(anewu);
//				
//				System.out.println("220101: Your registration was successful!");
//				break;	
//			}
//
////  === Employee ===  2  2  2  2  ======   Update User info =====Done 220104 12:32am=============================			
//			case "E2": {
//				System.out.println("220101: Update User Information");
//				
//				//System.out.println("Your Username?");
//				//String upUn = scan.nextLine();
//				
//				User beforeUpdate = new User();
//				User afterUpdate = new User();
//				beforeUpdate.setErs_users_id(1);   // manually set now, should be from login
//				beforeUpdate.setUser_enmail("u1email3@gmail.com");
//				
//				afterUpdate = us.eUserUpdate(beforeUpdate);
//				
//				System.out.println("Below is for your records: ");
//				System.out.print("You,  " + afterUpdate.getUser_first_name());
//				System.out.println(" " + afterUpdate.getUser_last_name() + ", just changed your email to ");
//				System.out.println(afterUpdate.getUser_enmail());
//				
//				break;
//			}
//			
//			
//// === Employee === 3  3   3  3  =================================================			
//			case "E3": {
//				System.out.println("TBD: Update Reimbursement by Reimb ID");
//				
//				
//				
//				
//				
//			}
//			
//			case "E4": {
//				//System.out.println("4. Create New Reimbursement Entry");	================================
//				
//				Reimbursement anewR = new Reimbursement();
//				
////				ps.setInt(1, newReimb.getReimb_author());  // required entry: auth id
////	    		ps.setDouble(2, newReimb.getReimb_amount());  // required entry: amount
////	    		ps.setString(3, newReimb.getReimb_description()); // required entry: desc
////	    		ps.setBlob(, newReimb.getReimb_receipt());   // receipt
////				reimb type 4
//				//ps.setInt(5, newReimb.getReimb_status_id());     // required entry: status id
////	    		//           6. reimb_submitted date 
//				
//				System.out.println("Now enter info below for New Reimburesement request:");
//        		// 1. System Plug in -user who is making the request
//				// System plugs in author_id from login page per username and password
//// ****************** verify the legit user id
//				
//				int rm_id = 1; 
//// *****************  verify the legit user id
//				anewR.setReimb_author(rm_id); // hard code 
//				
//				// 2. amount (user1)
//				System.out.println("1. Amount to request for reimbursement (required):");
//				Double amount = scan.nextDouble();
//				anewR.setReimb_amount(amount);
//				
//				
//				// 3. desc (user2) 
//				System.out.println("2. Description for reimbursement request (required): "); 
//				
//				String desc = scan.next();  // .nextLine() making error like skipping. next() only good for one word
//				anewR.setReimb_description(desc);
//				
//// to do		// 4. receipt how to use Blob? (user)
////				// https://docs.oracle.com/javase/8/docs/api/java/sql/class-use/Blob.html
////				System.out.println("Receipt for your reimbursement request: ");
////				Blob blob =Connection.createBlob();
////				String receipt = scan.nextLine();
////				anewR.setReimb_receipt(CallableStatement.setBlob(receipt)); // 
////				
//				// 4. reimb type ?? (user3) (required)
//				System.out.println("3. Type of reimbursement request 1 LODGING,2 TRAVEL, 3FOOD, or4 OTHER.(required): "); 
//				int type_id = scan.nextInt();  // 220101 error : type mismatch
//				anewR.setReimb_type_id(type_id); // 1 LODGING,2 TRAVEL, 3FOOD, or4 OTHER.
//				
//				// 5. system plugs in below
//				// reimb status id (required)
//				int s_id = 1; // 1. Pending
//				anewR.setReimb_status_id(s_id); //  VALUES ('PENDING'),('APPROVED'),('DENIED');
//				
//				//  6. reimb submitted date -system plugs in 
//				// https://mkyong.com/java/java-date-and-calendar-examples/
//				//SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
//				//sdf.getCalendar();
//				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // error "yyyy/MM/dd HH:mm:ss"
//				LocalDateTime dS = LocalDateTime.now();
//				//OffsetDateTime ds = OffsetDateTime.now();
//				String now = dtf.format(dS);
//				Timestamp ds = Timestamp.valueOf(now);
//				anewR.setReimb_submitted(ds);
//				
//				
//				
//				rms.createReimb(anewR);
//				
//				System.out.println("220101: Your reimbursement request entry was successful!");
//				// scan.close(); // cannot close before the menu is exited
//				break;
//				
//				
//			}
//			
//			case "E5": {  //Menu E5 Update Unprocessed Reimbursements
//				Reimbursement unpro = new Reimbursement();
//				
//// control to do //1. ask and get reimb id verified 
//				System.out.println("Please enter reimb id to indicate which trxn to update: ");
//				int er_id = scan.nextInt();
//				unpro.setReimb_id(er_id);
//				
//				// 2. amount (user1)
//				System.out.println("1. Amount to request for reimbursement (required):");
//				Double amount = scan.nextDouble();
//				unpro.setReimb_amount(amount);
//				
//				
//				// 3. desc (user2) 
//				System.out.println("2. Description for reimbursement request (required): "); 
//				
//				String desc = scan.next();  // .nextLine() making error like skipping. next() only good for one word
//				unpro.setReimb_description(desc);
//				
//				// 3.
//				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // error "yyyy/MM/dd HH:mm:ss"
//				LocalDateTime dS = LocalDateTime.now();
//				//OffsetDateTime ds = OffsetDateTime.now();
//				String now = dtf.format(dS);
//				Timestamp ds = Timestamp.valueOf(now);
//				unpro.setReimb_submitted(ds);
//				
//				rms.updateReimb(unpro);
//				
//					
//				
//				break;
//			}
//			
//			case "E6": {
//				System.out.println("by 211231 You selected to exit");
//				displayMenu = false;
//				break;
//			}
//			default: {
//				System.out.println("Invalid selection. Please try again : '(");
//				break;
//			}
//			
//			
//			
//			}
//			
//			
//			
//		}
//		
//		scan.close();
//		System.out.println("You have logged out of the ERS  Employee's Menu.");
//	}
//	
//	
//// ===================================================================================================================	
//	// Finance Manager Only Menu
//	
//	// =====-===================================================
//	
//	public void finMgrMenu() {
//		
//		//UserService us = new UserService();  // declared at the beginning of the menu class, not the method
//		boolean displayMenu = true; // to toggle with the menu will continue after user input
//		//Scanner scan = new Scanner(System.in);  // Scanner object to parse user input
//		
//		// First, let's give the user a pretty greeting :)
//		
//		System.out.println("=============================================================");
//		System.out.println("Finance Manager, welcome to ERS, the Employee Reimbursment System");
//		System.out.println("=============================================================");
//		
//		// display the menu as long as variable displayMenu == true
//		// This is going to hold and display all the menu options until displayMneu == false
//		
//		while(displayMenu) {
//			
//			// Menu options
//			// per folder .services/UserService.java
//			
//			System.out.println("Type the number that represents your selection: ");
//			System.out.println("1. Get Reimbursements by Status"); // required WIP
//			System.out.println("2. Process Reimbursements"); // TBD required
//			//			 *     	3	Get Reimbursements by Username </li>  // fin mgr only
////			 *     <li>			4	Get Reimbursements by Author</li>   // fin mgr only
////			 *     <li>			5	Get Reimbursements by Resolver</li> // fin mgr only
//		//			 *          6	Get All Reimbursements</li>          // fin mgr only
//			System.out.println("7. Get Users by Username");			// 211231 required
//			System.out.println("8. Get Users by Email");		// TBD
//			System.out.println("9. Get All Users");             // done 211231
////			 <li>               10. Create Reimbursement</li>  //    employee
////			 *     <li>         11. Update Reimbursement</li>  // employee
//			System.out.println("12. Update User Information");  //TBD
//
//			
//			System.out.println("20. Exit: Log out the ERS Finance Manager's Menu");
//			
//			//parse user input after they choose a menu option, and put it into a 
//			// String variable
//			
//			String input = scan.nextLine();
//			
//			// Ben to add more comments here once we do DATABASE CONNECTIVITY
//			
//			switch ("M"+input) {
//	
//// ====Manager 11111111111111 ================Get Reimb by Status (required) ================			
//			case "M1": {
//				
//				System.out.println("220102wip: get(Reimbursements)ByStatus");
//				
//				System.out.println("Please select 1 PENDING 2 APPROVED 3 DENIED: ");
//				String reimbStatus = scan.nextLine();
//				switch (reimbStatus) {
//				
//				case "1": {
//					Status p = Status.PENDING;
//					List<Reimbursement> rbs = rms.getReimbursementsByStatus(p);  // reimbursementService class
//					
//					//Optional<User> oubun = us.getByUsername(username3);
//					
//					// the code did not stop printing, when username was not in DB
////					if (oubun.isPresent() != true) {
////						System.out.println("Username not found");
////					}
////					
//					if (rbs.isEmpty() == false ) {
//						for (int i = 0; i < rbs.size(); i++) {
//						Reimbursement r = rbs.get(i);
//						System.out.println(r.toString());
//						}
//					}
////					
//					if (rbs.isEmpty() == true) {
//						System.out.println("Reimbursement by Status not found");
//					}
//					
//					
//					
//					
//					
//				}
//				
//				
//				
//				}
//				
//				
//				
//				break;	
//			}
//			
//// ==== Manager ===== 222222222  ===== Process Reimbursments
//		case "M2": {
//				
//			System.out.println("2. Process Reimbursements"); // TBD required
//			
//			break;
//			}	
//			
//	// ======Manager === 333333  =====Reimb by Username ==========
////			 *     <li>			3	Get Reimbursements by Username </li>  // fin mgr only
//
//		case "M3": {
//				
//				
//				System.out.println("Please enter the username you are looking for: ");
//				String username3 = scan.nextLine();
////				
////				//List<User> userByUN = uDAO.getByUsername(username3);
//				Optional<User> oubun = us.getByUsername(username3);
//				
//				// the code did not stop printing, when username was not in DB
////				if (oubun.isPresent() != true) {
////					System.out.println("Username not found");
////				}
////				
//				if (oubun.isPresent() ) {
//					User ubun = new  User();
//					ubun = oubun.get();
//					System.out.println(ubun.toString());
//				}
////				} else {
////					System.out.println("Username not found");
////				}
//				
////				for (User u : userByUN) {
////					System.out.println(u);
////				}
////			
//				
//				break;
//				
//			}
//			
//			
//	
//			
//			
//			
//			
//			
//			
//// == Manager ==== 4 ============Reimb by Author ==============
////			 *     <li>			4	Get Reimbursements by Author</li>   // fin mgr only			
//		case "M4": {
//			
//			
//		break;	
//		}
//			
//			
//			
//			
//			
//// === Manaer === 5 ==================Reimb by Resolver ===============
////			 *     <li>			5	Get Reimbursements by Resolver</li> // fin mgr only
//		case "M5": {
//				
//			break;
//			}
//				
//				
//// == Manager == 6 =============== Review All Reimbursements =============
//		case "M6" : {
//			
//		break;	
//		}
//		
//		
//		//			 *    6	Get All Reimbursements</li>          // fin mgr only
////				//Optional<List<User>> oaUsers = us.getAllUsers();
////				// runtime check the value from DB select
////				System.out.println(oaUsers.isPresent());
////				
////					if (oaUsers.isPresent()) {
////						List<User> allUsers = oaUsers.get();
////						//User u = new User();
////						//allUsers.forEach(u) {
////							
////						//};
////						
////							for (User u : allUsers) {
////								System.out.println(u.toString());
////							}
////					} else {
////							System.out.println("All Users are not on file");
////						
////				
//				
//				
//	
//				
//				
//// === Manager 7 =====       Get User by Username (required) ===========================				
//	case "M7": {
//				System.out.println("7. Get Users by Username");			// 211231 required
//				System.out.println("211231done: Get Users by username");  // required
//				
//				//Scanner scan3 = new Scanner(System.in);
//				System.out.println("Please enter the username you are looking for: ");
//				String username3 = scan.nextLine();
////				
////				//List<User> userByUN = uDAO.getByUsername(username3);
//				Optional<User> oubun = us.getByUsername(username3);
//				
//				// the code did not stop printing, when username was not in DB
////				if (oubun.isPresent() != true) {
////					System.out.println("Username not found");
////				}
////				
//				if (oubun.isPresent() ) {
//					User ubun = new  User();
//					ubun = oubun.get();
//					System.out.println(ubun.toString());
//				}
////				
//				if (oubun.isPresent() == false) {
//					System.out.println("Username not found");
//				}
//				
////				for (User u : userByUN) {
////					System.out.println(u);
////				}
////			
////				scan3.close();  // only close scanner when exit the entire menu
//		break;
//		}
//				
//
//// ==== Manager === 88888888 ========== Get User by Email =====================			
//						
//		case "M8": {
//				System.out.println("TBD: Get Users by Email");
//				
//				System.out.println("M8. Get Users by Email");		// TBD
//			break;
//			}
//
//
//			
//			
//// === Nanager == 999999999 ======= Get All Users ========================
//					
//		case "M9": {
//				System.out.println("M9. Get All Users");             // done 211231	
//				System.out.println("211231done: Get All Users");
//				
//				Optional<List<User>> oaUsers = us.getAllUsers();
//				// runtime check the value from DB select
//				System.out.println(oaUsers.isPresent());
//				
//					if (oaUsers.isPresent()) {
//						List<User> allUsers = oaUsers.get();
//						//User u = new User();
//						//allUsers.forEach(u) {
//							
//						//};
//						
//							for (User u : allUsers) {
//								System.out.println(u.toString());
//							}
//					} else {
//							System.out.println("All Users are not on file");
//					}
//					//.displayMenu.}
//					
//				//List<User> allUsers = uDAO.getAllUser();
//				//us.getAllUsers();
//				//for (User u : allUsers) {
//				//	System.out.println(u);
//				//.displayMenu.}
//			
//				
//				break;
//			}
//
//			
//// === Manager ==== 10   10   10 ====  Create Self Reimb ==============================
////			 <li>               10. Create Reimbursement</li>  //    employee
//		case "M10": {		
//			
//
//			
//				System.out.println("M10 TBD: @code process Update User Information");
//				
//				
//				
//				break;
//			}
//			
//			
//// === Manager == 11  11   11  ======Update Self Reimb ===================
//		case "M11": {
//			
//		
////			 *     <li>         M11. Update Reimbursement</li>  // employee
//		break;	
//		}	
//			
//// == Manager == 12 12    12 ==== Update User Info =====
//		case "M12": {
//			
//		
//		System.out.println("M12. Update User Information");  //TBD
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		break;	
//		}
//			
//// == Manager == 20 20 20 ======== Manager Menu Exit =================			
//		case "M20": {
//				System.out.println("by 211231 You selected to exit");
//				displayMenu = false;
//				break;
//		}
//		default: {
//				System.out.println("Invalid selection. Please try again : '(");
//				break;
//		}
//			
//			
//			
//			
//			
//			}
//			
//			
//			
//		}
//		
//		scan.close();
//		System.out.println("You have logged out of the ERS  Finance Manager's Menu.");
//		
//		
//	}
//	
//	
//	
//}
