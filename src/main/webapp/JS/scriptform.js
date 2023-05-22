function validateName() {
    let char = event.keyCode;

    if ((char > 64 && char < 91) || (char > 96 && char < 123) || char == 8)
        return true;
    else return false;
}

function validateLastName() {
    let char = event.keyCode;

    if ((char > 64 && char < 91) || (char > 96 && char < 123) || char == 8)
        return true;
    else return false;
}

function validateTelephone(event) {
    let teclado = document.all ? event.keyCode : event.which;
    if (teclado == 8) return true;
    let patron = /[0-9\d{10} .]/;
    let codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}

function validateNumber(event) {
    let teclado = document.all ? event.keyCode : event.which;
    if (teclado == 8) return true;
    let patron = /[0-9\d{10} .]/;
    let codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}

function validateEmail(event) {
    let char = String.fromCharCode(event.keyCode);
    let patron = /[A-Za-z0-9.@_-]/;
    return patron.test(char);
}

function validatePassword(event) {
    let input = event.target;
    if (input.value.length >= 10) {
        event.preventDefault();
    }
}

function resetForm() {
    let form = document.getElementById('form');
    form.reset();
}

function submitRegister() {
    let form = document.getElementById('form');
    let inputs = form.querySelectorAll('input[type="text"], input[type="tel"], input[type="password"], input[type="email"]');
    
    for (let i = 0; i < inputs.length; i++) {
        if (inputs[i].value.trim() === '') {
            alert('Por favor, complete todos los campos.');
            return false;
        }
    }

    let passwordInput = document.getElementById('password');
    let confirmPasswordInput = document.getElementById('confirmPassword');

    if (passwordInput.value !== confirmPasswordInput.value) {
        alert('La contraseña y la confirmación de contraseña deben ser iguales.');
        return false;
    }

    form.submit();
}

function submitLog(){
    let form = document.getElementById('form');
    let inputs = form.querySelectorAll('input[type="text"], input[type="password"]');
    
    for (let i = 0; i < inputs.length; i++) {
        if (inputs[i].value.trim() === '') {
            alert('Por favor, complete todos los campos.');
            return false;
        }
    }

    form.submit();
}