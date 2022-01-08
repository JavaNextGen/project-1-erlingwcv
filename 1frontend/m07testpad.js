const api = "http://localhost:3000/employee/";
// const api="https://pokeapi.co/api/v2/pokemon/";


document.getElementById("m07b1").onclick = getData;




async function getData() {

    
    let userInput = document.getElementById("m07i1").value;

    
    let response = await fetch(api+userInput); 
    

    if(response.status === 200){ 
        let data = await response.json(); 
        populateData(data); 
    } else {
        document.getElementById("data").innerHTML = "It got away!";
    }
}




function populateData(data) {

    let dataSection = document.getElementById("data"); 

    let nameTag = document.createElement("h3"); 
    nameTag.innerHTML = data.name; 

    let pokePic = document.createElement("img");
    pokePic.setAttribute("src", data.sprites.front_default);

    let pokePic2 = document.createElement("img");
    pokePic2.setAttribute("src", data.sprites.back_default);


    dataSection.appendChild(nameTag);
    dataSection.appendChild(pokePic);
    dataSection.appendChild(pokePic2);
