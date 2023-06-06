/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zenith
 */
public class CitaDAO {

    private Connection connection;

    public CitaDAO(Connection connection) {
        this.connection = connection;
    }

    public void crearCita(Cita cita) throws SQLException {
        String query = "INSERT INTO cita (nota, fecha_cita, id_tipo_cita, id_veterinario, id_mascota) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cita.getNota());
            statement.setTimestamp(2, cita.getFechaCita());
            statement.setInt(3, cita.getIdTipoCita());
            statement.setInt(4, cita.getIdVeterinario());
            statement.setInt(5, cita.getIdMascota());

            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error al agendar la cita");
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void actualizarCita(Cita cita) throws SQLException {
        String query = "UPDATE cita SET talla = ?, diagnostico = ?, temp = ?, tratamiento=? WHERE id_cita = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cita.getTalla());
            statement.setString(2, cita.getDiagnostico());
            statement.setInt(3, cita.getTemperatura());
            statement.setString(4, cita.getTratamiento());
            statement.setInt(5, cita.getId());

            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error al actualizar la cita");
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void eliminarCita(int citaId) throws SQLException {
        String query = "DELETE FROM cita WHERE id_cita = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, citaId);
            statement.executeUpdate();
        }
    }

    public Cita obtenerCitaPorId(int citaId) throws SQLException {
        String query = "select \n"
                + "c.*,t.tipo_cita,m.nombre\n"
                + "from cita c join tipo_cita t on c.id_tipo_cita= t.id_tipo_cita\n"
                + "join mascota m on c.id_mascota = m.id_mascota where id_cita=? ";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, citaId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapearCita(resultSet);
                }
            }
        }

        return null;
    }

    public List<Cita> obtenerCitaPorVeterinarios(int idVeterinario) throws SQLException {
        String query = "select \n"
                + "c.*,t.tipo_cita,m.nombre\n"
                + "from cita c join tipo_cita t on c.id_tipo_cita= t.id_tipo_cita\n"
                + "join mascota m on c.id_mascota = m.id_mascota where id_veterinario=? ";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idVeterinario);
            try (ResultSet resultSet = ps.executeQuery()) {
                List<Cita> citas = new ArrayList<>();

                while (resultSet.next()) {

                    Cita cita = new Cita();
                    cita.setId(resultSet.getInt("id_cita"));
                    cita.setNota(resultSet.getString("nota"));
                    cita.setTalla(resultSet.getInt("talla"));
                    cita.setFechaCita(resultSet.getTimestamp("fecha_cita"));
                    cita.setDiagnostico(resultSet.getString("diagnostico"));
                    cita.setTemperatura(resultSet.getInt("temp"));
                    cita.setIdTipoCita(resultSet.getInt("id_tipo_cita"));
                    cita.setTratamiento(resultSet.getString("tratamiento"));
                    cita.setIdVacuna(resultSet.getInt("id_vacuna"));
                    cita.setIdVeterinario(resultSet.getInt("id_veterinario"));
                    cita.setIdMascota(resultSet.getInt("id_mascota"));
                    cita.setIdExpediente(resultSet.getInt("id_expediente"));
                    cita.setDescripcionTipo(resultSet.getString("tipo_cita"));
                    cita.setNombreMascota(resultSet.getString("nombre"));

                    citas.add(cita);
                }
                return citas;
            }
        }
    }

    public List<Cita> obtenerCitasPorMascota(int mascotaId) throws SQLException {
        String query = "select \n"
                + "c.*,t.tipo_cita,v.nombre\n"
                + "from cita c join tipo_cita t on c.id_tipo_cita= t.id_tipo_cita\n"
                + "join veterinario v on c.id_veterinario=v.cedula\n"
                + "where id_mascota=?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, mascotaId);

            try (ResultSet resultSet = statement.executeQuery()) {
                List<Cita> citas = new ArrayList<>();

                while (resultSet.next()) {
                    Cita cita = new Cita();
                    cita.setId(resultSet.getInt("id_cita"));
                    cita.setNota(resultSet.getString("nota"));
                    cita.setTalla(resultSet.getInt("talla"));
                    cita.setFechaCita(resultSet.getTimestamp("fecha_cita"));
                    cita.setDiagnostico(resultSet.getString("diagnostico"));
                    cita.setTemperatura(resultSet.getInt("temp"));
                    cita.setIdTipoCita(resultSet.getInt("id_tipo_cita"));
                    cita.setTratamiento(resultSet.getString("tratamiento"));
                    cita.setIdVacuna(resultSet.getInt("id_vacuna"));
                    cita.setIdVeterinario(resultSet.getInt("id_veterinario"));
                    cita.setIdMascota(resultSet.getInt("id_mascota"));
                    cita.setIdExpediente(resultSet.getInt("id_expediente"));
                    cita.setDescripcionTipo(resultSet.getString("tipo_cita"));
                    cita.setNombreVeterinario(resultSet.getString("nombre"));

                    citas.add(cita);
                }

                return citas;
            }
        }
    }

    private Cita mapearCita(ResultSet resultSet) throws SQLException {
        Cita cita = new Cita();
        cita.setId(resultSet.getInt("id_cita"));
        cita.setNota(resultSet.getString("nota"));
        cita.setTalla(resultSet.getInt("talla"));
        cita.setFechaCita(resultSet.getTimestamp("fecha_cita"));
        cita.setDiagnostico(resultSet.getString("diagnostico"));
        cita.setTemperatura(resultSet.getInt("temp"));
        cita.setIdTipoCita(resultSet.getInt("id_tipo_cita"));
        cita.setTratamiento(resultSet.getString("tratamiento"));
        cita.setIdVacuna(resultSet.getInt("id_vacuna"));
        cita.setIdVeterinario(resultSet.getInt("id_veterinario"));
        cita.setIdMascota(resultSet.getInt("id_mascota"));
        cita.setIdExpediente(resultSet.getInt("id_expediente"));
        cita.setDescripcionTipo(resultSet.getString("tipo_cita"));
        cita.setNombreMascota(resultSet.getString("nombre"));

        return cita;
    }

    public List<Cita> getTipoCitas() throws Exception {

        List<Cita> tipos = new ArrayList<>();

        String sql = "SELECT * FROM tipo_cita";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();

                cita.setIdTipoCita(rs.getInt("id_tipo_cita"));
                cita.setDescripcionTipo(rs.getString("tipo_cita"));

                tipos.add(cita);
            }

        } catch (Exception ex) {
            System.out.println("Error al obtener los tipos de citas");
            System.out.println("ERROR: " + ex.getMessage());
        }
        return tipos;

    }
}
