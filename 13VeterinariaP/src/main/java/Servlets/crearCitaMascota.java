/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DAO.BDConnection;
import DAO.CitaDAO;
import Model.Cita;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zenith
 */
public class crearCitaMascota extends HttpServlet {

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

        String nota = request.getParameter("nota");
        String fechaCitaString = request.getParameter("fecha_cita");
        LocalDateTime fechaCita = parseFechaCita(fechaCitaString);
        int idTipoCita = Integer.parseInt(request.getParameter("id_tipo_cita"));
        int idVeterinario = Integer.parseInt(request.getParameter("id_veterinario"));
        int idMascota = Integer.parseInt(request.getParameter("id_mascota"));

        Cita cita = new Cita();
        cita.setNota(nota);
        cita.setFechaCita(Timestamp.valueOf(fechaCita));
        cita.setIdTipoCita(idTipoCita);
        cita.setIdVeterinario(idVeterinario);
        cita.setIdMascota(idMascota);

        ServletContext servletContext = request.getServletContext();
        Connection connection = BDConnection.getConnection(servletContext);

        try {
            CitaDAO citaDAO = new CitaDAO(connection);
            citaDAO.crearCita(cita);
            response.sendRedirect("propias.jsp"); // Redirecciona a la página de citas después de agregar la cita
        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirecciona a una página de error en caso de error en la base de datos
        }
    }

    private LocalDateTime parseFechaCita(String fechaCitaString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaCita = LocalDate.parse(fechaCitaString, formatter);
        return fechaCita.atStartOfDay();
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
