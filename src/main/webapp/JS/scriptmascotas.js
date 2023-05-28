function adjustFooterPosition() {
    var windowHeight = window.innerHeight;
    var documentHeight = document.documentElement.scrollHeight;
    var footer = document.querySelector('footer');
  
    if ( windowHeight - documentHeight > 0) {
      footer.style.position = 'fixed';
      footer.style.left = '0';
      footer.style.bottom = '0';
      footer.style.width = '100%';
      footer.style.height = '26px';
      footer.style.backgroundColor = '#F8F9FA';
      footer.style.marginBottom = '10px';
    } else {
      footer.style.position = 'static';
      footer.style.marginBottom = '0';
    }
  }
  
  // Llamamos a la función cuando se carga la página y cuando se cambia el tamaño de la ventana
  window.onload = function () {
    adjustFooterPosition();
  };
  
  window.onresize = function () {
    adjustFooterPosition();
  };
  