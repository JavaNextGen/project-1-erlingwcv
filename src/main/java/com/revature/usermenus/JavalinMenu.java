package com.revature.usermenus;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;	

import io.javalin.Javalin;




// Erling: 220101 It appears that Javalin caused Building errors at least 2

// Start 12/15/2021
// Hard Due date: 
//This Menu Class will have a displayMenu() method that displays the menu to the user and
	// lets them interact with the menu
	// The menu will make use of the Scanner class to take user inputs in order to travel
	// through the menu options


public class JavalinMenu {

	
////	ChallengeEmployeesController cec = new ChallengeEmployeesController();
//	
//	// First test connection to our database is working
//	try (Connection conn = ConnectionFactory.getConnection()){
//		System.out.println("You did the connection thing. Good job, here's a cookie!");
//	} catch (SQLException e) {
//		e.printStackTrace();
//		System.out.println("OoOoOf. That Connection ain't happening, you done screwed up!");
//	}
//	
//	// IMPLEMENT JAVALIN HERE
//	// moved to the front of the class 
//	
//	Javalin app = Javalin.create(
//			config -> {
//				config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
//			}
//		).start(3000);
//
//	
//	
//	
//	
//	
//	
//	// All of the menu display options and control are contained within this method
//	UserService us = new UserService(); // use its methods on menu items selected
//	UserDAO uDAO = new UserDAO();
//	
//
//	public void userMenu() {
//		
//		UserService us = new UserService();
//		boolean displayMenu = true; // to toggle with the menu will continue after user input
//		Scanner scan = new Scanner(System.in);  // Scanner object to parse user input
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
//			// ==================To be coded ===============================================================================
//			System.out.println("Type the number that represents your selection: ");
//			System.out.println("1. Create User");
//			System.out.println("2. Update User Information");
//	//		System.out.println("3. Add Reimbursement");
//	//		System.out.println("4. Update Reimbursement");
//			System.out.println("5. Get All Reimbursements by Username");
//			System.out.println("6. Exit: Log out the ERS Employee's Menu");
//			
//			//parse user input after they choose a menu option, and put it into a 
//			// String variable
//			
//			String input = scan.nextLine();
//			
//			// Ben to add more comments here once we do DATABASE CONNECTIVITY
//			
//			switch (input) {
//			
//			case "1": {
//				
//// Javalin ================== Add New User ====================================
////				// app.post("/employee", cec.insertChallengeEmployeeHandler); // did not work after modify
////				
////				app.post("/employee",  cec.insertChallengeEmployeeHandler);  // retyped. in fact, table not seen
//
//				System.out.println("220101: Create User");
//				User anewu = new User();
//				us.createUser(anewu);
//				
//				
//				break;	
//			}
//			
//			case "2": {
//				System.out.println("TBD: Update User Information");
//				break;
//			}
//			
//			case "3": {
//				System.out.println("211231done: Get Users by username");
//				
//				Scanner scan3 = new Scanner(System.in);
//				System.out.println("Please enter the username you are looking for: ");
//				String username3 = scan3.nextLine();
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
//				scan3.close();
//				break;
//			}
//			
//			case "4": {
//				System.out.println("TBD: Get Users by Email");
//			}
//			
//			case "5": {
//				System.out.println("211231done: Get All Users");
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
//			case "6": {
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
//	
//	// Finance Manager Only Menu
//	
//	public void finMgrMenu() {
//		
//		UserService us = new UserService();
//		boolean displayMenu = true; // to toggle with the menu will continue after user input
//		Scanner scan = new Scanner(System.in);  // Scanner object to parse user input
//		
//		// First, let's give the user a pretty greeting :)
//		
//		System.out.println("=============================================================");
//		System.out.println("Finance Manager, welcome to The Employee Reimbursment System (ERS)");
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
//			System.out.println("1. Get Reimbursements by Status"); //WIP
//			System.out.println("2. Update User Information");  //TBD
//			System.out.println("3. Get Users by ID");			// TBD
//			System.out.println("4. Get Users by Email");		// TBD
//			System.out.println("5. Get All Users");             // TBD
//			// 7. update user
//			System.out.println("6. Exit: Log out the ERS Finance Manager's Menu");
//			
//			//parse user input after they choose a menu option, and put it into a 
//			// String variable
//			
//			String input = scan.nextLine();
//			
//			// Ben to add more comments here once we do DATABASE CONNECTIVITY
//			
//			switch (input) {
//			
//// Javalin 7 ============ update user 
////			// by ID
////			// app.get("/employee/{e_id}", cec.getChallengeEmployeeByIdHandler); // 211230 get by ID
////			app.get("/employee/{e_id}", cec.getChallengeEmployeeByIdHandler);
////			
//// Javalin 8 ============ delete user
//			
////			// delete by ID
////			app.delete("/employee/{e_id}", cec.deleteChallengeEmployeeByIdHandler);
//
//			
//			case "1": {
//				
//				System.out.println("TBD: getReimbursementsByStatus");
//				break;	
//			}
//			
//			case "2": {
//				System.out.println("TBD: Update User Information");
//				break;
//			}
//			
//			case "3": {
//				System.out.println("211231done: Get Users by username");
//				
//				Scanner scan3 = new Scanner(System.in);
//				System.out.println("Please enter the username you are looking for: ");
//				String username3 = scan3.nextLine();
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
//				scan3.close();
//				break;
//			}
//			
//			case "4": {
//				System.out.println("TBD: Get Users by Email");
//			}
//			
//			case "5": {
//				
//// Javalin =================Get All Users=================================
//				
//				//app.get("/employee", cec.getChallengeEmployeesHandler); // did not work after change
////				app.get("/employee",  cec.getChallengeEmployeesHandler);  // retyped. In fact, table not seen
////				// result: localhost:3000/employee
//				
//				System.out.println("211231done: Get All Users");
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
//			case "6": {
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
//		System.out.println("You have logged out of the ERS  Finance Manager's Menu.");
//		
//		
//	}
//	
	
	
}

