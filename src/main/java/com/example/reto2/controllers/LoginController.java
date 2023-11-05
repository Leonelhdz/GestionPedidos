package com.example.reto2.controllers;

import com.example.reto2.HelloApplication;
import com.example.reto2.Usuario.Usuario;
import com.example.reto2.Usuario.UsuarioDAO;
import com.example.reto2.Usuario.UsuarioDAOImplement;
import com.example.reto2.doamin.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador para la pantalla de inicio de sesión.
 */
public class LoginController implements Initializable {

    @FXML
    private TextField nombreUsuarioField;
    @FXML
    private Button buttonIngresar;
    @FXML
    private Button buttonCancelar;
    @FXML
    private PasswordField contrasenaField;
    @FXML
    private Label infoLabel;
    /**
     * Inicializa el controlador al cargar la vista.
     *
     * @param url             La ubicación relativa del archivo FXML.
     * @param resourceBundle  Recursos específicos del usuario.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contrasenaField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // Simula el clic en el botón de inicio de sesión.
                buttonIngresar.fire();
            }
        });

    }

    /**
     * Maneja el evento cuando se presiona el botón "Cancelar".
     *
     * @param event El evento de acción.
     */
    @FXML
    public void buttonCancelarOnAction(ActionEvent event) {
        Stage stage = (Stage) buttonCancelar.getScene().getWindow();
        //stage.setMaximized(true);
        stage.close();
    }

    /**
     * Maneja el evento cuando se presiona el botón "Ingresar".
     *
     * @param actionEvent El evento de acción.
     */
    @FXML
    public void buttonIngresarOnAction(ActionEvent actionEvent) {
        String user = nombreUsuarioField.getText();
        String pass = contrasenaField.getText();

        Usuario usuariovalido = validarUsuario(user, pass);
        if (usuariovalido != null) {
            VentanaPrincipalController.usuarioid(usuariovalido.getId());
            HelloApplication.ventanaDos("ventanaPrincipal.fxml");
        } else {
            infoLabel.setText("Usuario no existe");
            nombreUsuarioField.setText("");
            contrasenaField.setText("");
        }
    }
    /**
     * Valida el usuario en función del nombre de usuario y la contraseña proporcionados.
     *
     * @param user  El nombre de usuario.
     * @param pass  La contraseña.
     * @return     El objeto Usuario válido, o null si no se encuentra.
     */
    private Usuario validarUsuario(String user, String pass) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImplement(DBConnection.getConnection());
        return usuarioDAO.load(user, pass);
    }
}
