/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access_bd;

import Modelo.Mascota;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zenith
 */
public class MascotaDAO {

    private Connection connection;

    private PreparedStatement insertStatement, updateStatement, selectAllStatement, selectByIDStatement;

    private final String insertQuery
            = "INSERT INTO mascota (propietario_id, raza_id, nacimiento, nombre, imagen, tamano, sexo, peso)"
            + "values(?, ?, ?, ?, ?, ?, ?, ?)";

    private final String updateQuery
            = "UPDATE mascota SET propietario_id = ?, raza_id = ?, nacimiento = ?, nombre = ?, imagen = ?, tamano = ?,"
            + "sexo = ?, peso = ? WHERE id = ?";

    private final String selectAllQuery = "SELECT * FROM mascota";

    private final String selectByIDQuery = "SELECT * FROM mascota WHERE id=?";

    public MascotaDAO(Connection connection) {
        this.connection = connection;

        try {

            this.insertStatement = this.connection.prepareStatement(this.insertQuery,
                    Statement.RETURN_GENERATED_KEYS);

            this.updateStatement = this.connection.prepareStatement(this.updateQuery);

            this.selectAllStatement = this.connection.prepareStatement(this.selectAllQuery);

            this.selectByIDStatement = this.connection.prepareStatement(this.selectByIDQuery);
        } catch (Exception e) {
            System.out.println("Error en el CRUD");
            System.out.println("ERROR: " + e.getMessage());

        }

    }

    public Mascota save(Mascota mascota) throws Exception {
        if (mascota.getId() == -1) {
            // Insertar la mascota
            this.insertStatement.setInt(1, mascota.getIdPropietario());
            this.insertStatement.setInt(2, mascota.getIdRaza());
            this.insertStatement.setTimestamp(3, mascota.getNacimiento());
            this.insertStatement.setString(4, mascota.getNombre());
            this.insertStatement.setBlob(5, mascota.getImagen());
            this.insertStatement.setInt(6, mascota.getTamano());
            this.insertStatement.setString(7, mascota.getSexo());
            this.insertStatement.setInt(8, mascota.getPeso());

            int idMascota = this.insertStatement.executeUpdate();

            mascota.setId(idMascota);

            return mascota;
        } else {
            // Actualizar
            this.updateStatement.setInt(1, mascota.getIdPropietario());
            this.updateStatement.setInt(2, mascota.getIdRaza());
            this.updateStatement.setTimestamp(3, mascota.getNacimiento());
            this.updateStatement.setString(4, mascota.getNombre());
            this.updateStatement.setBlob(5, mascota.getImagen());
            this.updateStatement.setInt(6, mascota.getTamano());
            this.updateStatement.setString(7, mascota.getSexo());
            this.updateStatement.setInt(8, mascota.getPeso());
            this.updateStatement.setInt(9, mascota.getId());

            this.updateStatement.executeUpdate();

            return mascota;
        }

    }

    // Consulta
    public List<Mascota> getAll() throws Exception {
        List<Mascota> mascotas = new ArrayList<>();

        ResultSet rs = this.selectAllStatement.executeQuery();

        while (rs.next()) {
            Mascota mascota = new Mascota(
                    rs.getInt("id"),
                    rs.getInt("propietario_id"),
                    rs.getInt("raza_id"),
                    rs.getTimestamp("nacimiento"),
                    rs.getString("nombre"),
                    rs.getBlob("imagen"),
                    rs.getInt("tamano"),
                    rs.getInt("peso"),
                    rs.getString("sexo")
            );

            mascotas.add(mascota);
        }
        return mascotas;
    }

    // Consulta Especifica
    public Mascota getByID(int id) throws Exception {

        this.selectByIDStatement.setInt(1, id);

        ResultSet rs = this.selectByIDStatement.executeQuery();

        if (rs.next()) {
            Mascota mascota = new Mascota(
                    rs.getInt("id"),
                    rs.getInt("propietario_id"),
                    rs.getInt("raza_id"),
                    rs.getTimestamp("nacimiento"),
                    rs.getString("nombre"),
                    rs.getBlob("imagen"),
                    rs.getInt("tamano"),
                    rs.getInt("peso"),
                    rs.getString("sexo")
            );

            return mascota;

        }
        return null;
    }

}
