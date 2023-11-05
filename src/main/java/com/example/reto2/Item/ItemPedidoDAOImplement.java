package com.example.reto2.Item;

import com.example.reto2.Productos.Producto;
import com.example.reto2.Productos.ProductoDAOImplement;
import com.example.reto2.doamin.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementación de la interfaz ItemDAO para operaciones relacionadas con los ítems de pedidos en una base de datos.
 */
public class ItemPedidoDAOImplement implements ItemDAO {
    private static final String SELECT_ALL_ITEMS_QUERY = "SELECT * FROM itemspedido WHERE codigoPedido = ?";
    private Connection connection;

    /**
     * Constructor de la clase ItemPedidoDAOImplement.
     *
     * @param connection La conexión a la base de datos.
     */
    public ItemPedidoDAOImplement(Connection connection) {
        this.connection = connection;
    }
    /**
     * Obtiene todos los ítems de un pedido específico.
     *
     * @param codpedido El código del pedido para el cual se obtendrán los ítems.
     * @return Una lista de objetos ItemPedido que representan los ítems del pedido.
     */
    @Override
    public ArrayList<ItemPedido> obtenerTodos(String codpedido) {
        ArrayList<ItemPedido> items = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ITEMS_QUERY)) {
            statement.setString(1, codpedido);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ItemPedido itempedido = new ItemPedido();
                itempedido.setId(resultSet.getLong("Id"));
                itempedido.setCodigoPedido(resultSet.getString("CodigoPedido"));
                itempedido.setCantidad(resultSet.getInt("Cantidad"));
                Long productid = resultSet.getLong("productoId");

                ProductoDAOImplement productoDAOImplement = new ProductoDAOImplement(DBConnection.getConnection());
                Producto producto = productoDAOImplement.cargarproductos(productid);
                itempedido.setProductoId(producto);
                items.add(itempedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}