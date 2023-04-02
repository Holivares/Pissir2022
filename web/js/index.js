let loginUrl = "http://127.0.0.1:8080/v1/utenti/utenteAutenticazione";


let signIn = document.getElementById("sign-in");
let emailInput = document.getElementById("email-data");
let passwordInput = document.getElementById("password-data");
let serraDetails = document.getElementById("serra-tab-bis");
let addSerra = document.getElementById("btn-add-serra");


signIn.addEventListener("click", () => {

    let loginJson = {"email": emailInput.value, "password": passwordInput.value};

    let loginRequest = new Request(loginUrl,
        {
            method: 'POST',
            headers: {'content-Type': 'application/json;charset=UTF-8'},
            mode: 'no-cors',
            body: JSON.stringify(loginJson)
        })

    fetch(loginRequest).then(response => response.json()).then(json => {
        if (json.hasOwnProperty('messages')) {
            console.log('Login error caught: ' + json.get('messages'))
            throw new Error(json.get('messages'))
        }

        console.log("login success info: " + JSON.stringify(json))
    })
}, false)