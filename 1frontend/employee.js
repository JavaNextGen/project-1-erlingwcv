const url = "http://localhost:3000/" //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in our fetch requests and make calls to our server by appending endpoints

//add eventListeners to our buttons to give them functionality
//document.getElementById("getEmployeeButton").addEventListener("click", getEmployees);
//document.getElementById("loginButton").addEventListener("click", loginFunction);
document.getElementById("uselfUpdateButton").addEventListener("click", userSelfUpdateFunction);
document.getElementById("muusernameButton").addEventListener("click",getUbyUsername);
//document.getElementById("muusernameButton").onclick(getUbyUsername);


//remember, async returns a promise (which fetch request return)

async function userSelfUpdateFunction() {
// async function registerFunction() {  based on it in 00login.html
    //gather the user inputs from the login inputs
    let usern = document.getElementById("nusername").value;
    let userp = document.getElementById("npassword").value;
    let usere = document.getElementById("nemail").value;
    let userr = document.getElementById("sessionRole").value;
    let userf = document.getElementById("nlname").value;
    let userl = document.getElementById("nfname").value;
    
    let userid = document.getElementById("sessionUserId").value;

    //we want to send the user/pass as JSON, so we need a JS object to send
    let userSelf = {
        ers_username:usern,
        ers_password:userp,
        user_email:usere,
        user_role:userr,
        user_last_name:userl,
        user_first_name:userf,

        ers_users_id:userid
    }
    //This object will reflect our DTO in Java... This is the data we want to transfer!
 
    console.log(userSelf.JSON)
 
    //fetch request to the server
    //remember the second parameter fetch can take? It's essentially for configuring our fetch request
    //fetch sends a GET by default, but this seconds parameter can change that and more!
    let response = await fetch (url + "employee", {
 
        method: "POST", //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(userSelf), //turn our user object into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured (so that we can have a user session)
        //future fetches will also require this "include" value to send the cookie back
    });
 
    //console.log(response.status); //userful for debug :)
     //console.log(response);
     console.log(response.json());
 
    //control flow based on successful/unsuccessful login
    //if(response.status === 202) {
        if(response.status === 200) {
        // erling: open the corresponding window for use
       // window.open(url, '_blank').focus();
 //    // hardcoding a window like user menu to open
            alert("userSelfUpdate Success!");
    //window.open("finmgr.html", '_blank"').focus;
        };
        
//         if (response.status === 201){
//  window.open("employee.html", '_blank"').focus;
  
//             <!--https://www.w3schools.com/bootstrap/bootstrap_ref_css_buttons.asp-->
//         }
 
 
        //wipe our login row and welcome the user 
        //document.getElementById("loginRow").innerText="Welcome to ERS!";
        
     if (response.status > 202) {
         alert("User Self Update Failed");
        document.getElementById("loginRow").innerText="Self Update failed! Refresh the page";
    }
 
 
 
 }
 

function getUbyUsername() {

   // window.open("mu11getbyusername.html");
   window.open("/Users/erlingwang/Documents/revature2/benMavenProj/project-1-erlingwcv/1frontend/mu11getbyusername.html", '_blank"').focus;
}
async function getEmployees() {

    //we will send a fetch request to get our employee data
    //by default, fetch requests send GET requests
    let response = await fetch(url + "employee");

    //logging the response in the console just to see the response object
    console.log(response);

    //control flow for is the request is successful
    if(response.status === 200){

        let data = await response.json(); //parse the JSON data from the response into a JS object

        //logging the actual employee data that has been parsed from JSON -> JS
        console.log(data);

        //For every Employee object we got back (stored in the data variable), put it in the table
        for(let employee of data){

            //create a table row
            let row = document.createElement("tr");

            //create a data cell for each employee field
            let cell = document.createElement("td");
            //fill the cell with the appropriate employee data
            cell.innerHTML = employee.employee_id;
            //add the td element (data cell) to the tr element (table row)
            row.appendChild(cell);

            //we'll do this^ for every column in employees

            let cell2 = document.createElement("td");
            cell2.innerHTML = employee.f_name;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = employee.l_name;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = employee.role_id;
            row.appendChild(cell4);

            //append the tr called row that we created in the for loop to the table body
            //a new row will be appended for every employee object that comes in
            document.getElementById("employeeBody").appendChild(row);
        }

    }


}

//this function will send the user-inputted login credentials to our server
async function loginFunction() {

    //gather the user inputs from the login inputs
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    //we want to send the user/pass as JSON, so we need a JS object to send
    let user = {
        username:usern,
        password:userp
    }
    //This object will reflect our DTO in Java... This is the data we want to transfer!

    console.log(user)

    //fetch request to the server
    //remember the second parameter fetch can take? It's essentially for configuring our fetch request
    //fetch sends a GET by default, but this seconds parameter can change that and more!
    let response = await fetch (url + "login", {

        method: "POST", //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(user), //turn our user object into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured (so that we can have a user session)
        //future fetches will also require this "include" value to send the cookie back
    });

    console.log(response.status); //userful for debug :)

    //control flow based on successful/unsuccessful login
    if(response.status === 202) {
        //wipe our login row and welcome the user 
        document.getElementById("loginRow").innerText="Welcome!";
    } else {
        document.getElementById("loginRow").innerText="Login failed! Refresh the page";
    }


}

