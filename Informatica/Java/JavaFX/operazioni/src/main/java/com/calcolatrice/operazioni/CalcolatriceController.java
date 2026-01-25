package com.calcolatrice.operazioni;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalcolatriceController {
    @FXML
    private Label resultLabel;
    @FXML
    private Label signLabel;
    @FXML
    private TextField numberOneTextField;
    @FXML
    private TextField numberTwoTextField;

    String operazione = "";

    @FXML
    protected void onPlusButtonClick() {
        operazione = "+";
        signLabel.setText("+");
        esegui();
    }

    @FXML
    protected void onMinusButtonClick() {
        operazione = "-";
        signLabel.setText("-");
        esegui();
    }

    @FXML
    protected void onPersButtonClick() {
        operazione = "*";
        signLabel.setText("*");
        esegui();
    }

    @FXML
    protected void onDivisButtonClick() {
        operazione = "/";
        signLabel.setText("/");
        esegui();
    }

    private void esegui() {
        String num1Txt = numberOneTextField.getText();
        String num2Txt = numberTwoTextField.getText();
        resultLabel.setText(Calcolatrice.esegui(operazione, num1Txt, num2Txt));
    }

    private void errore(String error) {
        resultLabel.setText(error);
    }
}