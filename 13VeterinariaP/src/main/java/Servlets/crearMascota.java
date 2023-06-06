/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Model.Mascota;
import DAO.BDConnection;
import DAO.MascotaDAO;
import Model.Propietario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fer_1
 */
public class crearMascota extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombre = request.getParameter("nombre");
        String sexo = request.getParameter("sexo");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String pelaje = request.getParameter("pelaje");
        String senasParticulares = request.getParameter("senas");
        String idRazaParam = request.getParameter("raza");
        String idEspecieParam = request.getParameter("especie");

        // Validar el formato de fecha y hora (yyyy-mm-dd)
        boolean formatoCorrecto = fechaNacimiento.matches("\\d{4}-\\d{2}-\\d{2}");
        if (!formatoCorrecto) {
            // Manejar el error de formato de fecha
            response.sendRedirect("propias.jsp");
            return;
        }

        // Convertir la fecha de nacimiento a un objeto Timestamp
        Timestamp nacimiento = Timestamp.valueOf(fechaNacimiento + " 00:00:00");

        ServletContext context = request.getServletContext();
        Connection connection = BDConnection.getConnection(context);

        try {
            // Obtener el propietario de la sesión activa
            Propietario propietario = (Propietario) request.getSession().getAttribute("propietario");

            // Verificar si el propietario es nulo o no
            if (propietario == null) {
                // Manejar el caso en que no haya propietario en la sesión
                response.sendRedirect("login.jsp");
                return;
            }

            // Obtener el idPropietario de la cuenta del usuario activo
            int idPropietario = propietario.getId_propietario();

            // Convertir los parámetros a enteros
            int idRaza = 0;
            int idEspecie = 0;

            try {
                if (idRazaParam != null) {
                    idRaza = Integer.parseInt(idRazaParam);
                }
                if (idEspecieParam != null) {
                    idEspecie = Integer.parseInt(idEspecieParam);
                }
            } catch (NumberFormatException e) {
                // Manejar la excepción o mostrar un mensaje de error apropiado
                e.printStackTrace();
            }

            MascotaDAO mascotaDAO = new MascotaDAO(connection);
            Mascota mascota = new Mascota(nombre, sexo, nacimiento, pelaje, senasParticulares, idPropietario, idRaza, idEspecie);
            mascotaDAO.crearMascota(mascota);
            response.sendRedirect("propias.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } finally {
            BDConnection.close(connection);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
