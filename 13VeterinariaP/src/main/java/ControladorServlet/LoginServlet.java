/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ControladorServlet;

import Model.Propietario;
import DAO.BDConnection;
import DAO.PropietarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
public class LoginServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            //primero la conexion
            Connection conexion
                    = BDConnection.getConnection(
                            request.getServletContext());
            //la instancia del propietario y sus accesos
            PropietarioDAO propietarioDAO
                    = new PropietarioDAO(conexion,
                            request.getServletContext());
            Propietario propietario = new Propietario(
                    request.getParameter("correo"),
                    request.getParameter("password")
            );

            String correo = request.getParameter("correo");
            String password = request.getParameter("password");

            try {
                propietario = propietarioDAO.login(propietario);
                if (propietario != null) {
                    //creo la sesion
                    request.getSession().setAttribute(
                            "propietario", propietario);
                    response.sendRedirect("inicio.jsp");
                } else {
                    response.sendRedirect("login.jsp");
                }
            } catch (Exception e) {
                System.out.println("Error al iniciar la sesion : "
                        + e.getMessage());
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

        //primero establecemos la conexion con bd
        Connection connection = BDConnection.getConnection(
                request.getServletContext());
        //declaro al propietario
        PropietarioDAO propietariodao = new PropietarioDAO(connection,
                request.getServletContext());

        //obtener los parametros
        Propietario propietario = new Propietario(
                request.getParameter("correo"),
                request.getParameter("password")
        );

        //ya que obtenemos los parametro debemos verificar si existe
        //dicho usuario
        try {
            propietario = propietariodao.login(propietario);
            if (propietario != null) {
                //genero la sesion
                request.getSession().setAttribute(
                        "propietario", propietario);
                response.sendRedirect("inicio.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

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
