module com.alberghi.alberghi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alberghi.alberghi to javafx.fxml;
    exports com.alberghi.alberghi;
}