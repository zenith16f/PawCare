/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_bd;

import Modelo.Propietario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;

/**
 *
 * @author Zenith
 */
public class PropietarioDAO {

    private Connection connection;

    private PreparedStatement insertStatement, updateStatement, selectAllStatement, selectByIDStatement,
            selectLoginStatement, deleteByIDStatement;

    private final String insertQuery
            = "INSERT INTO propietario (correo, nombre, appat, apmat, dir, password)"
            + "values(?, ?, ?, ?, ?, ?)";

    private final String updateQuery
            = "UPDATE propietario SET  nombre= ?, appat = ?, apmat = ?, dir = ?"
            + " WHERE propiertario_id = ?";

    private final String selectAllQuery = "SELECT * FROM propietario";

    private final String deleteQuery = "DELETE FROM propietario WHERE propietario_id = ?";

    private final String selectByIDQuery = "SELECT * FROM propietario WHERE propietario_id = ?";

    private final String selectLoginQuery = "SELECT * FROM propietario WHERE correo = ?";

    public PropietarioDAO(Connection connection, ServletContext contexto) {
        this.connection = connection;

        try {

            this.insertStatement = this.connection.prepareStatement(this.insertQuery,
                    Statement.RETURN_GENERATED_KEYS);

            this.updateStatement = this.connection.prepareStatement(this.updateQuery);

            this.deleteByIDStatement = this.connection.prepareStatement(this.deleteQuery);

            this.selectAllStatement = this.connection.prepareStatement(this.selectAllQuery);

            this.selectByIDStatement = this.connection.prepareStatement(this.selectByIDQuery);

            this.selectLoginStatement = this.connection.prepareStatement(this.selectLoginQuery);
        } catch (Exception e) {
            System.out.println("Error en el CRUD");
            System.out.println("ERROR: " + e.getMessage());

        }

    }

    // New / Update
    public Propietario save(Propietario propietario) throws Exception {
        System.out.println(propietario.getIdPropietario());
        if (propietario.getIdPropietario() == -1) {
            // Que se va a hacer para que el password sea seguro

            // Insertar la mascota
            this.insertStatement.setString(1, propietario.getCorreo());
            this.insertStatement.setString(2, propietario.getNombre());
            this.insertStatement.setString(3, propietario.getApellidoPaterno());
            this.insertStatement.setString(4, propietario.getApellidoMaterno());
            this.insertStatement.setString(5, propietario.getDireccion());
            this.insertStatement.setString(6, propietario.getPassword());

            int idPropietario = this.insertStatement.executeUpdate();
            System.out.println("ID del propietaro es: " + idPropietario);

            propietario.setIdPropietario(idPropietario);

            return propietario;
        } else {
            // Actualizar
            this.updateStatement.setString(1, propietario.getNombre());
            this.updateStatement.setString(2, propietario.getApellidoPaterno());
            this.updateStatement.setString(3, propietario.getApellidoMaterno());
            this.updateStatement.setString(4, propietario.getDireccion());
            this.updateStatement.setInt(5, propietario.getIdPropietario());

            this.updateStatement.executeUpdate();

            return propietario;
        }

    }

    // Consulta
    public List<Propietario> getAll() throws Exception {
        List<Propietario> propietarios = new ArrayList<>();

        ResultSet rs = this.selectAllStatement.executeQuery();

        while (rs.next()) {
            Propietario propietario = new Propietario(
                    rs.getInt("propietario_id"),
                    rs.getString("correo"),
                    rs.getString("nombre"),
                    rs.getString("appat"),
                    rs.getString("apmat"),
                    rs.getString("dir"),
                    rs.getString("password")
            );

            propietarios.add(propietario);
        }
        return propietarios;
    }

}
