let uname = document.getElementById('user_name');
uname.addEventListener("blur", checkUsernameAvailability);
let avail = true;
function checkUsernameAvailability() {
    let username = uname.value;

    $.ajax({
        url: "/checkUsername",
        type: "GET",
        data: { user_name: username },
        success: function (response) {
            if (response === "taken") {
                avail=false;
            } else {
                $("#username-error").text("");
                avail=true;
            }
        },
        error: function () {
            console.error("Error checking username availability");
        }
    });
}


function isRecaptchaCorrect(type) {
    let query='';
    if(type === 'reg') {query='#g-recaptcha-response-1';} else
    if(type === 'login') {query='#g-recaptcha-response-2';} else
    {query='#g-recaptcha-response';}
    let res = $(query).val();

    if (res === "" || res === undefined || res.length === 0)
        return false;
    else
        return true;
}

let checkButton = document.getElementById('loginsubmitbutton');
checkButton.addEventListener('focus',isPasswordPresent)
let validLogin = true;
function isPasswordPresent() {
    let passElement=document.getElementById('passWord');
    let unameElement=document.getElementById('userName');

    let password = passElement.value;
    let username = unameElement.value;
    $.ajax({
        url: "/checkPass",
        type: "GET",
        data: {
            user_name: username,
            pass_word: password },
        success: function (response) {
            if (response === "failed") {
                validLogin=false;
            } else {
                $("#username-error").text("");
                validLogin=true;
            }
        },
        error: function () {
            console.error("Error checking username availability");
        }
    });
}

function validateLogin() {
    clearErrors();
    let valid = true;
    if(!validLogin)
    {
        displayError("loginError", "Incorrect username or password.");
        valid = false;
        }
    if(!isRecaptchaCorrect('login')) {
        displayError("login-recaptcha-error", "Please validate your reCAPTCHA");
        valid = false;}

    return valid;
}

function validateUpload()
{
    clearErrors();
    let fileElement = document.getElementById("file");
    let upValid = true;
    if(!isRecaptchaCorrect())
    {
        displayError("upload-recaptcha-error", "Please validate your reCAPTCHA")
        upValid=false;
    }
    return upValid;
}

function validateForm() {
    clearErrors();

    let username = document.getElementById("user_name").value;
    let password = document.getElementById("pass_word").value;
    let confirmPassword = document.getElementById("confirmPassword").value;

    let isValid = true;

    if(!isRecaptchaCorrect('reg')) {
        displayError("reg-recaptcha-error", "Please validate your reCAPTCHA");
        isValid = false;}

    if (username.trim().length <5 || username.trim().length > 20) {
        displayError("username-error", "Username must be between 5 and 20 characters.");
        isValid = false;
    }
    if(!avail) {
        displayError("username-error", "Username is already taken.");
        isValid=false;}

    if (password.trim().length < 5 || password.trim().length > 20) {
        displayError("password-error", "Password must be between 5 and 20 characters.");
        isValid = false;
    }

    if (confirmPassword.trim() === "") {
        displayError("confirmPassword-error", "Confirm your password.");
        isValid = false;
    } else if (password !== confirmPassword) {
        displayError("confirmPassword-error", "Passwords do not match.");
        isValid = false;
    }

    return isValid;
}

function displayError(errorId, errorMessage) {
    const errorElement = document.getElementById(errorId);
    errorElement.innerHTML = errorElement.textContent + `\n` +errorMessage;
}

function clearErrors() {
    let errorElements = document.querySelectorAll(".has-error");
    errorElements.forEach(function (element) {
        element.innerHTML = "";
    });
}
