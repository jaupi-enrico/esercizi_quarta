module com.lanciadadi.lanciadadi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lanciadadi.lanciadadi to javafx.fxml;
    exports com.lanciadadi.lanciadadi;
}