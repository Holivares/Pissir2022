let loginUrl = "http://127.0.0.1:8080/v1/utenti/utenteAutenticazione";
let getAziendaByUserIDUrl = "http://127.0.0.1:8080/v1/aziende/by_utente/";
let addSerraUrl = "http://127.0.0.1:8080/v1/serre";
let getSerraByIdAziendaUrl = "http://127.0.0.1:8080/v1/serre/";
let deleteSerraUrl = "http://127.0.0.1:8080/v1/serre/";
let getSensoreUrl = "http://127.0.0.1:8080/v1/sensori/";
let getMisuraUrl = "http://127.0.0.1:8080/v1/misure/by-sensore/";
let getAttuatoriByIdSerra = "http://127.0.0.1:8080/v1/attuatori/";
let changeAttuatoreToAutomatiqueModeUrl = "http://127.0.0.1:8080/v1/attuatori/automatique_mode/";
let changeAttuatoreToManualModeUrl = "http://127.0.0.1:8080/v1/attuatori/manuel_mode/";
let changeAttuatoreToEnableStatusUrl = "http://127.0.0.1:8080/v1/attuatori/enable/";
let changeAttuatoreToDisableStatusUrl = "http://127.0.0.1:8080/v1/attuatori/disable/";


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
let detailsSerraTableTbody = document.getElementById("serra-details-table");
let descriptionPlanning = document.getElementById("descrizione-planing");
let dateExecution = document.getElementById("date-execution-planing");
let timeBeginning = document.getElementById("time-begin");
let timeEnded = document.getElementById("time-end");
let addPlanningButton = document.getElementById("setPlanning");


let user = null;
let azienda = null;
let listOfSerraNumber = 0;


function addRowInSerraTable(json, index) {
    const cloneSerraTableTbodyRow = serraTableTbodyRow.content.cloneNode(true);
    cloneSerraTableTbodyRow.querySelector(".row-number").textContent = index;

    if (json.hasOwnProperty("idSerra")) {
        let serraDelete = cloneSerraTableTbodyRow.querySelector(".serra-delete");
        serraDelete.setAttribute("data-id-serra", json.idSerra);
        clickDeleteRowSerra(serraDelete);
        let serraDetails = cloneSerraTableTbodyRow.querySelector(".serra-details");
        serraDetails.setAttribute("data-id-serra", json.idSerra);
        clickDetailsRowSerra(serraDetails);
    }
    cloneSerraTableTbodyRow.querySelector(".row-description").textContent = json.descrizione;
    serraTableTbody.appendChild(cloneSerraTableTbodyRow);
}

let setAttuatore = (attuatore, rowMode, rowStatus, rowChangeMode, rowChangeStatus) => {
    rowStatus.textContent = attuatore.stato.stato;
    rowMode.textContent = attuatore.stato.mode;
    rowChangeStatus.setAttribute("data-id-attuatore", attuatore.idAttuatore);
    rowChangeMode.setAttribute("data-id-attuatore", attuatore.idAttuatore);

    rowChangeMode.addEventListener("click", (event) => {
        let currentMode = event.target.parentElement.previousElementSibling.textContent
        if(currentMode === "MANUALE"){
            fetch(changeAttuatoreToAutomatiqueModeUrl + event.target.getAttribute("data-id-attuatore")).then(response => response.json()).then(json => {
                if (json.hasOwnProperty("messages")) {
                    console.log("Find sensore error caught: " + json.messages)
                    throw new Error(json.messages)
                } else {
                    event.target.parentElement.previousElementSibling.textContent = json.stato.mode
                }
            })
        } else {
            fetch(changeAttuatoreToManualModeUrl + event.target.getAttribute("data-id-attuatore")).then(response => response.json()).then(json => {
                if (json.hasOwnProperty("messages")) {
                    console.log("Find sensore error caught: " + json.messages)
                    throw new Error(json.messages)
                } else {
                    event.target.parentElement.previousElementSibling.textContent = json.stato.mode
                }
            })
        }
    })
    rowChangeStatus.addEventListener("click", (event) => {
        let currentMode = event.target.parentElement.previousElementSibling.textContent
        if (currentMode === "DISATTIVATO") {
            fetch(changeAttuatoreToEnableStatusUrl + event.target.getAttribute("data-id-attuatore")).then(response => response.json()).then(json => {
                if (json.hasOwnProperty("messages")) {
                    console.log("Find sensore error caught: " + json.messages)
                    throw new Error(json.messages)
                } else {
                    event.target.parentElement.previousElementSibling.textContent = json.stato.stato
                }
            })
        } else {
            fetch(changeAttuatoreToDisableStatusUrl + event.target.getAttribute("data-id-attuatore")).then(response => response.json()).then(json => {
                if (json.hasOwnProperty("messages")) {
                    console.log("Find sensore error caught: " + json.messages)
                    throw new Error(json.messages)
                } else {
                    event.target.parentElement.previousElementSibling.textContent = json.stato.stato
                }
            })
        }
    })
}


