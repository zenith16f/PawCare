/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Model.Veterinario;
import DAO.BDConnection;
import DAO.VeterinarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 980030870
 */
public class crearVeterinario extends HttpServlet {

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

        String token = "";
        token = request.getParameter("token");

        // Comprobation
        if (token.equals("Tj6y4P$o")) {
            try (PrintWriter out = response.getWriter()) {
                // Primero se obtiene la conexión
                Connection conexion = BDConnection.getConnection(request.getServletContext());

                String cedula = request.getParameter("cedula");
                VeterinarioDAO veterinarioDAO = new VeterinarioDAO(conexion);

                Veterinario veterinario = new Veterinario(
                        Integer.parseInt(cedula),
                        request.getParameter("especialidad"),
                        request.getParameter("nombre"),
                        request.getParameter("correo"),
                        request.getParameter("telefono"),
                        request.getParameter("password")
                );

                try {
                    veterinarioDAO.insertarVeterinario(veterinario);
                    System.out.println("Veterinario agregado");
                    response.sendRedirect("vetLogin.jsp");
                } catch (SQLException e) {
                    System.out.println("Error al registrar al veterinario: " + e.getMessage());
                    response.sendRedirect("error.jsp");
                }
            }
        } else {
            System.out.println("no se pudo realizar el registro porque el token no es valido");
            response.sendRedirect("vetRegistro.html");

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
