package com.alberghi.alberghi;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class AlberghiController {
    @FXML
    private ChoiceBox<Albergo> choAlberghi;



    @FXML
    protected void onbtnRimuoviClick() {
        choAlberghi.getSelectionModel().getSelectedIndex();
    }
}