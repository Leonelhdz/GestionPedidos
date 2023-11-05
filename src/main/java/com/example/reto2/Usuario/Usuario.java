package com.example.reto2.Usuario;

import lombok.Data;

import java.io.Serializable;

/**
 * Clase que representa un usuario en la aplicación.
 */
@Data
public class Usuario implements Serializable {
    private Long id;
    private String nombre;
    private String contrasena;
    private String email;
}
