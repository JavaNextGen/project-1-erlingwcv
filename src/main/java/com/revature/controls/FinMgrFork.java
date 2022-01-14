package com.revature.controls;

//package com.revature.websvc;
//
//import com.revature.results.FMuserViews;
//import java.util.List;
import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.models.UserNRole;
import com.revature.services.UserService;
import io.javalin.http.Handler;

//package com.revature.controllers;
	//
	//import java.util.List;
import java.util.Optional;
	//
	//import com.google.gson.Gson;
	//import com.revature.models.User;
	////import com.revature.services.ChallengeEmployeeServices;
	//import com.revature.services.UserService;
	//
	//import io.javalin.http.Handler;
	//
	//public class FinMgrController {
	//
//
public class FinMgrFork {
	
		
		UserService us = new UserService();
			//FMuserViews fmu = new FMuserViews();
						
		////TODO: CREATE A CONTROLLER FOR JAVALIN FOR EACH OF THE SERVICES REQUESTEDD
	
			// *****This layer is where we'll parse our JSON into Java objects and vice vera*****
			// Sits between the Javalin Front Controller and the Service Layer
			// We'll either be getting data from the service layer (which is our DAO)
			// OR sending data to the service layer (will probably return some response that it was successful)
	
// ==== M get User by Username ==========
// +++++Manager ++Ctx ++User Info Presentation +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			// get user by username
			// get username via Javalin
			//public Handler getChallengeEmployeeByIdHandler = (ctx) -> {
		public Handler uGetByUsernameHandler = (ctx) -> {
				
				if(ctx.req.getSession() != null) { //if the session exist
					// Phase  1: send username info to UserService
					String body = ctx.body();
					System.out.println("body is "+body);
					//int e_id = Integer.parseInt(ctx.pathParam(body));
					 //int e_id = Integer.parseInt(ctx.pathParam("e_id"));
					//Optional obody = Optional.ofNullable(body);
					//ChallengeEmployee employeeById = ces.getChallengeEmployeeById(e_id);						
					// Add the dependency into your pom.xml so it can import the Gson library
					Gson inputgson = new Gson();
					User user1 = inputgson.fromJson(body, User.class); //turn that JSON String into a LoginDTO object
					String user1string = user1.toString();
					//System.out.println("uGetByUsername user1 from web "+user1string);
					////LoginDTO lDTO = inputgson.fromJson(body, LoginDTO.class);
					////control flow to determine what happens in the event of successful/unsuccessful login
					////invoke the login() method of the AuthService using the username and password from the LoginDTO
					String username = user1.getUsername();
					//System.out.println("username from body is "+username);
					
					// Stage 2: send output to Ctx
					Optional<UserNRole> ounr2 = us.getByUsername(username);
					////System.out.println("uToJS is " +uToJS.toString());
					//login2 = asl.userLogin(lDTO);
					//System.out.println("login user2 is " +user2.toString());
					UserNRole unr2 = ounr2.get();
					String ctxUname = unr2.getErs_username();
					String ctxUemail = unr2.getUser_email();
					String ctxUrole = unr2.getUser_role();
					String ctxUlname = unr2.getUser_last_name();
					String ctxUfname = unr2.getUser_first_name();
							
					System.out.println("ubyUsername to Ctx "+ ctxUname);
					System.out.println("ubyUseremail to Ctx "+ ctxUemail);
					System.out.println("ubyUserRole to Ctx "+ ctxUrole);
					System.out.println("ubyUserLname to Ctx "+ ctxUlname);
					System.out.println("ubyUserFname to Ctx "+ ctxUfname);
					
					
					Gson outputgson = new Gson();
					// Use gson library to convert the java object to a JSON string
					//String JSONEmployeeus = gson.toJson(ouById);
					//String JSONuById = gson.toJson(ouById.get());
					//String JSONoutput =outputgson.toJson(unr2.toString()); // did  not work 220114
					String JSONoutput =outputgson.toJson(unr2);
					// Give a response body with a JSON string 
					//ctx.result(JSONEmployees);
					ctx.result(JSONoutput);
					ctx.status(200);
					
					System.out.println("ctx.result "+JSONoutput);
				} else {
				//	ctx.result("Oh no you failed to get the user!!!!");
					ctx.result("User By Username search failed.");
					ctx.status(404);
				}
			};
}

			
			
			
			
			
//			======================================================================================		
//			//public Handler getChallengeEmployeesHandler = (ctx) -> {
//			public Handler getAllUsersHandler = (ctx) -> {	
//				if(ctx.req.getSession() != null) { //if the session exist
//					
//					Optional<List<User>> oallUsers = us.getAllUsers();
//					System.out.println("Get All User Handler");
//					
//					List<User> allUsers = oallUsers.get();
//					System.out.println(allUsers);
//					// Add the dependency into your pom.xml so it can import the Gson library
//					Gson gson = new Gson();
//					
//					// Use gson library to convert the java object to a JSON string
//					String JSONusers = gson.toJson(allUsers);
//					
//					// Give a response body with a JSON string 
//					ctx.result(JSONusers);
//					ctx.status(200);
//					
	//
