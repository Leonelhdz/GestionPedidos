package com.example.reto2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación que extiende la clase Application de JavaFX.
 */
public class HelloApplication extends Application {
    private static Stage myStage;

    /**
     * Clase principal de la aplicación que extiende la clase Application de JavaFX.
     *
     * @param fxml the fxml
     * @throws IOException the io exception
     */
    public static void volver(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 560, 407);
        myStage.setTitle("LOGIN");
        myStage.setScene(scene);
        myStage.show();
    }

    /**
     * Retro.
     *
     * @param fxml the fxml
     * @throws IOException the io exception
     */
    public static void retro(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ventanaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 641);
        myStage.setTitle("LISTA DE PEDIDOS");
        myStage.setScene(scene);
        myStage.show();
    }


    /**
     * Cambia la escena a una vista específica.
     *
     * @param fxml El nombre del archivo FXML de la vista a la que se desea cambiar.
     */
    public static void ventanaDos(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), 600, 641);
            myStage.setScene(scene);
            myStage.setTitle("LISTA DE PEDIDOS");
        } catch (IOException e) {
            System.out.println("Error al cargar el FXML");
            throw new RuntimeException(e);
        }
    }

    /**
     * Cambia la escena a una vista específica.
     *
     * @param fxml El nombre del archivo FXML de la vista a la que se desea cambiar.
     */
    public static void ventanaTres(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader((HelloApplication.class.getResource(fxml)));
            Scene scene = new Scene(fxmlLoader.load(), 600, 641);
            myStage.setScene(scene);
            myStage.setTitle("DETALLE DE PEDIDOS");
        } catch (IOException e) {
            System.out.println("Error al cargar FXML");
            throw new RuntimeException(e);
        }
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        myStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 560, 407);
        stage.setTitle("GESTION DE PEDIDOS");
        stage.setScene(scene);
        stage.show();

    }

}