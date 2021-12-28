package com.revature.models;

import com.revature.repositories.UserDAO;
import com.revature.services.UserService;

import java.util.List;
import java.util.Scanner;	


// Start 12/15/2021
// Soft Due date:
// Hard Due date: 
//This Menu Class will have a displayMenu() method that displays the menu to the user and
	// lets them interact with the menu
	// The menu will make use of the Scanner class to take user inputs in order to travel
	// through the menu options


public class Menu {

	// All of the menu display options and control are contained within this method
	UserService us = new UserService(); // use its methods on menu items selected
	UserDAO uDAO = new UserDAO();
	
	
	public void finMgrMenu() {
		
		boolean displayMenu = true; // to toggle with the menu will continue after user input
		Scanner scan = new Scanner(System.in);  // Scanner object to parse user input
		
		// First, let's give the user a pretty greeting :)
		
		System.out.println("=============================================================");
		System.out.println("Finance Manager, welcome to The Employee Reimbursment System (ERS)");
		System.out.println("=============================================================");
		
		// display the menu as long as variable displayMenu == true
		// This is going to hold and display all the menu options until displayMneu == false
		
		while(displayMenu) {
			
			// Menu options
			// per folder .services/UserService.java
			
			System.out.println("Type the number that represents your selection: ");
			System.out.println("1. Create User");
			System.out.println("2. Update User Information");
			System.out.println("3. Get Users by ID");
			System.out.println("4. Get Users by Email");
			System.out.println("5. Get All Users");
			System.out.println("6. Exit: Log out the ERS Finance Manager's Menu");
			
			//parse user input after they choose a menu option, and put it into a 
			// String variable
			
			String input = scan.nextLine();
			
			// Ben to add more comments here once we do DATABASE CONNECTIVITY
			
			switch (input) {
			
			case "1": {
				
				System.out.println("Create User");
				break;	
			}
			
			case "2": {
				System.out.println("TBD: Update User Information");
				break;
			}
			
			case "3": {
				System.out.println("TBD: Get Users by ID");
				
				Scanner scan3 = new Scanner(System.in);
				System.out.println("Please enter the username you are looking for: ");
				String username3 = scan.nextLine();
//				
//				//List<User> userByUN = uDAO.getByUsername(username3);
//				
//				for (User u : userByUN) {
//					System.out.println(e);
//				}
//			
				
				break;
			}
			
			case "4": {
				System.out.println("TTBD: Get Users by Email");
			}
			
			case "5": {
				System.out.println("TBD: Get All Users");
				//List<User> allUsers = uDAO.getAllUser();
				us.getAllUsers();
				//for (User u : allUsers) {
				//	System.out.println(u);
				//.displayMenu.}
			
				
				break;
			}
			
			case "6": {
				displayMenu = false;
				break;
			}
			default: {
				System.out.println("Invalid selection. Please try again : '(");
				break;
			}
			
			
			
			}
			
			
			
		}
		
		scan.close();
		System.out.println("You have logged out of the ERS  Finance Manager's Menu.");
		
		
	}
	
	
	
}
