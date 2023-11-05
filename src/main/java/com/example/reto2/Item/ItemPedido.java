package com.example.reto2.Item;

import com.example.reto2.Productos.Producto;
import lombok.Data;

/**
 * Clase que representa un ítem de un pedido.
 */
@Data
public class ItemPedido {
    private Long id;
    private String codigoPedido;
    private int cantidad;
    private Producto productoId;
}
