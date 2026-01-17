package com.calcolatrice.operazioni;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    String operazione = "";

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onPlusButtonClick() {
        operazione = "+";
    }

    @FXML
    protected void onMinusButtonClick() {
        operazione = "-";
    }

    @FXML
    protected void onPersButtonClick() {
        operazione = "*";
    }

    @FXML
    protected void onDivisButtonClick() {
        operazione = "/";
    }

    public void eseguis() {
        if (operazione.equals("+")) {
            welcomeText.setText("4");
        }
    }
}