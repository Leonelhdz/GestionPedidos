package com.example.reto2.doamin;

import com.example.reto2.HelloApplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Clase que gestiona la conexión a la base de datos utilizando configuraciones de un archivo properties.
 */
public class DBConnection {
    private static final Connection connection;

    private static Logger logger;

    static {
        logger = Logger.getLogger(DBConnection.class.getName());

        String url;
        String user;
        String password;

        var cfg = new Properties();

        try {
            // Cargando la configuración desde el archivo ddbb.properties
            cfg.load(HelloApplication.class.getClassLoader().getResourceAsStream("ddbb.properties"));
            logger.info("CONFIGURACION CARGADA");
            url = "jdbc:mysql://" + cfg.getProperty("host") + ":" + cfg.getProperty("port") + "/" + cfg.getProperty("dbname");
            logger.info(url);
            user = cfg.getProperty("user");
            password = cfg.getProperty("pass");

        } catch (IOException e) {
            logger.severe("ERROR PROCESANDO CONFIGURACIÓN");
            throw new RuntimeException(e);
        }

        try {
            // Estableciendo la conexión con la base de datos
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

