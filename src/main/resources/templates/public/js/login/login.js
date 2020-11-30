function loadDocente() {

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        document.getElementById("contenedor").innerHTML = this.responseText;
      }
    };
    xhttp.open("GET", "vista/login/loginDocente.html", true);
    xhttp.send();
    $("#recuContra").css({
      "display": "block"
    });
    return false;
  }

  function loadAdministrador() {

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        document.getElementById("contenedor").innerHTML = this.responseText;
      }
    };
    xhttp.open("GET", "vista/login/loginAdministrador.html", true);
    xhttp.send();
    $("#recuContra").css({
      "display": "block"
    });
    return false;
  }

  function loadAdministrativo() {

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        document.getElementById("contenedor").innerHTML = this.responseText;
      }
    };
    xhttp.open("GET", "vista/login/loginAdministrativo.html", true);
    xhttp.send();
    $("#recuContra").css({
      "display": "block"
    });
    return false;
  }

  function loadCo() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        document.getElementById("contenedor").innerHTML = this.responseText;
      }
    };
    xhttp.open("GET", "vista/login/password.html", true);
    xhttp.send();
    $("#recuContra").css({
      "display": "none"
    });
  
    return false;
  }