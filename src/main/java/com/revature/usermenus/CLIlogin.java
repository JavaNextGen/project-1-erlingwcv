//package com.revature.usermenus;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import java.util.Scanner;
//
//import com.revature.models.LoginDTO;
//import com.revature.models.User;
//import com.revature.services.AuthService;
//import com.revature.util.ConnectionFactory;
//
//import io.javalin.Javalin;
//
//public class CLIlogin {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		// Testing database connectivity
//    	try (Connection conn = ConnectionFactory.getConnection()) {
//    		System.out.println("Database conneciton succesful!");
//    	} catch (SQLException e) {
//    		
//    		System.out.println("Database conneciton failed!");
//    		e.printStackTrace();
//    	}
//    	
//    	
//    	Javalin app = Javalin.create(
//				config -> {
//					config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
//				}
//		).start(3000);
//    	
//		
//		LoginDTO ldto = new LoginDTO();
//		User vduser = new User();
//		AuthService as = new AuthService();
//		
//		boolean displayMenu = true; // to toggle with the menu will continue after user input
//		Scanner scan = new Scanner(System.in);  // Scanner object to parse user input
//		
//		
//		System.out.println("Username:");
//		String cUserName = scan.nextLine();
//		System.out.println("Password:");
//		String cPassword = scan.nextLine();
//		
//		vduser = as.userLogin(ldto);
//		
//		if (vduser.equals(null)) {
//			System.out.println("User Login Failed");
//			displayMenu = false;
//		} else {
//			
//		System.out.println("Role ID: " + vduser.getUser_role_id());
//		System.out.println("User ID: " + vduser.getErs_users_id());
//		
//		displayMenu = true;
//		}
//		
//	}
//
//}
