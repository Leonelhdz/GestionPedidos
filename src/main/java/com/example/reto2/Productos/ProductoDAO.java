package com.example.reto2.Productos;

/**
 * Interfaz que define métodos para operaciones relacionadas con productos.
 */
public interface ProductoDAO {
    /**
     * Carga un producto basado en un ID de usuario.
     *
     * @param userid El ID del usuario para el cual se carga el producto.
     * @return Un objeto Producto que representa el producto cargado.
     */
    public Producto cargarproductos(Long userid);
}
