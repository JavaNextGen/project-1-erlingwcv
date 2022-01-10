package com.revature;

//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import com.revature.models.Role;
//import com.revature.usermenus.CLImenu;
//// import com.revature.models.Menu;
//import com.revature.util.ConnectionFactory;
//
//import io.javalin.Javalin;
//
//public class Driver {
//
//    public static void main(String[] args) {
//    	
//    	Scanner sc = new Scanner(System.in);
//    	CLImenu menu = new CLImenu();
//    	
//    	// Testing database connectivity
//    	try (Connection conn = ConnectionFactory.getConnection()) {
//    		System.out.println("Database conneciton succesful!");
//    	} catch (SQLException e) {
//    		
//    		System.out.println("Database conneciton failed!");
//    		e.printStackTrace();
//    	}
//    	
//    	
////    	Javalin app = Javalin.create(
////				config -> {
////					config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
////				}
////			).start(3000);
//    	
//    	
////		//app.get("/employee", cec.getChallengeEmployeesHandler); // did not work after change
////		app.get("/employee",  cec.getChallengeEmployeesHandler);  // retyped. In fact, table not seen
////		// result: localhost:3000/employee
////		
////		// app.post("/employee", cec.insertChallengeEmployeeHandler); // did not work after modify
////		app.post("/employee",  cec.insertChallengeEmployeeHandler);  // retyped. in fact, table not seen
////		
////		// by ID
////		// app.get("/employee/{e_id}", cec.getChallengeEmployeeByIdHandler); // 211230 get by ID
////		app.get("/employee/{e_id}", cec.getChallengeEmployeeByIdHandler);
////		
////		// update -Javalin put (postman), bad practice -id included
////		// app.put("/employee",  cec.updateChallengeEmployeeHandler); // need to retype, otherwise did not work
////		app.put("/employee",  cec.updateChallengeEmployeeHandler);
////		
////		
////		// delete by ID
////		app.delete("/employee/{e_id}", cec.deleteChallengeEmployeeByIdHandler);
////		
////    	
//    	
//    	
//    	
//    	
//    	
//    	
//    	// all of the complicated menu logic is hidden in the Menu Class... power of Abstraction!!
//    	
//    }
//}


System.out.println("Welcome to ERS for all your reimbursement needs.");
//System.out.println("Are you a " + Role.FINANCE_MANAGER + " ? Enter Y for Yes, N for No");
//
//
//String feedback = sc.nextLine();
//
//
//if (feedback.compareToIgnoreCase("N") == 0) {
//	
//	menu.userMenu();
//}
//
//// use Javalin controller to direct the user per its role
//
////ChallengeEmployeesController cec = new ChallengeEmployeesController();
//
//    	
////Here is the actual functionality of our application ===================
//
//
//
//if (feedback.compareToIgnoreCase("Y") == 0) {
//
//// Use the Menu Class's displayMenu() method to give the user the menu
//menu.finMgrMenu();
//}
//
//// This is our entire main method (until we learn Javalin in Week 4)
////// 220101 copy from wk04 javalinChallenge by Charles Jester
////
//////ChallengeEmployeesController cec = new ChallengeEmployeesController();
////
////// First test connection to our database is working
//////try (Connection conn = ConnectionUtil.getConnection()){
//////	System.out.println("You did the connection thing. Good job, here's a cookie!");
//////} catch (SQLException e) {
//////	e.printStackTrace();
//////	System.out.println("OoOoOf. That Connection ain't happening, you done screwed up!");
//////}
////
////// IMPLEMENT JAVALIN HERE
////// moved to the front of the class 
////
//////Javalin app = Javalin.create(
//////		config -> {
//////			config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
//////		}
//////	).start(3000);
////