/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DAO.BDConnection;
import DAO.VeterinarioDAO;
import Model.Veterinario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zenith
 */
public class editarVeterinario extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            Connection conexion = BDConnection.getConnection(request.getServletContext());

            Veterinario veterinario = (Veterinario) request.getSession().getAttribute("veterinario");

            if (veterinario == null) {
                // Manejar el caso en que no haya propietario en la sesión
                response.sendRedirect("vetLogin.jsp");
                return;
            }

            int cedula = veterinario.getCedula();

            VeterinarioDAO veterinarioDao = new VeterinarioDAO(conexion);

            Veterinario editar = new Veterinario(
                    cedula,
                    request.getParameter("especialidad"),
                    request.getParameter("nombre"),
                    request.getParameter("correo"),
                    request.getParameter("telefono"),
                    request.getParameter("password")
            );

            try {

                veterinarioDao.actualizarVeterinario(editar);
                System.out.println("Datos del veterinario editados");
                response.sendRedirect("vetLogin.jsp");

            } catch (Exception ex) {
                System.out.println("Error al editar los datos del veterinario");
                System.out.println("ERROR: " + ex.getMessage());
            }
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
