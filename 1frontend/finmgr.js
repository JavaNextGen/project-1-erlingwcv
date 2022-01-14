const url = "http://localhost:3000/" //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in our fetch requests and make calls to our server by appending endpoints

//add eventListeners to our buttons to give them functionality
//document.getElementById("getEmployeeButton").addEventListener("click", getEmployees);
//document.getElementById("loginButton").addEventListener("click", loginFunction);
document.getElementById("uusernameButton").addEventListener("click",ugetUbyUsername);
//document.getElementById("muusernameButton").onclick(getUbyUsername);


//remember, async returns a promise (which fetch request return)

async function ugetUbyUsername() {

    //gather the user inputs from the login inputs
    let usern = document.getElementById("username").value;
    //let userp = document.getElementById("password").value;

    //we want to send the user/pass as JSON, so we need a JS object to send
    let User = {
        username:usern
        //username:usern,
        //password:userp
    }
    // This object will reflect our DTO in Java... This is the data we want to transfer!

    //console.log(user);

    //fetch request to the server
    //remember the second parameter fetch can take? It's essentially for configuring our fetch request
    //fetch sends a GET by default, but this seconds parameter can change that and more!
    let response = await fetch (url + "finmgr/userbyusername", {

        method: "POST", //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(User),
        // body: JSON.stringify(user), //turn our user object into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured (so that we can have a user session)
        //future fetches will also require this "include" value to send the cookie back
    });
    let data = response.json;
   
    console.log(response.body);
    console.log(response.status); //userful for debug :)

   

    //for(let user of response){

        //create a table row
        let row = document.createElement("tr");

        //create a data cell for each employee field
        let cell = document.createElement("td");
        //fill the cell with the appropriate employee data
        cell.innerHTML = data.ers_username;
        // cell.innerHTML = response.ers_username;
        //add the td element (data cell) to the tr element (table row)
        row.appendChild(cell);

        let cell2 = document.createElement("td");
        cell2.innerHTML = data.user_email;
        // cell2.innerHTML = response.user_email;
        row.appendChild(cell2);
        
        //we'll do this^ for every column in employees

        let cell3 = document.createElement("td");
        cell3.innerHTML = data.user_role;
        // cell3.innerHTML = response.user_role;
        row.appendChild(cell3);

        let cell4 = document.createElement("td");
        cell4.innerHTML = data.user_last_name;
        // cell4.innerHTML = response.user_last_name;
        row.appendChild(cell4);

        
        let cell5 = document.createElement("td");
        cell5.innerHTML = data.user_first_name;
        // cell5.innerHTML = user.user_first_name;
        row.appendChild(cell5);

        //append the tr called row that we created in the for loop to the table body
        //a new row will be appended for every employee object that comes in
        document.getElementById("muserBody").appendChild(row);
    //}
    //control flow based on successful/unsuccessful login
    if(response.status === 200) {   // 202 in example
        //wipe our login row and welcome the user 
        // document.getElementById("loginRow").innerText="Welcome!";
        document.getElementById("actionResult").innerText="Success -User By Username Search!";
        alert("Success -User By Username Search!");

    } else {
        // document.getElementById("loginRow").innerText="Login failed! Refresh the page";

        document.getElementById("actionResult").innerText="UUser By sername Search failed!";
        alert("UUser By sername Search failed!");
    }

}

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


//}


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
        //body: JSON.stringify(user), //turn our user object into JSON
        body: JSON.stringify(userNRole), //turn our user object into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured (so that we can have a user session)
        //future fetches will also require this "include" value to send the cookie back
    });

    console.log(response.status); //userful for debug :)

    //control flow based on successful/unsuccessful login
    if(response.status === 200) {   // 202 in example
        //wipe our login row and welcome the user 
        // document.getElementById("loginRow").innerText="Welcome!";
        document.getElementById("actionResult").innerText="Success -User By Username Search!";
        alert("Success -User By Username Search!");

    } else {
        // document.getElementById("loginRow").innerText="Login failed! Refresh the page";

        document.getElementById("actionResult").innerText="UUser By sername Search failed!";
        alert("UUser By sername Search failed!");
    }


}

