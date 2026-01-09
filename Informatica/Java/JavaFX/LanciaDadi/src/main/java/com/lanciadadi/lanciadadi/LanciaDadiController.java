package com.lanciadadi.lanciadadi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LanciaDadiController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}