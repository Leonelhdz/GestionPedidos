package com.example.reto2.controllers;

import com.example.reto2.HelloApplication;
import com.example.reto2.Item.ItemDAO;
import com.example.reto2.Item.ItemPedido;
import com.example.reto2.Item.ItemPedidoDAOImplement;
import com.example.reto2.Session;
import com.example.reto2.doamin.DBConnection;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador para la ventana de detalles de los ítems del pedido.
 */
public class VentanaItemsPedidoController implements Initializable {
    private static Long itemid;
    @javafx.fxml.FXML
    private TableView<ItemPedido> tablaDetallespedido;
    @javafx.fxml.FXML
    private TableColumn<ItemPedido, String> Iditems;
    @javafx.fxml.FXML
    private TableColumn<ItemPedido, String> codPedidoItems;
    @javafx.fxml.FXML
    private TableColumn<ItemPedido, String> cantidadItems;
    @javafx.fxml.FXML
    private TableColumn<ItemPedido, String> productoIditems;
    private ObservableList<ItemPedido> observableListItem;
    private ItemDAO itemsdao;
    @javafx.fxml.FXML
    private Button buttonSalir1;

    /**
     * Establece el ID del ítem del pedido.
     *
     * @param id El ID del ítem del pedido.
     */
    public static void itempedido(Long id) {
        VentanaItemsPedidoController.itemid = id;
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
     * Retroceder.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @javafx.fxml.FXML
    public void retroceder(ActionEvent actionEvent) throws IOException {
        HelloApplication.retro("ventanaPrincipal.fxml");
    }
    /**
     * Inicializa la ventana de detalles de ítems del pedido.
     *
     * @param url             La ubicación relativa del archivo FXML.
     * @param resourceBundle  Recursos específicos del usuario.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Iditems.setCellValueFactory((fila) -> {
            String id = String.valueOf(fila.getValue().getId());
            return new SimpleStringProperty(id);
        });

        codPedidoItems.setCellValueFactory((fila) -> {
            String CodigoPedido = fila.getValue().getCodigoPedido();
            return new SimpleStringProperty(CodigoPedido);
        });

        cantidadItems.setCellValueFactory((fila) -> {
            String Cantidad = String.valueOf(fila.getValue().getCantidad());
            return new SimpleStringProperty(Cantidad);
        });

        productoIditems.setCellValueFactory((fila) -> {
            String Producto = String.valueOf(fila.getValue().getProductoId());
            return new SimpleStringProperty(Producto);
        });

        observableListItem = FXCollections.observableArrayList();
        ItemPedidoDAOImplement itemPedidoDAOImplement = new ItemPedidoDAOImplement(DBConnection.getConnection());
        Session.setItems(itemPedidoDAOImplement.obtenerTodos(Session.getPedido().getCodigo()));
        observableListItem.addAll(Session.getItems());
        tablaDetallespedido.setItems(observableListItem);

    }
}
