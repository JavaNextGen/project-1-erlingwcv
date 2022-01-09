const url = "http://localhost:3000/" //putting our base URL in a variable for cleaner code below
//eventually, we'll use this in our fetch requests and make calls to our server by appending endpoints

//add eventListeners to our buttons to give them functionality
//document.getElementByID("getUserButton").addEventListener("click", getAllUsers);
document.getElementById("getButton").addEventListener("click", getUserByUsername);


//login button listener goes here

//remember, async returns a promise (which fetch request return)
async function getUserByUsername() {

    //gather the user inputs from the target inputs
    let usern = document.getElementById("targetInput").value;


     //we want to send the user/pass as JSON, so we need a JS object to send

     let userTarget = {
        ers_username: usern

     }
    //This object will reflect our DTO in Java... This is the data we want to transfer!
    console.log(userTarget)

    //fetch request to the server
    //remember the second parameter fetch can take? It's essentially for configuring our fetch request
    //fetch sends a GET by default, but this seconds parameter can change that and more!

    let response = await fetch(url+"users", {
        method: "POST", //send a POST request (would be a GET if we didn't do this...)
        body: JSON.stringify(userTarget), //turn our user object into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured (so that we can have a user session)
        //future fetches will also require this "include" value to send the cookie back


    });

    //we will send a fetch request to get our employee data
    //by default, fetch requests send GET requests
    ////let response = await fetch(url);

    //logging the response in the console just to see the response object
    console.log(response);

    //control flow for is the request is successful
    if(response.status === 200){

        let data = await response.json(); //parse the JSON data from the response into a JS object

        //logging the actual employee data that has been parsed from JSON -> JS
        console.log(data);

        //For every Employee object we got back (stored in the data variable), put it in the table
        for(let user of data){

            //create a table row for header per received ResultSet 
            let row = document.createElement("tr");

            //create a data cell for each field from ResultSet received
            let cell = document.createElement("td");
            //fill the cell with the data per appropriate ResultSet field
            cell.innerHTML = user.ers_username;
            //add the td element (data cell) to the tr element (table row)
            row.appendChild(cell);

            //we'll do this^ for every column in ResultSet received like employees

            let cell2 = document.createElement("td");
            cell2.innerHTML = user.user_email;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = user.user_role;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = user.user_last_name;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = user.user_first_name;
            row.appendChild(cell5);
            
            let cell6 = document.createElement("td");
            cell6.innerHTML = user.ers_users_id;
            row.appendChild(cell6);

             //append the tr called row that we created in the for loop to the table body
            //a new row will be appended for every employee object that comes in
            document.getElementById("targetBody").appendChild(row);
        }

    }


}

