let loginUrl = "http://127.0.0.1:8080/v1/utenti/utenteAutenticazione";
let getAziendaByUserIDUrl = "http://127.0.0.1:8080/v1/aziende/by_utente/";
let addSerraUrl = "http://127.0.0.1:8080/v1/serre";
let getSerraByIdAziendaUrl = "http://127.0.0.1:8080/v1/serre/";
let deleteSerraUrl = "http://127.0.0.1:8080/v1/serre/";
let getSensoreUrl = "http://127.0.0.1:8080/v1/sensori/";
let getMisuraUrl = "http://127.0.0.1:8080/v1/misure/by-sensore/";


let signIn = document.getElementById("sign-in");
let afterLogin = document.getElementsByClassName("after-login")[0];
let emailInput = document.getElementById("email-data");
let passwordInput = document.getElementById("password-data");
let serraDetails = document.getElementById("serra-tab-bis");
let serraTab = document.getElementById("serra-tab");
let addSerra = document.getElementById("btn-add-serra");
let aziendaAgricolaName = document.getElementById("azienda-name");
let aziendaAgricolaDescription = document.getElementsByClassName("description-content")[0];
let inputAddSerra = document.getElementById("input-add-greenhouse");
let serraTableTbodyRow = document.getElementById("serra-template-tbody-row");
let serraTableTbody = document.getElementById("serra-table-tbody");
let serraTableDetails = document.getElementsByClassName("serra-details");
let serraTableDelete = document.getElementsByClassName("serra-delete");


let user = null;
let azienda = null;
let listOfSerraNumber = 0;


function addRowInSerraTable(json, index) {
    const cloneSerraTableTbodyRow = serraTableTbodyRow.content.cloneNode(true);
    cloneSerraTableTbodyRow.querySelector(".row-number").textContent = index;

    if (json.hasOwnProperty("idSerra")) {
        cloneSerraTableTbodyRow.querySelector(".serra-delete").setAttribute("data-id-serra", json.idSerra);
        cloneSerraTableTbodyRow.querySelector(".serra-details").setAttribute("data-id-serra", json.idSerra);
    }
    cloneSerraTableTbodyRow.querySelector(".row-description").textContent = json.descrizione;
    serraTableTbody.appendChild(cloneSerraTableTbodyRow);
}

signIn.addEventListener("click", () => {

    let payload = {"email": emailInput.value, "password": passwordInput.value};

    let loginRequest = new Request(loginUrl,
        {
            method: "POST",
            headers: {"Content-Type": "application/json;charset=UTF-8"},
            body: JSON.stringify(payload)
        })

    fetch(loginRequest).then(response => response.json()).then(json => {
        if (json.hasOwnProperty("messages")) {
            console.log("Login error caught: " + json.messages)
            throw new Error(json.messages)
        } else {
            user = json;
            const oldText = afterLogin.textContent

            if (user.hasOwnProperty("nome")) {
                afterLogin.textContent = oldText + user.nome;
                signIn.parentElement.classList.remove("d-lg-flex");
                afterLogin.classList.remove("d-none");
            }

            if (user.hasOwnProperty("idUtente")) {
                fetch(getAziendaByUserIDUrl + user.idUtente).then(response => response.json()).then(json => {
                    azienda = json;
                    if (azienda.hasOwnProperty("nome")) {
                        aziendaAgricolaName.textContent = azienda.nome;
                    }
                    if (azienda.hasOwnProperty("descrizione")) {
                        aziendaAgricolaDescription.textContent = azienda.descrizione;
                    }

                    fetch(getSerraByIdAziendaUrl + azienda.idAziendaAgricola).then(response => response.json()).then(json => {
                        listOfSerraNumber = json.length;
                        for (const i in json) {
                            addRowInSerraTable(json[i], (parseInt(i) + 1));
                        }

                        Array.from(serraTableDelete).forEach((element) => {
                            element.addEventListener("click", (event) => {
                                const idSerra = event.target.getAttribute("data-id-serra");
                                const row = event.target.parentElement.parentElement;
                                let deleteSerraRequest = new Request((deleteSerraUrl + idSerra), {
                                    method: "DELETE",
                                    headers: {"Content-Type": "application/json;charset=UTF-8"},
                                })
                                fetch(deleteSerraRequest).then(response => response.json()).then(json => {
                                    if (json.hasOwnProperty("messages")) {
                                        console.log("Delete serra error caught: " + json.messages)
                                        throw new Error(json.messages)
                                    } else {
                                        console.log(json)
                                    }
                                })
                            })
                        })

                        Array.from(serraTableDetails).forEach((element) => {
                            element.addEventListener("click", (event) => {
                                const idSerra = event.target.getAttribute("data-id-serra");
                                const row = event.target.parentElement.parentElement;
                                let getSensoreRequest = new Request((getSensoreUrl + idSerra), {
                                    method: "GET",
                                    headers: {"Content-Type": "application/json;charset=UTF-8"}
                                })

                                fetch(getSensoreRequest).then(response => response.json()).then(json => {
                                    if (json.hasOwnProperty("messages")) {
                                        console.log("Find sensore error caught: " + json.messages)
                                        throw new Error(json.messages)
                                    } else {
                                        let sensoreArray = json;

                                    }
                                })
                            })
                        })
                    })
                })
            }
        }
    })
}, false)

serraDetails.addEventListener("click", () => {
    serraTab.click();
}, false)

addSerra.addEventListener("click", () => {

    let payload = {
        "idAziendaAgricola": azienda.idAziendaAgricola,
        "descrizione": inputAddSerra.value
    }

    let addSerraRequest = new Request(addSerraUrl,
        {
            method: "POST",
            headers: {"Content-Type": "application/json;charset=UTF-8"},
            body: JSON.stringify(payload)
        })

    fetch(addSerraRequest).then(response => response.json()).then( json => {
        if (json.hasOwnProperty("messages")) {
            console.log("Add serra error caught: " + json.messages)
            throw new Error(json.messages)
        } else {
            listOfSerraNumber += 1;
            addRowInSerraTable(json, listOfSerraNumber)
        }
    })
}, false)
