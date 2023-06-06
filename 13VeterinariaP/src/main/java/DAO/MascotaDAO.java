/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Mascota;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zenith
 */
public class MascotaDAO {

    private Connection connection;

    public MascotaDAO(Connection connection) {
        this.connection = connection;
    }

    public void crearMascota(Mascota mascota) throws SQLException {
        String query = "INSERT INTO Mascota (id_propietario,nombre, sexo, fecha_nacimiento, pelaje, raza, especie,senas_particulares) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, mascota.getIdPropietario());
            statement.setString(2, mascota.getNombre());
            statement.setString(3, mascota.getSexo());
            statement.setTimestamp(4, mascota.getNacimiento());
            statement.setString(5, mascota.getPelaje());
            statement.setInt(6, mascota.getIdRaza());
            statement.setInt(7, mascota.getIdEspecie());
            statement.setString(8, mascota.getSenasParticulares());

            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error al agregar una mascota");
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void actualizarMascota(Mascota mascota) throws SQLException {
        String query = "UPDATE Mascota SET nombre = ?, pelaje = ?, senas_particulares = ? WHERE id_mascota = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, mascota.getNombre());
            statement.setString(2, mascota.getPelaje());
            statement.setString(3, mascota.getSenasParticulares());
            statement.setInt(4, mascota.getId());

            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error al editar los datos de la mascota");
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void eliminarMascota(int mascotaId) throws SQLException {
        String query = "DELETE FROM Mascota WHERE id_mascota = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, mascotaId);
            statement.executeUpdate();
        }
    }

    public Mascota obtenerMascotaPorId(int mascotaId) throws SQLException {
        String query = "SELECT m.id_mascota, m.nombre,m.id_propietario, m.sexo, m.fecha_nacimiento,"
                + " m.pelaje,m.raza,m.especie, r.tipo_raza, e.tipo_especie ,m.senas_particulares \n"
                + "FROM Mascota m\n"
                + "JOIN raza r ON m.raza = r.id_raza \n"
                + "JOIN especie e ON m.especie = e.id_especie \n"
                + "WHERE id_mascota = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, mascotaId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    Mascota mascota = new Mascota();
                    mascota.setId(resultSet.getInt("id_mascota"));
                    mascota.setNombre(resultSet.getString("nombre"));
                    mascota.setSexo(resultSet.getString("sexo"));
                    mascota.setNacimiento(resultSet.getTimestamp("fecha_nacimiento"));
                    mascota.setPelaje(resultSet.getString("pelaje"));
                    mascota.setSenasParticulares(resultSet.getString("senas_particulares"));
                    mascota.setIdPropietario(resultSet.getInt("id_propietario"));
                    mascota.setIdRaza(resultSet.getInt("raza"));
                    mascota.setIdEspecie(resultSet.getInt("especie"));
                    mascota.setTipoEspecie(resultSet.getString("tipo_especie"));
                    mascota.setTipoRaza(resultSet.getString("tipo_raza"));

                    return mascota;
                }
            }
        }

        return null;
    }

    public List<Mascota> obtenerMascotasPorPropietario(int propietarioId) throws SQLException {
        String query = "SELECT m.id_mascota, m.nombre,m.id_propietario, m.sexo, m.fecha_nacimiento,"
                + " m.pelaje,m.raza,m.especie, r.tipo_raza, e.tipo_especie ,m.senas_particulares \n"
                + "             FROM Mascota m\n"
                + "             JOIN raza r ON m.raza = r.id_raza \n"
                + "             JOIN especie e ON m.especie = e.id_especie \n"
                + "             WHERE id_propietario = ?"; // Sentencia inicial para agregar los filtros

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, propietarioId);

            try (ResultSet resultSet = statement.executeQuery()) {
                List<Mascota> mascotas = new ArrayList<>();

                while (resultSet.next()) {

                    mascotas.add(mapearMascota(resultSet));
                }

                return mascotas;
            }
        }
    }

    public List<Mascota> obtenerMascotas() throws SQLException {
        String query = "select \n"
                + "m.*, r.tipo_raza,e.tipo_especie from Mascota m Join raza r on m.raza = r.id_raza\n"
                + "join especie e on m.especie = e.id_especie";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                List<Mascota> mascotas = new ArrayList<>();

                while (rs.next()) {
                    mascotas.add(mapearMascota(rs));
                }
                return mascotas;
            }
        }
    }

    private Mascota mapearMascota(ResultSet resultSet) throws SQLException {
        Mascota mascota = new Mascota();
        mascota.setId(resultSet.getInt("id_mascota"));
        mascota.setNombre(resultSet.getString("nombre"));
        mascota.setSexo(resultSet.getString("sexo"));
        mascota.setNacimiento(resultSet.getTimestamp("fecha_nacimiento"));
        mascota.setPelaje(resultSet.getString("pelaje"));
        mascota.setSenasParticulares(resultSet.getString("senas_particulares"));
        mascota.setIdPropietario(resultSet.getInt("id_propietario"));
        mascota.setIdRaza(resultSet.getInt("raza"));
        mascota.setIdEspecie(resultSet.getInt("especie"));
        mascota.setTipoEspecie(resultSet.getString("tipo_especie"));
        mascota.setTipoRaza(resultSet.getString("tipo_raza"));

        return mascota;
    }

    // Catalogs
    public List<Mascota> getEspecies() throws Exception {
        List<Mascota> especie = new ArrayList<>();

        String sql = "SELECT * FROM especie";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Mascota mascota = new Mascota();

                mascota.setIdEspecie(rs.getInt("id_especie"));
                mascota.setTipoEspecie(rs.getString("tipo_especie"));

                especie.add(mascota);
            }

        }

        return especie;
    }

    public List<Mascota> getRazas() throws Exception {
        List<Mascota> raza = new ArrayList<>();

        String sql = "SELECT * FROM raza";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Mascota mascota = new Mascota();

                mascota.setIdRaza(rs.getInt("id_raza"));
                mascota.setTipoRaza(rs.getString("tipo_raza"));

                raza.add(mascota);
            }

        }

        return raza;
    }
}
