module com.example.reto2 {
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires lombok;

    opens com.example.reto2.Pedido to javafx.base;
    opens com.example.reto2 to javafx.fxml;
    exports com.example.reto2;
    exports com.example.reto2.controllers;
    opens com.example.reto2.controllers to javafx.fxml;
    exports com.example.reto2.doamin;
    opens com.example.reto2.doamin to javafx.fxml;
}