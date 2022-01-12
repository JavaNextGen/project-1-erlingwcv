//package com.revature.controls;
//
//import com.revature.models.User;
//import com.revature.services.AuthService;
//import com.google.gson.Gson;
//import com.revature.models.LoginDTO;
//import io.javalin.http.Handler;

//0. JS LoginDTO to be used to for DB search by username
// 1. a fat user info to be pulled from DB to verify password and email
// 2. Then, a thin user with info like userid, name and role to be passed to JS to
// 2.1 choose the right menu for the user
// 2.2 and greet the user with their name

//	public class HandleAuth {
	//package //com.revature.controllers;  // stopped using the name after crash
	//public class AuthController {

// Three steps and two separate HTTP verbs within each of login/register methods:
// 1. +++++++++++ Receive via POST to receive from front end
//		1.1 username and pwd for login verification, or
// 		1.2 user info (except for ers_users_id) for verification
// 1.2 +++++++++++ verification actions
// 1.3 ++++++++++ send selective data via POST to frontend
		
// ++1 of 2 methods++++++++++ User Login Handler ++++++++++++++++++++++++++++++++++++++			
//		public Handler loginHandler = (ctx) -> {
//		//public Handler loginRequestHandler = (ctx) -> {
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
//		
//		System.out.println("uToJS is " +uToJS.toString());
//
//		//create a new gson to sendback to frontend				
//		Gson outputgson = new Gson();
//		String gson2JS = outputgson.toJson(uToJS);
//		//String JSONEmployeeus = gson.toJson(ouById);
////			if(as.login(LDTO.getUsername(), LDTO.getPassword())) {
////			Give a response body with a JSON string 
////			ctx.result(InputStream) oallUsers.get());	
//		int roleNum = uToJS.getUser_role_id();
//		String role2go = Integer.toString(uToJS.getUser_role_id());
//		System.out.println("role2go is " + role2go);
//		ctx.result(role2go);   // dont know  how to pull info out at the frontend ???????????????
//		//ctx.result(gson2JS);
// 		//ctx.json(uToJS);
// 		//ctx.contentType("User");
//		if (roleNum == 1) {
//			ctx.status(201);
//		} 
//		
//		if (roleNum == 2) {
//			ctx.status(202);
//		}
//		
//		//ctx.status(200);
//		};
//		
//}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//// ++2 of 2 methods +++++ Registration Handler +++++++++++++220111+++++++++++++++++++++++++++++
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		
//		public Handler regisHandler = (ctx) -> {
////		//public Handler loginRequestHandler = (ctx) -> {
//		User user1 = new User();  // from client input
//		User user2 = new User();     // user2 to feed into auth svc        
//		User user3 = new User();   // received from auth svc (verification) with selective info for JS frontend
//		int user3userroleid; // info sent to JS front end (available from Step 2, to show next menu)
//		int user3ersusersid; // info sent to JS front end (available from Step 3, to show user identity)
		
//      +++++++ Step 1 to make User1++++ 	make User1 out of user web input (Client) 	
//		//what's the request body? (which we get from ctx.body) it's the data that gets sent in with a request
//		//GET requests will have empty request bodies, but POST requests, which send data, will have some data.
//		//turn the body (data) of the POST request into a Java String
//		String body = ctx.body();	
//		//Add the dependency into your pom.xml so it can import the Gson library		
//		//Use gson library to convert the java object to a JSON string
//		//create a new Gson object to make Java <-> JSON conversions
//		Gson user1gson = new Gson();
//		User user1 = user1gson.fromJson(body, User.class);
//		System.out.println("Registration User1 is " +User1.toString());
//		username = user1.get;
//		userpasword = user1.get;
//		useremail = user1.get;
//		userrole = user1.get;
//		userlname = user1.get;
//		userfname = user1.get;
		
//		
//		//+++++++++Step 2 to make User2+++++for UserDAO+++++++++++++ Replace Role with user_role_id, into UserDAO format
//		//to make User2 ready for authsvc register method
//		Role user1Role = user1.getRole;
//		call usersvc int userRoleStringToId(String role) method to convert it into role id
//		userrolid = user4userroleid 
//		
//		user2.set username
//		user2.set userpasword
//		user2.set useremail
//		user2.set userroleid
//		user2.set userlname
//		user2.set userfname 
//		
//		//		System.out.println("Registration User2 is " +User2.toString());
		
//      ++++++++++Step 3 to make User3+++++++and send it to JS+++++++++++++++++++++++++++++++++++++		
//		+++++++++ ++++ 3.1 call svc user regis method on User2, to collect DB insert verifications and status		
//   	//		//control flow to determine what happens in the event of successful/unsuccessful verification
//		//invoke register() method of the AuthService using the input from User2
//		// as.regiser() method is doing various verifications, DB insert verifications and insert status report
//		User3 = as.register(user2);
//				
//		System.out.println("Registration User3 is " +User3.toString());
//		
//      ++++++++ ++++ 3.2 to pack User3 into JSON for front end +++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 		
//		//create a new gson for some info to send back to frontend				
//		Gson user3gson = new Gson();
//		String user3JS = outputgson.toJson(user3);
//		////String JSONEmployeeus = gson.toJson(ouById);
//		////if(as.login(LDTO.getUsername(), LDTO.getPassword())) {
//		////Give a response body with a JSON string 
//		////ctx.result(InputStream) oallUsers.get());	
// 		int user3userroleid
//		String roleMenu = Integer.toString(user3userroleid);
//		System.out.println("roleMenu is " + roleMenu);
//		ctx.result(user3.json());  // dont know  how to pull info out at the frontend ???????????????
//		//ctx.result(gson2JS); not working
// 		//ctx.json(uToJS);  not working
// 		//ctx.contentType("User"); not working
//		// It appears that "status" is the only reliable vehicle to pass Role info to frontend
//		if (user3userroleid == 1) {
//			ctx.status(201);
//		} 
//		
//		if (user3userroleid == 2) {
//			ctx.status(202);
//		}
//		
//		//ctx.status(200);
//		};
//		
//}
		
			
//-------------------------------------------------------------
//     Below is a playground to be disregarded
// -----------------------------------------------------------
		
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
			

