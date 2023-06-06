<%--
    Document   : perfilVet
    Created on : 2 jun 2023, 20:33:58
    Author     : Zenith
--%>

<%@page import="Model.Veterinario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <%
            try {

                Veterinario veterinario = (Veterinario) request.getSession().getAttribute("veterinario");

                if (veterinario == null) {
                    // Manejar el caso en que no haya propietario en la sesión
                    response.sendRedirect("vetLogin.jsp");
                    return;
                }

                String nombre, correo, contraseña, telefono, especialidad;
                int cedula;

                nombre = veterinario.getNombre();
                correo = veterinario.getCorreo();
                contraseña = veterinario.getContraseña();
                telefono = veterinario.getTelefono();
                especialidad = veterinario.getEspecialidad();

                cedula = veterinario.getCedula();

        %>

        <!-- Local -->
        <title><%=nombre%></title>
        <link rel="icon" href="./IMG/logotype.png">
        <link rel="stylesheet" href="./CSS/stylemascotas.css">
        <script src="./JS/scriptmascotas.js"></script>
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
                    <a class="navbar-brand" href="./inicioVet.jsp"><img class="menu-img" src="./IMG/logotype.png" alt="logotype"> PawCare</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <!-- Links -->
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Perfil
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./inicioVet.jsp">Inicio</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="./perfilVet.jsp">Configuración</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="cerrarSesion">Cerrar Sesión</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Mascotas & Propietarios
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./mascotasVet.jsp">Mascotas Registradas</a></li>
                                    <li><a class="dropdown-item" href="./propietariosVet.jsp">Propietarios Registrados</a></li>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./citasVet.jsp">Citas Agendadas</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>

        <main>
            <h1 class="text-center"><%= nombre%></h1>
            <div class="container">
                <form action="editarVeterinario" method="post">
                    <h2>Datos profesionales</h2>
                    <h3>Nombre</h3>
                    <input type="text" name="nombre" id="nombre" value="<%=nombre%>">
                    <h3>Telefono</h3>
                    <input type="text" name="telefono" id="telefono" value="<%=telefono%>">
                    <h3>Especialidad</h3>
                    <input type="text" name="especialidad" id="especialidad" value="<%=especialidad%>">
                    <h2>Datos de cuenta</h2>
                    <h3>Correo Electrónico</h3>
                    <input type="text" name="correo" id="correo" value="<%=correo%>">
                    <h3>Contraseña</h3>
                    <input type="text" name="password" id="password" value="<%=contraseña%>">
                    <br>
                    <br>
                    <input type="submit" value="Editar Datos">
                </form>
                <br>
                <a href=" eliminarVeterinario?id=<%=cedula%>">Eliminar Cuenta</a>
                <br>
            </div>
        </main>

        <footer>
            <div class="container">
                <h6 class="text-center">Información de Contacto</h6>
                <hr class="table-group-divider">
                <div class="row">
                    <div class="col-lg-3 col-xl-3 col-md-4 col-sm-4">
                        <p>Información</p>
                        <p>Soporte</p>
                        <p>Contactanos</p>
                    </div>
                    <div class="col-lg-7 col-xl-7 col-md-4 col-sm-4">
                        <p>Términos y Condiciones</p>
                        <p>About Us</p>
                        <p>Políticas</p>
                        <p>Servicios</p>
                    </div>
                    <div class="col-lg-1 col-xl-1 col-md-4 col-sm-4">
                        <p><a href="#"><ion-icon name="logo-instagram"></ion-icon></a></p>
                        <p><a href="#"><ion-icon name="logo-facebook"></ion-icon></a></p>
                        <p><a href="#"><ion-icon name="logo-twitter"></ion-icon></a></p>
                        <p><a href="#"><ion-icon name="mail-outline"></ion-icon></a></p>
                    </div>
                </div>
                <br>
                <p class="text-center">© 2023</p>
            </div>
        </footer>

        <%            } catch (Exception ex) {
                System.out.println("Error al obtener el perfil del veterinario");
                System.out.println("ERROR: " + ex.getMessage());
            }
        %>
    </body>
</html>
