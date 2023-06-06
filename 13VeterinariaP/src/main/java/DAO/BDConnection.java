/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author alumno
 */
import java.sql.*;
import javax.servlet.ServletContext;

public class BDConnection {

    public static Connection getConnection(ServletContext context) {
        String url, username, password, driver;

        url = "jdbc:mysql://localhost:3306/veterinaria";//puerto url 8085
        //url = "jdbc:mysql://localhost:3308/ivi";
        username = "root";
        //password = "n0m3l0";
        password = "ZrFj16GC06#Ag";
        Connection con = null;

        //try {
        //    driver = "com.mysql.cj.jdbc.Driver";
        //    Class.forName(driver);
        //    con = DriverManager.getConnection(url, username, password);
        //    System.out.println("Conexion exitosa con la DB");
        //
        //} catch (Exception ex) {
        //    System.out.println("Error al conectar la BD");
        //    System.out.println("Error: " + ex.getLocalizedMessage());
        //}
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                System.out.println("Connecting database [" + con + "] OK");
            }
        } catch (SQLException e) {
            System.out.println("Exception conexion: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Exception driver: " + e.getMessage());
        }
        return con;
    }

    public static void close(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }

    public static void close(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar el PreparedStatement: " + ex.getMessage());
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar el ResultSet: " + ex.getMessage());
        }
    }
}