let clickDetailsRowSerra = (element) => {
    if(element !== null){
        element.addEventListener("click", (event) => {
            while (serraTableTbody.querySelector("#sensore-table-tbody").firstChild) {
                serraTableTbody.querySelector("#sensore-table-tbody").firstChild.remove();
            }
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
                    let detailsListNumber = 0;
                    json.forEach(sensore => {
                        const cloneDetailsSerraTableTbody = detailsSerraTableTbody.content.cloneNode(true);
                        const rowNumber = cloneDetailsSerraTableTbody.querySelector(".row-number");
                        const rowType = cloneDetailsSerraTableTbody.querySelector(".row-type");
                        const rowMeasure = cloneDetailsSerraTableTbody.querySelector(".row-measure");
                        const rowStatus = cloneDetailsSerraTableTbody.querySelector(".row-status");
                        const rowMode = cloneDetailsSerraTableTbody.querySelector(".row-mode");
                        const rowChangeMode = cloneDetailsSerraTableTbody.querySelector(".change-mode");
                        const rowChangeStatus = cloneDetailsSerraTableTbody.querySelector(".change-status");
                        rowNumber.textContent = detailsListNumber + 1;
                        if (sensore.hasOwnProperty("tipo")) {
                            rowType.textContent = sensore.tipo
                        }
                        if (sensore.hasOwnProperty("idSensore")) {
                            rowNumber.setAttribute("data-id-sensore", sensore.idSensore)
                            fetch(getMisuraUrl + sensore.idSensore).then(response => response.json()).then(json => {
                                if (json.hasOwnProperty("messages")) {
                                    console.log("Find sensore error caught: " + json.messages)
                                    throw new Error(json.messages)
                                } else {
                                    const measure = json[0];
                                    if (measure.hasOwnProperty("misura")) {
                                        rowMeasure.textContent = measure.misura;
                                    }
                                }
                            })
                        }
                        if (sensore.hasOwnProperty("idSerra")) {
                            let getAttuatoriRequest = new Request(getAttuatoriByIdSerra + sensore.idSerra, {
                                method: "GET",
                                headers: {"Content-Type": "application/json;charset=UTF-8"}
                            })
                            fetch(getAttuatoriRequest).then(response => response.json()).then(json => {
                                if (json.hasOwnProperty("messages")) {
                                    console.log("Find sensore error caught: " + json.messages)
                                    throw new Error(json.messages)
                                } else {
                                    json.forEach(attuatore => {
                                        if ((sensore.hasOwnProperty("tipo")) && (attuatore.hasOwnProperty("tipo"))) {
                                            if ((sensore.tipo === "LUCE") && (attuatore.tipo === "ILLUMINAZIONE")) {
                                                setAttuatore(attuatore, rowMode, rowStatus, rowChangeMode, rowChangeStatus)
                                            } else if ((sensore.tipo === "TEMPERATURA") && (attuatore.tipo === "RISCALDAMENTO")) {
                                                setAttuatore(attuatore, rowMode, rowStatus, rowChangeMode, rowChangeStatus)
                                            } else if ((sensore.tipo === "UMIDITA") && (attuatore.tipo === "IRRIGAZIONE")) {
                                                setAttuatore(attuatore, rowMode, rowStatus, rowChangeMode, rowChangeStatus)
                                            }
                                        }
                                    })
                                }
                            })
                        }
                        serraTableTbody.querySelector("#sensore-table-tbody").appendChild(cloneDetailsSerraTableTbody);
                        detailsListNumber++;
                    })
                }
            })
        })
    }
}

let clickDeleteRowSerra = (element) => {
    element.addEventListener("click", (event) => {
        const idSerra = event.target.getAttribute("data-id-serra");
        const row = event.target.parentElement.parentElement;
        let deleteSerraRequest = new Request((deleteSerraUrl + idSerra), {
            method: "DELETE",
            headers: {"Content-Type": "application/json;charset=UTF-8"},
            mode: "cors"
        })
        fetch(deleteSerraRequest).then(response => response.json()).then(json => {
            if (json.hasOwnProperty("messages")) {
                console.log("Delete serra error caught: " + json.messages)
                throw new Error(json.messages)
            } else {
                row.remove();
                console.log(json);
            }
        })
    })
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
                    if(json.hasOwnProperty("messages")){
                        console.log("Delete serra error caught: " + json.messages)
                        throw new Error(json.messages)
                    } else {
                        azienda = json;
                        if (azienda.hasOwnProperty("nome")) {
                            aziendaAgricolaName.textContent = azienda.nome;
                        }
                        if (azienda.hasOwnProperty("descrizione")) {
                            aziendaAgricolaDescription.textContent = azienda.descrizione;
                        }

                        fetch(getSerraByIdAziendaUrl + azienda.idAziendaAgricola).then(response => response.json()).then(json => {
                            if (json.hasOwnProperty("messages")) {
                                console.log("Delete serra error caught: " + json.messages)
                                throw new Error(json.messages)
                            } else {
                                listOfSerraNumber = json.length;
                                for (const i in json) {
                                    addRowInSerraTable(json[i], (parseInt(i) + 1));
                                }
                            }
                        })
                    }
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

addPlanningButton.addEventListener("click", () => {
    let description = descriptionPlanning.value
    let date = dateExecution.value
    let begin = timeBeginning.value
    let end = timeEnded.value

    console.log(description + " **** " + date + " **** " + begin + "****" + end)
})