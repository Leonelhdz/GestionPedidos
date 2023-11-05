package com.example.reto2.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz PedidoDAO para operaciones relacionadas con pedidos en una base de datos.
 */
public class PedidoDAOImplement implements PedidoDAO {
    private static final String QUERY_PEDIDOS = "SELECT * FROM pedidos WHERE Usuario = ?";
    private final Connection connection; // Necesitas una conexión a la base de datos

    /**
     * Constructor de la clase PedidoDAOImplement.
     *
     * @param connection La conexión a la base de datos.
     */
    public PedidoDAOImplement(Connection connection) {
        this.connection = connection;
    }
    /**
     * Obtiene una lista de pedidos realizados por un usuario específico.
     *
     * @param idUsuario El ID del usuario para el cual se obtendrán los pedidos.
     * @return Una lista de objetos Pedido que representan los pedidos del usuario.
     */
    @Override
    public List<Pedido> obtenerPedidos(Long idUsuario) {
        List<Pedido> pedidos = new ArrayList<>();


        try (PreparedStatement statement = connection.prepareStatement(QUERY_PEDIDOS)) {
            statement.setLong(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(resultSet.getLong("id"));
                pedido.setCodigo(resultSet.getString("codigo"));
                pedido.setFecha(resultSet.getDate("fecha"));
                pedido.setUsuario(resultSet.getInt("Usuario"));
                pedido.setTotal(resultSet.getInt("total"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }
}
