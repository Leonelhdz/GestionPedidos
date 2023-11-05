package com.example.reto2.Item;

import java.util.ArrayList;

/**
 * Interfaz que define métodos para operaciones relacionadas con los ítems de pedidos.
 */
public interface ItemDAO {
    /**
     * Obtiene todos los ítems de un pedido específico.
     *
     * @param pedidoid El ID del pedido para el cual se obtendrán los ítems.
     * @return Una lista de objetos ItemPedido que representan los ítems del pedido.
     */
    ArrayList<ItemPedido> obtenerTodos(String pedidoid);

}
