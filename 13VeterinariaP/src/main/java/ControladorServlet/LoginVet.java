/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControladorServlet;

import Model.Veterinario;
import DAO.BDConnection;
import DAO.VeterinarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zentith
 */
public class LoginVet extends HttpServlet {

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
            Connection connection = BDConnection.getConnection(request.getServletContext());

            // Declaro al propietario
            VeterinarioDAO veterinarioDAO = new VeterinarioDAO(connection);

            // Obtener los parametros
            Veterinario veterinario = new Veterinario(
                    request.getParameter("correo"),
                    request.getParameter("password")
            );
            String correo = request.getParameter("correo");
            String password = request.getParameter("password");
            try {

                veterinario = veterinarioDAO.login(veterinario);

                if (veterinario != null) {
                    // Creamos la sesion
                    request.getSession().setAttribute("veterinario", veterinario);

                    response.sendRedirect("inicioVet.jsp");
                } else {
                    response.sendRedirect("vetLogin.jsp");
                }

            } catch (Exception ex) {

                System.out.println("Error al iniciar sesion");
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
