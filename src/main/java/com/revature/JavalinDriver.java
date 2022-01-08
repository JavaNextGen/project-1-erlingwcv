package com.revature;
//package com.revature;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import com.revature.controllers.AuthController;
////import com.revature.controllers.EmployeeController;
////import com.revature.models.Menu;
//import com.revature.util.ConnectionFactory;
//
//import io.javalin.Javalin;
//
////public class Launcher
//public class CtxLoginDriver {
//
//	public static void main(String[] args) {
//		
//		//instantiating controller objects to use their method
//		//EmployeeController ec = new EmployeeController();
//		AuthController ac = new AuthController();
//		
//		
//		//Testing Database Connectivity - just testing whether our Connection (from ConnectionFactory) is successful
//		try(Connection conn = ConnectionFactory.getConnection()){
//			System.out.println("Connection Successful :)");
//		} catch(SQLException e) {
//			System.out.println("Connection failed");
//			e.printStackTrace();
//		}
//
//		// to get port ready for front end
//		Javalin app = Javalin.create(
//					config -> {
//						config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
//					}
//				).start(3000);
//
//
//
//		//handler ending in /login to send and inputted username/password to be validated
//		app.post("/login", ac.userLoginHandler);
//
//		
//		
//		
//		
//		
//		
//
//
//	}
//
//}








//package com.revature;
//
//public class CtxLoginDriver {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
////		import java.sql.Connection;
////		import java.sql.SQLException;
////
////		import com.revature.controller.ChallengeEmployeesController;
////		import com.revature.util.ConnectionUtil;
////
////		import io.javalin.Javalin;
////
////		public class MainDriver {
////			public static void main(String[] args) {
////				
////				ChallengeEmployeesController cec = new ChallengeEmployeesController();
////				
////				// First test connection to our database is working
////				try (Connection conn = ConnectionUtil.getConnection()){
////					System.out.println("You did the connection thing. Good job, here's a cookie!");
////				} catch (SQLException e) {
////					e.printStackTrace();
////					System.out.println("OoOoOf. That Connection ain't happening, you done screwed up!");
////				}
////				
////				// IMPLEMENT JAVALIN HERE
////				
////				
////				Javalin app = Javalin.create(
////						config -> {
////							config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
////						}
////					).start(3000);
////			
////				//app.get("/employee", cec.getChallengeEmployeesHandler); // did not work after change
////				app.get("/employee",  cec.getChallengeEmployeesHandler);  // retyped. In fact, table not seen
////				// result: localhost:3000/employee
////				
////				// app.post("/employee", cec.insertChallengeEmployeeHandler); // did not work after modify
////				app.post("/employee",  cec.insertChallengeEmployeeHandler);  // retyped. in fact, table not seen
////				
////				// by ID
////				// app.get("/employee/{e_id}", cec.getChallengeEmployeeByIdHandler); // 211230 get by ID
////				app.get("/employee/{e_id}", cec.getChallengeEmployeeByIdHandler);
////				
////				// update -Javalin put (postman), bad practice -id included
////				// app.put("/employee",  cec.updateChallengeEmployeeHandler); // need to retype, otherwise did not work
////				app.put("/employee",  cec.updateChallengeEmployeeHandler);
////				
////				
////				// delete by ID
////				app.delete("/employee/{e_id}", cec.deleteChallengeEmployeeByIdHandler);
//						
//		
//		
//		
//		
//		
//		
//	}
//
//}
