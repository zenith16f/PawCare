<%--
    Document   : registroMascota
    Created on : 29 may 2023, 01:28:38
    Author     : fer_1
--%>

<%@page import="DAO.BDConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="DAO.MascotaDAO"%>
<%@page import="Model.Mascota"%>
<%@page import="java.util.List"%>
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
        <title>PawCare | Añadir Mascota</title>
        <link rel="icon" href="./IMG/logotype.png">
        <link rel="stylesheet" href="./CSS/styleregistromascota.css">
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
                </div>
            </nav>
        </header>
        <main>
            <div class="container form">
                <h1 class="text-center">Nueva Mascota</h1>
                <hr class="table-group-divider">
                <form action="crearMascota" id="form">
                    <div class="row">
                        <div class="col-12">
                            <label for="nombre">Nombre</label>
                            <input id="nombre" class="teclear" name="nombre" type="text" onkeypress="" required minlength="3" maxlength="255">
                            <br>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
                            <label for="sexo">Sexo</label>
                            <select class="teclear" name="sexo" id="sexo">
                                <option value="">Selecciona una opción</option>
                                <option value="Macho">Macho</option>
                                <option value="Hembra">Hembra</option>
                            </select>
                            <br>
                            <label for="especie">Especie</label>
                            <select class="teclear" name="especie" id="especie" onchange="updateRazas()">
                                <option value="">Selecciona una especie</option>
                                <%
                                    Connection conexion = BDConnection.getConnection(request.getServletContext());

                                    MascotaDAO mascotaDao = new MascotaDAO(conexion);
                                    List<Mascota> especies = mascotaDao.getEspecies();

                                    for (Mascota mascota : especies) {
                                %>
                                <option value="<%=mascota.getIdEspecie()%>">
                                    <%=mascota.getTipoEspecie()%>
                                </option>

                                <%
                                    }
                                %>
                            </select>
                            <br>
                            <label for="raza">Raza</label>
                            <select class="teclear" name="raza" id="raza">
                                <option value="">Selecciona una raza</option>
                                <%
                                    List<Mascota> razas = mascotaDao.getRazas();

                                    for (Mascota mascota : razas) {
                                %>

                                <option value="<%=mascota.getIdRaza()%>">
                                    <%=mascota.getTipoRaza()%>
                                </option>

                                <%
                                    }
                                %>
                            </select>
                            <br>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
                            <label for="fechaNacimiento">Fecha de Nacimiento</label>
                            <input id="fechaNacimiento" class="teclear" name="fechaNacimiento" type="date" onkeypress="" required minlength="10" maxlength="10">
                            <br>
                            <label for="pelaje">Pelaje</label>
                            <input class="teclear" name="pelaje" type="text" id="pelaje" onkeypress="" required minlength="1" maxlength="255">
                            <br>
                            <label for="senas">Señas particulares</label>
                            <input class="teclear" name="senas" type="text" id="senas" onkeypress="" required minlength="1" maxlength="255">
                            <br>
                        </div>
                        <div class="col-12 text-center buttons">
                            <input class="btn btn-outline-primary" type="submit" value="Registrar mascota" >

                            <input class="btn btn-outline-primary"  type="reset" value="Vaciar" >

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