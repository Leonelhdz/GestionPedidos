package com.example.reto2;

import com.example.reto2.Item.ItemPedido;
import com.example.reto2.Pedido.Pedido;

import java.util.ArrayList;

/**
 * Clase que almacena información de sesión, como el pedido actual y la lista de pedidos e items.
 */
public class Session {

    private static Integer pos = null;

    private static Pedido pedido;

    private static ArrayList<Pedido> pedidos = new ArrayList<>();

    private static ArrayList<ItemPedido> items = new ArrayList<>();

    /**
     * Gets pos.
     *
     * @return the pos
     */
    public static Integer getPos() {
        return pos;
    }

    /**
     * Sets pos.
     *
     * @param pos the pos
     */
    public static void setPos(Integer pos) {
        Session.pos = pos;
    }

    /**
     * Gets pedido.
     *
     * @return the pedido
     */
    public static Pedido getPedido() {
        return pedido;
    }

    /**
     * Sets pedido.
     *
     * @param pedido the pedido
     */
    public static void setPedido(Pedido pedido) {
        Session.pedido = pedido;
    }

    /**
     * Gets pedidos.
     *
     * @return the pedidos
     */
    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Sets pedidos.
     *
     * @param pedidos the pedidos
     */
    public static void setPedidos(ArrayList<Pedido> pedidos) {
        Session.pedidos = pedidos;
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public static ArrayList<ItemPedido> getItems() {
        return items;
    }

    /**
     * Sets items.
     *
     * @param items the items
     */
    public static void setItems(ArrayList<ItemPedido> items) {
        Session.items = items;
    }
}
