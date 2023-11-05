package com.example.reto2.Usuario;

/**
 * Interfaz que define métodos para operaciones relacionadas con usuarios.
 */
public interface UsuarioDAO {
    /**
     * Carga un usuario basado en un nombre de usuario y una contraseña.
     *
     * @param user El nombre de usuario.
     * @param pass La contraseña del usuario.
     * @return Un objeto Usuario que representa el usuario cargado.
     */
    public Usuario load(String user, String pass);

    /**
     * Obtiene un usuario basado en su ID.
     *
     * @param userId El ID del usuario.
     * @return Un objeto Usuario que representa el usuario obtenido.
     */
    public Usuario obtenerUsuarioPorId(Long userId);


}
