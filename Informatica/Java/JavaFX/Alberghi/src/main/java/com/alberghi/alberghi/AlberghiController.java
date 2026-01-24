package com.alberghi.alberghi;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.time.LocalDate;
import java.time.Period;

public class AlberghiController {
    @FXML
    private ChoiceBox<Albergo> choAlberghi;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtPrezzo;
    @FXML
    private HBox addHBox;
    @FXML
    private Label lblPrezzo;
    @FXML
    private DatePicker dateInizio;
    @FXML
    private DatePicker dateFine;

    @FXML
    protected void onBtnRimuoviClick() {
        int index = choAlberghi.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            choAlberghi.getItems().remove(index);
        }
    }

    @FXML
    protected void onBtnAggiungiClick() {
        addHBox.visibleProperty().set(!addHBox.isVisible());
    }

    @FXML
    protected void onBtnConfirmClick() {
        String name = txtNome.getText();
        String prezzoTxt = txtPrezzo.getText();
        double prezzo;
        if (name.isEmpty()) {
            lblPrezzo.setText("Inserisci un nome");
        } else if (prezzoTxt.isEmpty()) {
            lblPrezzo.setText("Inserisci un prezzo");
        } else {
            try {
                prezzo = Double.parseDouble(prezzoTxt);
                Albergo alb = new Albergo(name, prezzo);
                choAlberghi.getItems().add(alb);
                choAlberghi.getSelectionModel().selectLast();
                addHBox.visibleProperty().set(false);
            } catch (NumberFormatException e) {
                lblPrezzo.setText("Il prezzo deve essere un numero");
            }
        }
    }

    @FXML
    protected void onBtnCalcolaClick() {
        LocalDate start = dateInizio.getValue();
        LocalDate end = dateFine.getValue();
        if (choAlberghi.getSelectionModel().getSelectedIndex() == -1) {
            lblPrezzo.setText("Selezionare un albergo");
        }
        else if (start == null || end == null) {
            lblPrezzo.setText("Inserire entrambe le date");
        }
        else if (start.isAfter(end)) {
            lblPrezzo.setText("La data di inizio è dopo quella di fine");
        }
        else {
            Albergo alb = choAlberghi.getSelectionModel().getSelectedItem();
            double prezzo = alb.calcolaPrezzo(start, end);
            lblPrezzo.setText("Prezzo = " + prezzo + " €");
        }
    }
}