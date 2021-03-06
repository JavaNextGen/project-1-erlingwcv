const url = "http://localhost:3000/" //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in our fetch requests and make calls to our server by appending endpoints


// Erling keep user role id and user id ++++++++++++++++++++++++++
// Javascript in Page 1:

// var favoritemovie = "Shrek";
// sessionStorage.setItem("favoriteMovie", favoritemovie);

// Javascript in Page 2:

// var favoritemovie = sessionStorage.getItem("favoriteMovie");
// console.log(favoritemovie);
// https://lage.us/Javascript-Pass-Variables-to-Another-Page.html


//add eventListeners to our buttons to give them functionality
document.getElementById("regisButton").addEventListener("click", registerFunction);
document.getElementById("loginButton").addEventListener("click", loginFunction);

async function registerFunction() {
   //gather the user inputs from the login inputs
   let usern = document.getElementById("nusername").value;
   let userp = document.getElementById("npassword").value;
   let usere = document.getElementById("nemail").value;
   let userr = document.getElementById("nrole").value;
   let userf = document.getElementById("nlname").value;
   let userl = document.getElementById("nfname").value;

   //we want to send the user/pass as JSON, so we need a JS object to send
   let userRegis = {
       ers_username:usern,
       ers_password:userp,
       user_email:usere,
       user_role:userr,
       user_last_name:userl,
       user_first_name:userf
   }
   //This object will reflect our DTO in Java... This is the data we want to transfer!

   console.log(userRegis)

   //fetch request to the server
   //remember the second parameter fetch can take? It's essentially for configuring our fetch request
   //fetch sends a GET by default, but this seconds parameter can change that and more!
   let response = await fetch (url + "regis", {

       method: "POST", //send a POST request (would be a GET if we didn't do this...)
       body: JSON.stringify(userRegis), //turn our user object into JSON
       credentials: "include"
       //this last line will ensure that the cookie is captured (so that we can have a user session)
       //future fetches will also require this "include" value to send the cookie back
   });

   //console.log(response.status); //userful for debug :)
    //console.log(response);
    console.log(response.json());

   //control flow based on successful/unsuccessful login
   //if(response.status === 202) {
       if(response.status === 202) {
       // erling: open the corresponding window for use
      // window.open(url, '_blank').focus();
//    // hardcoding a window like user menu to open
   window.open("finmgr.html", '_blank"').focus;
       };
       
       if (response.status === 201){
window.open("employee.html", '_blank"').focus;
 
           <!--https://www.w3schools.com/bootstrap/bootstrap_ref_css_buttons.asp-->
       }


       //wipe our login row and welcome the user 
       //document.getElementById("loginRow").innerText="Welcome to ERS!";
       
    if (response.status > 202) {
       document.getElementById("loginRow").innerText="Registration failed! Refresh the page";
   }



}

//remember, async returns a promise (which fetch request return)
// async function getEmployees() {

//     //we will send a fetch request to get our employee data
//     //by default, fetch requests send GET requests
//     let response = await fetch(url + "employee");

//     //logging the response in the console just to see the response object
//     console.log(response);

//     //control flow for is the request is successful
//     if(response.status === 200){

//         let data = await response.json(); //parse the JSON data from the response into a JS object

//         //logging the actual employee data that has been parsed from JSON -> JS
//         console.log(data);

//         //For every Employee object we got back (stored in the data variable), put it in the table
//         for(let employee of data){

//             //create a table row
//             let row = document.createElement("tr");

//             //create a data cell for each employee field
//             let cell = document.createElement("td");
//             //fill the cell with the appropriate employee data
//             cell.innerHTML = employee.employee_id;
//             //add the td element (data cell) to the tr element (table row)
//             row.appendChild(cell);

//             //we'll do this^ for every column in employees

//             let cell2 = document.createElement("td");
//             cell2.innerHTML = employee.f_name;
//             row.appendChild(cell2);

//             let cell3 = document.createElement("td");
//             cell3.innerHTML = employee.l_name;
//             row.appendChild(cell3);

//             let cell4 = document.createElement("td");
//             cell4.innerHTML = employee.role_id;
//             row.appendChild(cell4);

