/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DAO.BDConnection;
import DAO.PropietarioDAO;
import Model.Propietario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fer_1
 */
public class editarPropietario extends HttpServlet {

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

            Propietario propietario = (Propietario) request.getSession().getAttribute("propietario");

            if (propietario == null) {
                // Manejar el caso en que no haya propietario en la sesión
                response.sendRedirect("login.jsp");
                return;
            }

            int id = propietario.getId_propietario();

            PropietarioDAO propietarioDao = new PropietarioDAO(conexion, request.getServletContext());

            Propietario editado = new Propietario(
                    id,
                    request.getParameter("correo"),
                    request.getParameter("nombre"),
                    request.getParameter("appat"),
                    request.getParameter("apmat"),
                    request.getParameter("dir"),
                    request.getParameter("password")
            );

            try {
                propietarioDao.save(editado);
                System.out.println("Datos del propietario editados");
                response.sendRedirect("login.jsp");

            } catch (Exception ex) {
                System.out.println("Error al editar los datos del propietario");
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
