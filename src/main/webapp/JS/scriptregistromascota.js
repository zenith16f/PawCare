function validateText(event) {
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

function validateLen(event) {
    let nameInput = event.target.value;
    if (nameInput.length >= 255) {
        event.preventDefault(); // Evitar que se ingrese más caracteres
        return false;
    }
}

function resetForm() {
      let form = document.getElementById('form');
      form.reset();
}

function submit() {
    let form = document.getElementById('form');
    let inputs = form.querySelectorAll('input[type="date"], input[type="text"]');

    for (let i = 0; i < inputs.length; i++) {
        if (inputs[i].value.trim() === '') {
            alert('Por favor, complete todos los campos.');
            return false;
        }
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
    