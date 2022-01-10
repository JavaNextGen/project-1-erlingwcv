package com.revature.controls;

public class EmployeeFork {
	
	//package com.revature.controllers;
	//
	//import java.io.InputStream;
	//import java.util.List;
	//import java.util.Optional;
	//
	//import com.google.gson.Gson;
	//import com.revature.models.User;
	//import com.revature.services.UserService;
	//
	//import io.javalin.http.Handler;
	//
	//public class FinMgrController {
	//	
	//	
//		UserService ms = new UserService();
	//	
//		// *****This layer is where we'll parse our JSON into Java objects and vice vera*****
//		// Sits between the Javalin Front Controller and the Service Layer
//		// We'll either be getting data from the service layer (which is our DAO)
//		// ORR sending data to the service layer (will probably return some response that it was successful)
	//	
	//	
//		public Handler getEmployeesHandler = (ctx) -> {
//			
//			if(ctx.req.getSession() != null)   {  // httpSession HttpServletRequest: if the session exists
//				
//				Optional<List<User>> oallUsers = ms.getAllUsers();
//				
//				
//				// Add the dependency into your pom.xml so it can import the Gson library
//				Gson gson = new Gson();
//				
//				// Use gson library to convert the java object to a JSON string
//				String gsonUsers = gson.toJson(oallUsers);           // Object source
//				
//				// Give a response body with a JSON string 
//				ctx.result((InputStream) oallUsers.get());
//				ctx.status(200);
//				
//				
//				
//			}
//			
//			
//			
//			
//			
//		}
	//	
	//
	//}

	
	
	

}
