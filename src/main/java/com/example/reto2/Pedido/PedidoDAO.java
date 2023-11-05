package com.example.reto2.Pedido;

import java.util.List;

/**
 * Interfaz que define métodos para operaciones relacionadas con los pedidos.
 */
public interface PedidoDAO {
    /**
     * Obtiene una lista de pedidos realizados por un usuario específico.
     *
     * @param idUsuario El ID del usuario para el cual se obtendrán los pedidos.
     * @return Una lista de objetos Pedido que representan los pedidos del usuario.
     */
    List<Pedido> obtenerPedidos(Long idUsuario);


}
