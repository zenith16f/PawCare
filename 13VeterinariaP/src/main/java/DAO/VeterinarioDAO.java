package DAO;

import Model.Veterinario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioDAO {

    private Connection connection;

    private PreparedStatement insertStatement, updateStatement,
            selectAllStatement, selectByIdStatement,
            selectLoginStatement, deleteByIdStatement;

    private final String selectLogin = "SELECT * FROM veterinario WHERE correo = ?";

    public VeterinarioDAO(Connection connection) {
        this.connection = connection;
        try {
            this.insertStatement = connection.prepareStatement(
                    "INSERT INTO veterinario (cedula, especialidad, nombre, correo, telefono, password) VALUES (?, ?, ?, ?, ?, ?)");
            this.updateStatement = connection.prepareStatement(
                    "UPDATE veterinario SET especialidad = ?, nombre = ?, correo = ?, telefono = ?, password = ? WHERE cedula = ?");
            this.deleteByIdStatement = connection.prepareStatement(
                    "DELETE FROM veterinario WHERE cedula = ?");
            this.selectAllStatement = connection.prepareStatement(
                    "SELECT * FROM veterinario");
            this.selectByIdStatement = connection.prepareStatement(
                    "SELECT * FROM veterinario WHERE cedula = ?");
            this.selectLoginStatement = connection.prepareStatement(selectLogin);
        } catch (SQLException e) {
            System.out.println("Error en el CRUD de VeterinarioDAO: " + e.getMessage());
        }
    }

    public void insertarVeterinario(Veterinario veterinario) throws SQLException {
        insertStatement.setInt(1, veterinario.getCedula());
        insertStatement.setString(2, veterinario.getEspecialidad());
        insertStatement.setString(3, veterinario.getNombre());
        insertStatement.setString(4, veterinario.getCorreo());
        insertStatement.setString(5, veterinario.getTelefono());
        insertStatement.setString(6, veterinario.getContraseña());
        insertStatement.executeUpdate();
    }

    public Veterinario obtenerVeterinarioPorCedula(int cedula) throws SQLException {
        Veterinario veterinario = null;
        selectByIdStatement.setInt(1, cedula);
        try (ResultSet resultSet = selectByIdStatement.executeQuery()) {
            if (resultSet.next()) {
                veterinario = mapearVeterinario(resultSet);
            }
        }
        return veterinario;
    }

    public List<Veterinario> obtenerTodosLosVeterinarios() throws SQLException {
        List<Veterinario> veterinarios = new ArrayList<>();
        try (ResultSet resultSet = selectAllStatement.executeQuery()) {
            while (resultSet.next()) {
                Veterinario veterinario = mapearVeterinario(resultSet);
                veterinarios.add(veterinario);
            }
        }
        return veterinarios;
    }

    private Veterinario mapearVeterinario(ResultSet resultSet) throws SQLException {
        int cedula = resultSet.getInt("cedula");
        String especialidad = resultSet.getString("especialidad");
        String nombre = resultSet.getString("nombre");
        String correo = resultSet.getString("correo");
        String telefono = resultSet.getString("telefono");
        String contraseña = resultSet.getString("password");
        return new Veterinario(cedula, especialidad, nombre, correo, telefono, contraseña);
    }

    public void actualizarVeterinario(Veterinario veterinario) throws SQLException {
        updateStatement.setString(1, veterinario.getEspecialidad());
        updateStatement.setString(2, veterinario.getNombre());
        updateStatement.setString(3, veterinario.getCorreo());
        updateStatement.setString(4, veterinario.getTelefono());
        updateStatement.setString(5, veterinario.getContraseña());
        updateStatement.setInt(6, veterinario.getCedula());
        updateStatement.executeUpdate();
    }

    public boolean eliminarVeterinario(int cedula) throws SQLException {
        deleteByIdStatement.setInt(1, cedula);
        return deleteByIdStatement.executeUpdate() > 0;
    }

    public Veterinario login(Veterinario veterinario) throws SQLException {
        selectLoginStatement.setString(1, veterinario.getCorreo());
        ResultSet rs = selectLoginStatement.executeQuery();

        if (rs.next() && rs.getString("password") != null) {
            veterinario.getContraseña();
            rs.getString("password");

            System.out.println("¡Funciona!");

            Veterinario veterinarioLogin = new Veterinario(
                    rs.getInt("cedula"),
                    rs.getString("especialidad"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("telefono"),
                    rs.getString("password")
            );

            return veterinarioLogin;
        }
        return null;
    }
}
