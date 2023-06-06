<%--
    Document   : infoCita
    Created on : 5 jun 2023, 01:55:00
    Author     : Zenith
--%>

<%@page import="DAO.BDConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="Model.Cita"%>
<%@page import="DAO.CitaDAO"%>
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

        <!-- Local -->
        <title>Mis Mascotas</title>
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
                    <a class="navbar-brand" href="./inicio.jsp"><img class="menu-img" src="./IMG/logotype.png" alt="logotype"> PawCare</a>
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
                                    <li><a class="dropdown-item" href="./inicio.jsp">Inicio</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="./perfil.jsp">Configuración</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="cerrarSesion">Cerrar Sesión</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Mascotas
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="./propias.jsp">Mis mascotas</a></li>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./cita.jsp">Agendar Citas</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <h1>Este es el resultado de la cita</h1>
        <table  class="table table-hover">

            <%
                try {

                    Connection conexion = BDConnection.getConnection(request.getServletContext());

                    CitaDAO citaDao = new CitaDAO(conexion);

                    int id = Integer.parseInt(request.getParameter("id"));

                    Cita cita = citaDao.obtenerCitaPorId(id);


            %>


            <tr>
                <td>Nombre de la mascota</td>
                <td><%=cita.getNombreMascota()%></td>
            </tr>
            <tr>
                <td>Fecha de la cita</td>
                <td><%=cita.getFechaCita()%></td>
            </tr>
            <tr>
                <td>Nota</td>
                <td><%=cita.getNota()%></td>
            </tr>
            <tr>
                <td>Tipo de cita</td>
                <td><%=cita.getDescripcionTipo()%></td>
            </tr>
            <tr>
                <td>Diagnostico</td>
                <td><%=cita.getDiagnostico()%></td>
            </tr>
            <tr>
                <td>Tratamiento</td>
                <td><%=cita.getTratamiento()%></td>
            </tr>
            <tr>
                <td>Temperatura</td>
                <td><%=cita.getTemperatura()%></td>
            </tr>
            <tr>
                <td>Talla</td>
                <td><%=cita.getTalla()%></td>
            </tr>

            <%            } catch (Exception ex) {
                    System.out.println("Error al obtener la informacion");
                    System.out.println("ERROR: " + ex.getMessage());
                }
            %>

        </table>

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
