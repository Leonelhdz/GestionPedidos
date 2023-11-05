package com.example.reto2.Productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementación de la interfaz ProductoDAO para operaciones relacionadas con productos en una base de datos.
 */
public class ProductoDAOImplement implements ProductoDAO {

    private static final String QUERY_LOAD = "SELECT * FROM Productos WHERE Id = ?";
    private Connection connection;

    /**
     * Constructor de la clase ProductoDAOImplement.
     *
     * @param connection La conexión a la base de datos.
     */
    public ProductoDAOImplement(Connection connection) {
        this.connection = connection;
    }
    /**
     * Carga un producto basado en un ID de usuario.
     *
     * @param userid El ID del usuario para el cual se carga el producto.
     * @return Un objeto Producto que representa el producto cargado.
     */
    @Override
    public Producto cargarproductos(Long userid) {
        Producto producto = null;

        try (PreparedStatement statement = connection.prepareStatement(QUERY_LOAD)) {
            statement.setLong(1, userid);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                producto = new Producto();
                producto.setId(resultSet.getLong("id"));
                producto.setNombreProducto(resultSet.getString("NombreProducto"));
                producto.setPrecio(resultSet.getDouble("Precio"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producto;
    }
}
