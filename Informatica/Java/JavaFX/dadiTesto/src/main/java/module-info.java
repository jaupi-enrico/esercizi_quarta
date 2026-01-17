module net.imparando.daditesto {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.imparando.daditesto to javafx.fxml;
    exports net.imparando.daditesto;
}