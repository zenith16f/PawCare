<!DOCTYPE html>
<html lang="es">
    <head>
        <!-- Imports -->
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Crimson+Text:wght@600&display=swap" rel="stylesheet">
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>

        <!-- Local -->
        <title>PawCare | Iniciar Sesión</title>
        <link rel="icon" href="./IMG/logotype.png">
        <link rel="stylesheet" href="./CSS/styleform.css">
        <script src="./JS/scriptform.js"></script>
        <meta charset="UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <header>
            <!-- Nav -->
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid">
                    <!-- Icono -->
                    <a class="navbar-brand" href="./index.html"><img class="menu-img" src="./IMG/logotype.png" alt="logotype"> PawCare</a>
                </div>
            </nav>
        </header>
        <main>
            <div class="container form">
                <h1 class="text-center">Iniciar Sesión</h1>
                <hr class="table-group-divider">
                <form action="LoginServlet" id="form">
                    <div class="row">
                        <div class="col-12">
                            <label for="">Correo Electrónico</label>
                            <input id="mail" class="teclear" name="correo" type="text" onkeypress="return validateEmail(event)" required minlength="10" maxlength="255">
                            <br>
                            <label for="password">Contraseña</label>
                            <input class="teclear" name="password" type="password" id="password" onkeypress="return validatePassword(event)" required minlength="8" maxlength="255">
                        </div>
                        <div class="col-12">
                            <p class="text-center link">¿No tienes cuenta? <a href="./registro.html">Registrarme</a></p>
                        </div>
                        <div class="col-12 text-center buttons">
                            <input class="btn btn-outline-primary" type="submit" value="Ingresar" onclick="return submitLog()">
                            <input class="btn btn-outline-primary"  type="reset" value="Vaciar" onclick="return resetForm()">
                        </div>
                    </div>
                </form>
            </div>
        </main>
        <footer>
            <div class="container">
                <p class="text-center"> <a href="#" class="more">Terminos y Condiciones</a>  || <a href="#" class="more">Políticas de Privacidad</a> </p>
            </div>
        </footer>
    </body>
</html>