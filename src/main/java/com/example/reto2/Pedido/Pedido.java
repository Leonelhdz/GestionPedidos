package com.example.reto2.Pedido;


import lombok.Data;

import java.sql.Date;

/**
 * Clase que representa un pedido en la aplicación.
 */
@Data
public class Pedido {
    private Long id;
    private String codigo;
    private int Usuario;
    private Date fecha;
    private int total;
}
