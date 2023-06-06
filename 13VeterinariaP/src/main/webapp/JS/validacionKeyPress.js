/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function validarDiagnostico(event) {
    var charCode = event.charCode;

    // Verificar si el carácter es una letra (a-z o A-Z)
    if ((charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <= 122)) {
        return true;
    }

    // Permitir la tecla de retroceso (Backspace) y la tecla de espacio (Space)
    if (charCode === 8 || charCode === 32) {
        return true;
    }

    // Para cualquier otro carácter, impedir su ingreso
    return false;
}

function validarTexto(event) {
    var charCode = event.charCode;

    // Verificar si el carácter es una letra (a-z o A-Z)
    if ((charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <= 122)) {
        return true;
    }

    // Permitir la tecla de retroceso (Backspace) y la tecla de espacio (Space)
    if (charCode === 8 || charCode === 32) {
        return true;
    }

    // Para cualquier otro carácter, impedir su ingreso
    return false;
}

function validarNumero(event) {
    let teclado = document.all ? event.keyCode : event.which;
    if (teclado == 8)
        return true;
    let patron = /[0-9\d{10} .]/;
    let codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}

function validarTratamiento(event) {
    var charCode = event.charCode;

    // Verificar si el carácter es un número (0-9)
    if ((charCode >= 48 && charCode <= 57)) {
        return true;
    }

    // Verificar si el carácter es una letra (a-z o A-Z)
    if ((charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <= 122)) {
        return true;
    }

    // Permitir la tecla de retroceso (Backspace) y la tecla de espacio (Space)
    if (charCode === 8 || charCode === 32) {
        return true;
    }

    // Para cualquier otro carácter, impedir su ingreso
    return false;

}