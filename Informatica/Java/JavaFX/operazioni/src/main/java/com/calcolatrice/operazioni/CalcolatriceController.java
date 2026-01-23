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
        if (num1Txt.isEmpty() || num2Txt.isEmpty()) {
            errore("Metti entrambi i numeri");
        }
        else {
            try {
                double num1 = Double.parseDouble(num1Txt);
                double num2 = Double.parseDouble(num2Txt);
                if (operazione.equals("+")) {
                    resultLabel.setText(Double.toString(num1 + num2));
                } else if (operazione.equals("-")) {
                    resultLabel.setText(Double.toString(num1 - num2));
                } else if (operazione.equals("*")) {
                    resultLabel.setText(Double.toString(num1 * num2));
                } else if (operazione.equals("/")) {
                    if (num2 == 0) {
                        resultLabel.setText("Divisione per 0");
                    }
                    else {
                        resultLabel.setText(Double.toString(num1 / num2));
                    }
                }
            }
            catch (NumberFormatException e) {
                errore("Devono essere entrambi numeri");
            }
        }
    }

    private void errore(String error) {
        resultLabel.setText(error);
    }
}