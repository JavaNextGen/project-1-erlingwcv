package com.revature.javalin;

import com.revature.models.User;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
//import com.revature.services.AuthService;
//import io.javalin.http.Handler;

public class HandleLogin {
	
	
	//package //com.revature.controllers;
	//public class AuthController {
//		AuthService as = new AuthService();
//		public Handler loginHandler = (ctx) -> {
			//what's the request body? (which we get from ctx.body) it's the data that gets sent in with a request
			//GET requests will have empty request bodies, but POST requests, which send data, will have some data.
//			String body = ctx.body(); //turn the body (data) of the POST request into a Java String
			Gson gson = new Gson(); //create a new Gson object to make Java <-> JSON conversions

//			A login request is received below:
//			LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); //turn that JSON String into a LoginDTO object
			//control flow to determine what happens in the event of successful/unsuccessful login
			//invoke the login() method of the AuthService using the username and password from the LoginDTO
//			String un2check = LDTO.ers_username;
	
				// 0. JS LoginDTO to be used to for DB search by username
				// 1. a fat user info to be pulled from DB to verify password and email
				// 2. Then, a thin user with info like userid, name and role to be passed to JS to
				// 2.1 choose the right menu for the user
				// 2.2 and greet the user with their name
//				User toJS = new User();
			
	
				
				
	//			if(as.login(LDTO.getUsername(), LDTO.getPassword())) {
				//create a user session so that they can access the applications other functionalities
//				ctx.req.getSession(); //req is a "Request Object", we establish sessions through it
				//return a successful status code
//				ctx.status(202); //202 - accepted. (but you could use any 200 level status code)

				//send a message relaying the success
				//ctx.result("Login Success!");
			//} else //{
//				ctx.status(401); //"unauthorized" status code
				//ctx.result("Login Failed! :(");
			///}
//		};
//	}

// +++++++ Registration Handler ++++++++++++++++++++++++++++++++++++++++++
			
//		public Handler regisHandler = (ctx) -> {
				//what's the request body? (which we get from ctx.body) it's the data that gets sent in with a request
				//GET requests will have empty request bodies, but POST requests, which send data, will have some data.
//				String body = ctx.body(); //turn the body (data) of the POST request into a Java String
				Gson gson = new Gson(); //create a new Gson object to make Java <-> JSON conversions

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
			
}
