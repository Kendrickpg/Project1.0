window.onload = function () {
	console.log("JAVASCRIPT IS CONNECTED J");

	getCurrentUser();
	getAllTicketsById();
	document.getElementById("submitTicket").addEventListener('click', addTicket);
}

let currentDude = 1;

function getCurrentUser() {
	console.log("in Fucntion");
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function () {
		console.log("ready state: ", xhttp.readyState);



		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log("FUNCTION readyState: " + xhttp.readyState + " , Status: " + xhttp.status);
			let currentUser = JSON.parse(xhttp.responseText);

			domManip(currentUser);
			console.log(currentUser);
			currentUser = currentDude;
		}
	}


	xhttp.open('GET', 'http://localhost:9001/Project1.0/json/getCurrentUserObject');
	xhttp.send();

}

function domManip(currentUser) {
	console.log("in domManip");
	let role = null;
	if (currentUser.employeeRole == 1) {
		role = "Employee";
	} else {
		role = "Financial Manager";
	}

	document.getElementById("welcomeText").innerText = "Welcome, " + currentUser.employeeFname;
	document.getElementById("AccountId").innerText = "Account ID: " + currentUser.employeeID;
	document.getElementById("AccRole").innerText = "Role: " + role;
}



function getAllTicketsById() {
	console.log("in get all tickets by Id");
	let xhttp1 = new XMLHttpRequest();

	xhttp1.onreadystatechange = function () {
		console.log("get ready state: ", xhttp1.readyState);

		if (xhttp1.readyState == 4 && xhttp1.status == 200) {
			console.log("readyState: " + xhttp1.readyState + " , Status: " + xhttp1.status);
			let targetedList = JSON.parse(xhttp1.responseText);
			domManipList(targetedList);
			console.log(targetedList);
		}
	}

	xhttp1.open('GET', `http://localhost:9001/Project1.0/forwarding/seeAllTickets`);
	xhttp1.send();
}

function domManipList(targetedList) {

	for (let i = 0; i < targetedList.length; i++) {

		/////////creating the elements 
		let newTR = document.createElement("tr");
		let newTH = document.createElement("th");

		let newTD1 = document.createElement("td");
		let newTD2 = document.createElement("td");
		let newTD3 = document.createElement("td");
		let newTD4 = document.createElement("td");
		let newTD5 = document.createElement("td");
		let newTD6 = document.createElement("td");
		let newTD7 = document.createElement("td");
		let newTD8 = document.createElement("td");

		//populate them 
		newTH.setAttribute("scope", "row");
		let myTextH = document.createTextNode(targetedList[i].reinbursementId);
		let myTextTD1 = document.createTextNode(targetedList[i].reinbursementAmount);
		let myTextTD2 = document.createTextNode(targetedList[i].reimbursementSubmitted);
		let myTextTD3 = document.createTextNode(targetedList[i].reinbursementResloved);
		let myTextTD4 = document.createTextNode(targetedList[i].reinbursementDesc);
		let myTextTD5 = document.createTextNode(targetedList[i].reimbursementReciept);
		let myTextTD6 = document.createTextNode(targetedList[i].reinbursementAuthor);
		let myTextTD7 = document.createTextNode(targetedList[i].reinbursementStatusId);
		let myTextTD8 = document.createTextNode(targetedList[i].reinbursementTypeId);

		// append 
		newTH.appendChild(myTextH);
		newTD1.appendChild(myTextTD1);
		newTD2.appendChild(myTextTD2);
		newTD3.appendChild(myTextTD3);
		newTD4.appendChild(myTextTD4);
		newTD5.appendChild(myTextTD5);
		newTD6.appendChild(myTextTD6);
		newTD7.appendChild(myTextTD7);
		newTD8.appendChild(myTextTD8);

		newTR.appendChild(newTH);
		newTR.appendChild(newTD1);
		newTR.appendChild(newTD2);
		newTR.appendChild(newTD3);
		newTR.appendChild(newTD4);
		newTR.appendChild(newTD5);
		newTR.appendChild(newTD6);
		newTR.appendChild(newTD7);
		newTR.appendChild(newTD8);


		let newSelection = document.querySelector("#tableBody");
		newSelection.appendChild(newTR);
		console.log("domManip2");
	}


}

function addTicket() {
	console.log("Submit ticket clicked");

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function () {

		console.log("submit Ticket ready state: ", xhttp.readyState);

		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log("submit ticket is ready");
			// let recReimbInfo = JSON.parse(xhttp.responseText);
			// domManipTicket(recReimbInfo);
			// getAllTicketsById();
			console.log("passed");
		}
	}
	xhttp.open('POST', 'http://localhost:9001/Project1.0/forwarding/insertTicket');
	xhttp.setRequestHeader("content-type", "application/json");

	let typeID;

	console.log(document.querySelector('input[name="inlineRadioOptions"]:checked').value);
	switch (document.querySelector('input[name="inlineRadioOptions"]:checked').value) {

		case "Lodging": typeID = 1;
			break;

		case "Travel": typeID = 2;
			break;

		case "Food": typeID = 3;
			break;

		case "Other": typeID = 4;
			break;
	}
	let sendReimInfo = {

		"reinbursementAmount": document.getElementById("ReimbAmount").value,
		"reinbursementDesc": document.getElementById("ReimbDescrip").value,
		"reinbursementStatusId": 1,
		"reinbursementTypeId": typeID

	}
	console.log(sendReimInfo);

	xhttp.send(JSON.stringify(sendReimInfo));

}