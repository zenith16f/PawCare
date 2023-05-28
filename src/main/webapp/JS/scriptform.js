function validateName(event) {
  let char = event.keyCode;

  if ((char > 64 && char < 91) || (char > 96 && char < 123) || char === 8) {
    // Verificar la longitud actual del campo de texto
    let nameInput = event.target.value;
    if (nameInput.length >= 255) {
      event.preventDefault(); // Evitar que se ingrese más caracteres
      return false;
    }
    return true;
  } else {
    return false;
  }
}

function validateDir(event) {
    let input = event.target;
    let char = event.key;
  
    if ((char >= 'a' && char <= 'z') || (char >= 'A' && char <= 'Z') || (char >= '0' && char <= '9') || char === "," || char === ' ' || char === '-' || char === '.' || char === ':' || /[áéíóúÁÉÍÓÚ]/.test(char)) {
        if (input.value.length >= 255) {
            event.preventDefault();
        }
    } else {
        event.preventDefault();
    }
}


function validateEmail(event) {
    let char = String.fromCharCode(event.keyCode);
    let patron = /[A-Za-z0-9.@_-]/;
    return patron.test(char);
}

function validatePassword(event) {
    let input = event.target;
    if (input.value.length >= 255) {
        event.preventDefault();
    }
}

function resetForm() {
    let form = document.getElementById('form');
    form.reset();
}

function submitRegister() {
    let form = document.getElementById('form');
    let inputs = form.querySelectorAll('input[type="text"], input[type="password"], input[type="email"]');
    
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

    let inputname = document.getElementById("nombre");
    let inputappat = document.getElementById("appat");
    let inputapmat = document.getElementById("apmat")
    let inputdir = document.getElementById("dir")
    let inputmail = document.getElementById("mail")
    let inputpass = document.getElementById("password")
    let inputconf = document.getElementById("confirmPassword")

    if(inputname.value.length < 3 || inputname.value.length > 255  ||
        inputappat.value.length < 3 || inputappat.value.length > 255 ||
        inputapmat.value.length < 3 || inputapmat.value.length > 255 ||
        inputdir.value.length < 10 || inputdir.value.length > 255 ||
        inputmail.value.length < 10 || inputmail.value.length > 255 ||
        inputpass.value.length < 8 || inputpass.value.length > 255 ||
        inputconf.value.length < 8 || inputconf.value.length > 255){
        alert("Error, la cantidad de caracteres permitidos en una entrada no se encuentra en el rango permitido");
        return false
    }
    if (!/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/.test(inputmail.value)) {
        alert("Correo Inválido");
        return false;
    }
    // if (!/^([A-Za-záéíóúüñ\s]+)([\s,\.])(\w+\s)?(\d+)?([\s,\.])([A-Za-záéíóúüñ\s]+)$/.test(inputdir.value)) {
    //     alert("Dirección Inválida");
    //     return false;
    // } 
    if(inputname.value.trim() == "" || inputapmat.value.trim() == "" || inputappat.value.trim() == ""){
        alert("Error, no se permiten espacios vacíos en las entradas");
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

    let inputmail = document.getElementById("mail")
    let inputpass = document.getElementById("password")

    if(inputmail.value.length < 10 || inputmail.value.length > 255  ||
        inputpass.value.length < 8 || inputpass.value.length > 255){
        alert("Error, la cantidad de caracteres permitidos en una entrada no se encuentra en el rango permitido");
        return false
    }
    if (!/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/.test(inputmail.value)) {
        alert("Correo Inválido");
        return false;
    }
    form.submit();
}

function setFormMargin() {
    var formDiv = document.querySelector('.form');
    var windowWidth = window.innerWidth;
  
    if (windowWidth <= 992) {
      formDiv.style.marginTop = '20px';
    } else {
      formDiv.style.marginTop = '150px';
    }
  }
  
  // Llamamos a la función cuando se carga la página y cuando se cambia el tamaño de la ventana
  window.onload = setFormMargin;
  window.onresize = setFormMargin;
  
  function setFooterMargin() {
    var formDiv = document.querySelector('.form');
    var footer = document.querySelector('footer');
    var windowWidth = window.innerWidth;
  
    if (windowWidth <= 992) {
      footer.style.marginTop = 20 + 'px';
      footer.style.position = 'relative';
    } else {
      footer.style.marginTop = '0';
      footer.style.position = 'fixed';
      footer.style.left = '0';
      footer.style.bottom = '0';
      footer.style.width = '100%';
      footer.style.height = '26px';
      footer.style.backgroundColor = '#F8F9FA';
      footer.style.marginBottom = '10px';
    }
  }
  
  // Llamamos a la función cuando se carga la página y cuando se cambia el tamaño de la ventana
  window.onload = function () {
    setFormMargin();
    setFooterMargin();
  };
  
  window.onresize = function () {
    setFormMargin();
    setFooterMargin();
  };
  