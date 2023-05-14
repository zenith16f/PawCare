/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_bd;

// Imports
import java.sql.*;
import javax.servlet.ServletContext;

/**
 *
 * @author Zenith
 */
public class BDConnection {

    private static Connection connection;

    // Definimos al constructor de la clase
    private BDConnection() {

    }

    public static Connection getConnection(ServletContext context) {
        if (connection == null) {
            try {
                String url = context.getInitParameter("http//localhost");
                String user = context.getInitParameter("root");
                String password = context.getInitParameter("ZrFj16GC06#Ag");

                // Definimos el driver de MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(url, user, password);

            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("No conecto a la BD");
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        return connection;
    }

}
