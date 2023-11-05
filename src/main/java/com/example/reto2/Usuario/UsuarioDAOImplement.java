package com.example.reto2.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementación de la interfaz UsuarioDAO para operaciones relacionadas con usuarios en una base de datos.
 */
public class UsuarioDAOImplement implements UsuarioDAO {

    private static final String QUERY_USER_PASS = "SELECT * FROM usuarios WHERE nombre = ? AND contraseña = ?";
    private static final String QUERY_NOMBRE_EMAIL = "SELECT nombre, email FROM usuarios WHERE id = ?";
    private Connection connection;

    /**
     * Constructor de la clase UsuarioDAOImplement.
     *
     * @param connection La conexión a la base de datos.
     */
    public UsuarioDAOImplement(Connection connection) {
        this.connection = connection;
    }
    /**
     * Carga un usuario basado en un nombre de usuario y una contraseña.
     *
     * @param user El nombre de usuario.
     * @param pass La contraseña del usuario.
     * @return Un objeto Usuario que representa el usuario cargado.
     */
    @Override
    public Usuario load(String user, String pass) {
        Usuario usuario = null;
        try (PreparedStatement statement = connection.prepareStatement(QUERY_USER_PASS)) {
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId(resultSet.getLong("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setContrasena(resultSet.getString("contraseña"));
                usuario.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    /**
     * Obtiene un usuario basado en su ID.
     *
     * @param userId El ID del usuario.
     * @return Un objeto Usuario que representa el usuario obtenido.
     */
    @Override
    public Usuario obtenerUsuarioPorId(Long userId) {
        Usuario usuario = null;
        try (PreparedStatement statement = connection.prepareStatement(QUERY_NOMBRE_EMAIL)) {
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
