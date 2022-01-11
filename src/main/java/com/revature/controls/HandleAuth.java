package com.revature.controls;

import com.revature.models.User;
import com.revature.services.AuthService;
import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import io.javalin.http.Handler;

//0. JS LoginDTO to be used to for DB search by username
// 1. a fat user info to be pulled from DB to verify password and email
// 2. Then, a thin user with info like userid, name and role to be passed to JS to
// 2.1 choose the right menu for the user
// 2.2 and greet the user with their name

	public class HandleAuth {
	//package //com.revature.controllers;  // stopped using the name after crash
	//public class AuthController {

// two separate HTTP verb actions	
// 1.1 +++++++++++ Receive username and pwd for verification
// 1.2 +++++++++++ send to frontend on results
		
			

		public Handler loginHandler = (ctx) -> {
		//public Handler loginRequestHandler = (ctx) -> {
		AuthService as = new AuthService();
			User uToJS = new User();  // per authservice's login method	
		//		what's the request body? (which we get from ctx.body) it's the data that gets sent in with a request
//		GET requests will have empty request bodies, but POST requests, which send data, will have some data.
//		//turn the body (data) of the POST request into a Java String
		String body = ctx.body();	
//		Add the dependency into your pom.xml so it can import the Gson library		
//		Use gson library to convert the java object to a JSON string
//		create a new Gson object to make Java <-> JSON conversions
		Gson inputgson = new Gson();
			
//		A login request via a LoginDTO is received below:
//			LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); //turn that JSON String into a LoginDTO object
		LoginDTO lDTO = inputgson.fromJson(body, LoginDTO.class);
		//control flow to determine what happens in the event of successful/unsuccessful login
			//invoke the login() method of the AuthService using the username and password from the LoginDTO
		uToJS = as.userLogin(lDTO);
		
		System.out.println("uToJS is " +uToJS.toString());
		
		Gson outputgson = new Gson();
		String gson2JS = outputgson.toJson(uToJS);
		//String JSONEmployeeus = gson.toJson(ouById);
//			if(as.login(LDTO.getUsername(), LDTO.getPassword())) {
//			Give a response body with a JSON string 
//			ctx.result(InputStream) oallUsers.get());	
		int roleNum = uToJS.getUser_role_id();
		String role2go = Integer.toString(uToJS.getUser_role_id());
		System.out.println("role2go is " + role2go);
		ctx.result(role2go);
		//ctx.result(gson2JS);
 		//ctx.json(uToJS);
 		//ctx.contentType("User");
		if (roleNum == 1) {
			ctx.status(201);
		} 
		
		if (roleNum == 2) {
			ctx.status(202);
		}
		
		//ctx.status(200);
		};
		
}

//// 1.2 +++++++++++ send to frontend on login results
//		public Handler loginResponseHandler = (ctx) -> {
//		AuthService as = new AuthService();
//			User uToJS = new User();  // per authservice's login method	
//		//		what's the request body? (which we get from ctx.body) it's the data that gets sent in with a request
////		GET requests will have empty request bodies, but POST requests, which send data, will have some data.
////		//turn the body (data) of the POST request into a Java String
//		String body = ctx.body();	
////		Add the dependency into your pom.xml so it can import the Gson library		
////		Use gson library to convert the java object to a JSON string
////		create a new Gson object to make Java <-> JSON conversions
//		Gson inputgson = new Gson();
//			
////		A login request via a LoginDTO is received below:
////			LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); //turn that JSON String into a LoginDTO object
//		LoginDTO lDTO = inputgson.fromJson(body, LoginDTO.class);
//		//control flow to determine what happens in the event of successful/unsuccessful login
//			//invoke the login() method of the AuthService using the username and password from the LoginDTO
//		uToJS = as.userLogin(lDTO);
//		Gson outputgson = new Gson();
//		String gson2JS = outputgson.toJson(uToJS);
//		//String JSONEmployeeus = gson.toJson(ouById);
////			if(as.login(LDTO.getUsername(), LDTO.getPassword())) {
////			Give a response body with a JSON string 
////			ctx.result(InputStream) oallUsers.get());	
//		
//		ctx.result(gson2JS);
//		ctx.status(200);
//		};
//		
//}



// +++++++ Registration Handler ++++++++++++++++++++++++++++++++++++++++++
			
//		public Handler regisHandler = (ctx) -> {
				//what's the request body? (which we get from ctx.body) it's the data that gets sent in with a request
				//GET requests will have empty request bodies, but POST requests, which send data, will have some data.
//				String body = ctx.body(); //turn the body (data) of the POST request into a Java String
//				Gson gson = new Gson(); //create a new Gson object to make Java <-> JSON conversions

//				A login request is received below:
//				LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); //turn that JSON String into a LoginDTO object
				//control flow to determine what happens in the event of successful/unsuccessful login
				//invoke the login() method of the AuthService using the username and password from the LoginDTO
//				String un2check = LDTO.ers_username;
		
					// 0. JS LoginDTO to be used to for DB search by username
					// 1. a fat user info to be pulled from DB to verify password and email
					// 2. Then, a thin user with info like userid, name and role to be passed to JS to
					// 2.1 choose the right menu for the user
					// 2.2 and greet the user with their name
//					User toJS = new User();
				
		
					
					
		//			if(as.login(LDTO.getUsername(), LDTO.getPassword())) {
					//create a user session so that they can access the applications other functionalities
//					ctx.req.getSession(); //req is a "Request Object", we establish sessions through it
					//return a successful status code
//					ctx.status(202); //202 - accepted. (but you could use any 200 level status code)

					//send a message relaying the success
					//ctx.result("Login Success!");
				//} else //{
//					ctx.status(401); //"unauthorized" status code
					//ctx.result("Login Failed! :(");
				///}
//			};
//		}
			

