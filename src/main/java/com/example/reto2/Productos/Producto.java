package com.example.reto2.Productos;

import lombok.Data;

/**
 * Clase que representa un producto en la aplicación.
 */
@Data
public class Producto {
    private Long id;
    private String NombreProducto;
    private double Precio;
}
