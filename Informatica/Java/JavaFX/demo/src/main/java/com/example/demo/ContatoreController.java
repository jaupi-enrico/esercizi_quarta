package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ContatoreController {
    private final ContatoreModel contatore;
    public ContatoreController() {
        contatore = new ContatoreModel();
    }

    @FXML
    private Label lblContatore;

    @FXML
    protected void OnIncrementalButtonClick() {
        contatore.next();
        lblContatore.setText("Contatore: " + contatore.toString());
    }

    @FXML
    protected void OnIncrementalDoubleButtonClick() {
        contatore.next();
        contatore.next();
        lblContatore.setText("Contatore: " + contatore.toString());
    }
}