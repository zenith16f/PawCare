<%--
    Document   : conclusionVet
    Created on : 3 jun 2023, 22:00:31
    Author     : Zenith
--%>

<%@page import="Model.Cita"%>
<%@page import="DAO.CitaDAO"%>
<%@page import="DAO.BDConnection"%>
<%@page import="java.sql.Connection"%>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

        <!-- Local -->
        <title>PawCare</title>
        <link rel="icon" href="./IMG/logotype.png">
        <link rel="stylesheet" href="./CSS/styleindex.css">
        <script src="./JS/scriptindex.js"></script>
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


        <h2>PostCita</h2>
        <%
            try {

                Connection conexion = BDConnection.getConnection(request.getServletContext());

                CitaDAO citaDao = new CitaDAO(conexion);

                int id = Integer.parseInt(request.getParameter("id"));

                Cita cita = citaDao.obtenerCitaPorId(id);


        %>
        <form action="updateCitaVet" method="post">
            <input type="text" name="citaId" readOnly="readOnly" value="<%=cita.getId()%>" hidden>
            <br>
            <label>Nombre de la mascota</label>
            <input type="text" name="nombre" readOnly="readOnly" value="<%=cita.getNombreMascota()%>">
            <br>
            <label>Fecha de la cita</label>
            <input type="text" name="fechaCita" readOnly="readOnly" value="<%=cita.getFechaCita()%>">
            <br>
            <label>Tipo de cita</label>
            <input type="text" name="tipoCita" readOnly="readOnly" value="<%=cita.getDescripcionTipo()%>">
            <br>
            <label>Nota</label>
            <textArea  name="nota" readOnly="readOnly"><%=cita.getNota()%></textarea>
            <br>
            <label>Talla</label>
            <input type="number" name="talla">
            <br>
            <label>Temperatura</label>
            <input type="number" name="temp">
            <br>
            <label>Diagnostico</label>
            <textarea name="diagnostico"></textarea>
            <br>
            <label>Tratamiento</label>
            <textarea  name="tratamiento"></textarea>
            <br>
            <br>
            <input type="submit" value="Agregar datos">
            <input type="reset" value="Vaciar">

        </form>
        <%
            } catch (Exception ex) {
                System.out.println("Error al obtener la cita");
                System.out.println("ERROR: " + ex.getMessage());
            }
        %>
        <footer>
            <div class="container">
                <h6 class="text-center">Información de Contacto</h6>
                <hr class="table-group-divider">
                <div class="row">
                    <div class="col-lg-4 col-xl-4 col-md-4 col-sm-4">
                        <p><a href="#" class="more">Información</a></p>
                        <p><a href="" class="more">Soporte</a></p>
                        <p><a href="" class="more">Contactanos</a></p>
                    </div>
                    <div class="col-lg-4 col-xl-4 col-md-4 col-sm-5">
                        <p><a href="" class="more">Términos y Condiciones</a></p>
                        <p><a href="" class="more">About Us</a></p>
                        <p><a href="" class="more">Políticas</a></p>
                        <p><a href="" class="more">Servicios</a></p>
                    </div>
                    <div class="col-lg-4 col-xl-4 col-md-4 col-sm-3">
                        <p><a href="#" class="more"><ion-icon name="logo-instagram"></ion-icon> Instagram</a></p>
                        <p><a href="#" class="more"><ion-icon name="logo-facebook"></ion-icon> Facebook</a></p>
                        <p><a href="#" class="more"><ion-icon name="logo-twitter"></ion-icon> Twitter</a></p>
                        <p><a href="#" class="more"><ion-icon name="mail-outline"></ion-icon> Email</a></p>
                    </div>
                </div>
                <br>
                <p class="text-center copyright">Todos los derechos reservados ©Copyright 2023</p>
            </div>
        </footer>
    </body>
</html>