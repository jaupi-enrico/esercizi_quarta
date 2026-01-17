module com.calcolatrice.operazioni {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.calcolatrice.operazioni to javafx.fxml;
    exports com.calcolatrice.operazioni;
}