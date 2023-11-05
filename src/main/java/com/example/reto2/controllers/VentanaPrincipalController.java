package com.example.reto2.controllers;

import com.example.reto2.HelloApplication;
import com.example.reto2.Pedido.Pedido;
import com.example.reto2.Pedido.PedidoDAO;
import com.example.reto2.Pedido.PedidoDAOImplement;
import com.example.reto2.Session;
import com.example.reto2.Usuario.Usuario;
import com.example.reto2.Usuario.UsuarioDAO;
import com.example.reto2.Usuario.UsuarioDAOImplement;
import com.example.reto2.doamin.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Controlador para la ventana principal de la aplicación.
 */
public class VentanaPrincipalController implements Initializable {

    private static Long idUsuario;
    private static Long userid;
    @javafx.fxml.FXML
    private Button buttonSalir;
    @javafx.fxml.FXML
    private Label usuarionameLabel;
    @javafx.fxml.FXML
    private Label usuariomailLabel;
    @javafx.fxml.FXML
    private TableColumn columnId;
    @javafx.fxml.FXML
    private TableColumn columnCodigo;
    @javafx.fxml.FXML
    private TableColumn columnFecha;
    @javafx.fxml.FXML
    private TableColumn columnUsuario;
    @javafx.fxml.FXML
    private TableColumn columnTotal;
    @javafx.fxml.FXML
    private TableView<Pedido> tableLista;
    private PedidoDAO productodao; //traer el dao pedido

    /**
     * Establece el ID de usuario.
     *
     * @param id El ID del usuario.
     */
    public static void usuarioid(Long id) {
        VentanaPrincipalController.userid = id;
    }

    /**
     * Logout.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @javafx.fxml.FXML
    public void logout(ActionEvent actionEvent) throws IOException {
        HelloApplication.volver("login-view.fxml");
    }

    /**
     * Inicializa la ventana principal.
     *
     * @param url             La ubicación relativa del archivo FXML.
     * @param resourceBundle  Recursos específicos del usuario.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicializa el DAO de pedidos
        PedidoDAO pedidoDAO = new PedidoDAOImplement(DBConnection.getConnection());
        List<Pedido> pedidoList = bdpedidos(userid);

        // Configura las columnas de la tabla con sus respectivos valores
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        columnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        columnTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        // Crea una lista observable y carga los pedidos en la tabla
        ObservableList<Pedido> listaObservable = FXCollections.observableArrayList(pedidoList);
        tableLista.setItems(listaObservable);

        // Obtener datos del usuario y mostrarlos en las etiquetas
        Usuario usuario = obtenerUsuario(userid);
        usuarionameLabel.setText(usuario.getNombre());
        usuariomailLabel.setText(usuario.getEmail());

        // Maneja la selección de un pedido en la tabla
        tableLista.getSelectionModel().selectedIndexProperty().addListener((observable, oldv, newv) -> {
            seleccionpedido(tableLista.getSelectionModel().getSelectedItem());

        });

    }
    /**
     * Obtiene un usuario por su ID.
     *
     * @param userid El ID del usuario.
     * @return       El objeto Usuario.
     */
    private Usuario obtenerUsuario(Long userid) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImplement(DBConnection.getConnection());
        return usuarioDAO.obtenerUsuarioPorId(userid);
    }
    /**
     * Obtiene una lista de pedidos desde la base de datos.
     *
     * @param userId El ID del usuario.
     * @return       Una lista de objetos Pedido.
     */
    private List<Pedido> bdpedidos(Long userId) {
        PedidoDAOImplement pedidoDAOImplement = new PedidoDAOImplement(DBConnection.getConnection());
        return pedidoDAOImplement.obtenerPedidos(userId);
    }

    /**
     * Click.
     *
     * @param event the event
     */
    @javafx.fxml.FXML
    public void click(Event event) {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("VentanaIte"))
        HelloApplication.ventanaTres("VentanaDetallepedido.fxml");
    }
    /**
     * Maneja la selección de un pedido en la tabla.
     *
     * @param pedido El pedido seleccionado.
     */
    private void seleccionpedido(Pedido pedido) {
        Session.setPedido(pedido);
        Session.setPos(tableLista.getSelectionModel().getSelectedIndex());
        HelloApplication.ventanaTres("VentanaDetallepedido.fxml");
    }
}
