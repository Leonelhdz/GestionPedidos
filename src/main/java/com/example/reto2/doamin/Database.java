package com.example.reto2.doamin;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Clase que gestiona la conexión a la base de datos.
 */
public class Database {

    private static Connection connection;
    private static Logger logger;

    static {
        logger = Logger.getLogger(Database.class.getName());

        // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3307/gestionpedidos";
        String user = "";
        String password = "";
        try {
            // Establece la conexión con la base de datos
            connection = DriverManager.getConnection(url, user, password);
            logger.info("Successful connection to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Obtiene la conexión activa a la base de datos.
     *
     * @return La conexión a la base de datos.
     */
    public static Connection getConnection() {
        return connection;
    }

}