//				} else {
//					ctx.result("Oh no you failed to get the users!!!!");
//					ctx.status(404);
//				}
//			};
////	====================================================================		
////			// Add 
////			
////			public Handler insertChallengeEmployeeHandler = (ctx) -> {
////				
////				if(ctx.req.getSession() != null) {
////					String body = ctx.body();
////					
////					Gson gson = new Gson();
////					
////					ChallengeEmployee employee = gson.fromJson(body, ChallengeEmployee.class);
////					
////									
////					ces.createChallengeEmployee(employee);
////					
////					ctx.result("Employee was successfully added!");
////					ctx.status(201);
////					
////				} else {
////					ctx.result("Oh no you failed to insert an employee!!!!");
////					ctx.status(404);
////				}
////				
////				
////			};
//	===========================================================================================		
//			// get user by username
//			// get by ID via Javalin
//			//public Handler getChallengeEmployeeByIdHandler = (ctx) -> {
//			public Handler getByUsernameHandler = (ctx) -> {
//				
//				if(ctx.req.getSession() != null) { //if the session exist
//					
//					String body = ctx.body();
//					//int e_id = Integer.parseInt(ctx.pathParam(body));
//					 //int e_id = Integer.parseInt(ctx.pathParam("e_id"));
//				
//					
//					//Optional obody = Optional.ofNullable(body);
//									
//					//ChallengeEmployee employeeById = ces.getChallengeEmployeeById(e_id);	
//					Optional<User> ouById = us.getByUsername(body);	
//					
//					
//					// Add the dependency into your pom.xml so it can import the Gson library
//					Gson gson = new Gson();
//					
//					
//					// Use gson library to convert the java object to a JSON string
//					//String JSONEmployeeus = gson.toJson(ouById);
//					String JSONuById = gson.toJson(ouById.get());
//									
//					// Give a response body with a JSON string 
//					//ctx.result(JSONEmployees);
//					ctx.result(JSONuById);
//					ctx.status(200);
//					
	//
//				} else {
//					ctx.result("Oh no you failed to get the user!!!!");
//					ctx.status(404);
//				}
//			};
	//
	//
//	===========================================================================================		
////			// update (put)
////			
////					public Handler updateChallengeEmployeeHandler = (ctx) -> {
////						
////						if(ctx.req.getSession() != null) {
////							String body = ctx.body();
////							
////							Gson gson = new Gson();
////							
////							ChallengeEmployee employee = gson.fromJson(body, ChallengeEmployee.class);
////							
////											
////							ces.updateChallengeEmployee(employee);
////							
////							ctx.result("Employee was successfully updated!");
////							ctx.status(201);
////							
////						} else {
////							ctx.result("Oh no you failed to update an employee!!!!");
////							ctx.status(404);
////						}
////			
	////
////					};
	////======================================================================================
////			// delete by ID
////					
////					public Handler deleteChallengeEmployeeByIdHandler = (ctx) -> {
////						if(ctx.req.getSession() != null) { //if the session exist
////							
////							//String body = ctx.body();
////							//int e_id = Integer.parseInt(ctx.pathParam(body));
////							 int e_id = Integer.parseInt(ctx.pathParam("e_id"));
////							
////											
////							//ChallengeEmployee employeeById = ces.deleteChallengeEmployee(e_id);	
////							boolean employeeByIDgone = ces.deleteChallengeEmployee(e_id);
////							
////							// Add the dependency into your pom.xml so it can import the Gson library
////							Gson gson = new Gson();
////							
////							
////							// Use gson library to convert the java object to a JSON string
////							String JSONEmployees = gson.toJson(employeeByIDgone);
////							
////							
////											
////							// Give a response body with a JSON string 
////							ctx.result(JSONEmployees);
////							ctx.status(200);
////							
	////
////						} else {
////							ctx.result("Oh no you failed to get the employees!!!!");
////							ctx.status(404);
////						}
////					};
	//	
//					
//					
//					
	//}
	//

	
	
	
	

//}