//             //append the tr called row that we created in the for loop to the table body
//             //a new row will be appended for every employee object that comes in
//             document.getElementById("employeeBody").appendChild(row);
//         }

//     }


// }

//this function will send the user-inputted login credentials to our server
async function loginFunction() {
    //gather the user inputs from the login inputs
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    //we want to send the user/pass as JSON, so we need a JS object to send
    let userLogin = {
        ers_username:usern,
        ers_password:userp
    }
    //This object will reflect our DTO in Java... This is the data we want to transfer!

    //console.log(userLogin)

    //fetch request to the server
    //remember the second parameter fetch can take? It's essentially for configuring our fetch request
    //fetch sends a GET by default, but this seconds parameter can change that and more!
    let response = await fetch (url + "login", {

        method: "POST", //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(userLogin), //turn our user object into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured (so that we can have a user session)
        //future fetches will also require this "include" value to send the cookie back
        // headers :{
        //     'Content-type':'User/json'
        // }
        // return response.json();
    });

    //console.log(response.status); //userful for debug :)
    

    //return response.json();
    console.log(response.json());
    //response as shonw in console: Promise { <state>: "fulfilled", <value>: 2 }
    //console.log(response.status);
    //control flow based on successful/unsuccessful login
    //if(response.status === 202) {
    //console.log(response.json());
    //console.log(JSON.stringify(response).value);
    //let User =response.json().value ;
    //const User = response.json(); //Uncaught (in promise) TypeError: Response.json: Body has already been consumed
    if (response.status === 202 ) {      // number no need quotes to wrap
       // console.log(response.statusText); // not working
        console.log(response.status);

        //let found = response.find(value => Promise); // find is not a function
       // console.log(found);
      //  console.log(Promise.value); // not working
        //let id = response.jason(Promise.value); // not working
       // console.log(id);  // not working
      //  console.log(data.value);  // not working
   // window.open("finmgr.html", '_blank"').focus;
    //  document.location("finmgr.html")
        // window.open()
        //window.location.href="finmgr.html"; // 220111 per Tyler
        window.open("finmgr.html");  // do not put directory

        //if (User === "2") {
    //    console.log(User);
   //if (response.json().value === 2 ) {
    //console.log(User.value);
    // if(response.value === "2" ) {
    //if(response === "2" ) {
        // erling: open the corresponding window for use
       // window.open(url, '_blank').focus();
 //    // hardcoding a window like user menu to open
   

        } 
        
        if (response.status === 201) {
            console.log(response.status);
           // console.log(response.jason()); // not working
         //  let id = response.jason().Promise.value; // not working
      //   let id = response.jason(Promise.value); //
      ///  console.log(id);  //
       //     console.log(data.value);
            //console.log(response.statusText); // not working

        // if (User === "1") {
        //    console.log(User);
        // if (User.value === 1 ) {
       // if(response.value === "1" ) {
      //  if (response === "1"){
  //      if (response.User.user_role_id === 1){
 //window.open("employee.html", '_blank"').focus;
     //     document.open("employee.html")
      //      window.location.href = "employee.html";
      //window.location.href="employee.html"; // 220111 per Tyler
      //window.open("employee.html");  // do not put directory
            window.open("employee.html");
       
            <!--https://www.w3schools.com/bootstrap/bootstrap_ref_css_buttons.asp-->
        }


        //wipe our login row and welcome the user 
        //document.getElementById("loginRow").innerText="Welcome to ERS!";
       
        if (response.status > 202) {
            console.log(response.status);
            //console.log(response.statusText); // not workiing
            //console.log(Promise.value); // not working
        //    console.log(response.value); // not working
          //  console.log(response.jason()); // not working
          //let id = response.jason().Promise.value; // not working
     //     let id = response.jason(Promise.value);
      //  console.log(id);
       //     console.log(data.value);
      //  if (User === "0") {
      //      console.log(User);
        //if (User.value === 0 ) {
        //if(response.value === "0" ) {
        // if (response === "0") {
        // window.open("/Users/erlingwang/Documents/revature2/benMavenProj/project-1-erlingwcv/1frontend/00finmgr.html", '_blank"').focus;
       
        
        document.getElementById("loginRow").innerText="Login failed! Refresh the page";
    }


}

