function validateForm() {
    // Reset previous error messages
    clearErrors();

    // Get form input values
    let username = document.getElementById("user_name").value;
    let password = document.getElementById("pass_word").value;
    let confirmPassword = document.getElementById("confirmPassword").value;

    let isValid = true;

    if (username.trim().length <5 || username.trim().length > 20) {
        displayError("username-error", "Юзернейм должен быть от 5 до 20 символов.");
        isValid = false;
    }
    if (password.trim().length < 5 || password.trim().length > 20) {
        displayError("password-error", "Пароль должен быть от 5 до 20 символов.");
        isValid = false;
    }

    if (confirmPassword.trim() === "") {
        displayError("confirmPassword-error", "Подтвердите пароль.");
        isValid = false;
    } else if (password !== confirmPassword) {
        displayError("confirmPassword-error", "Пароли не совпадают.");
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
