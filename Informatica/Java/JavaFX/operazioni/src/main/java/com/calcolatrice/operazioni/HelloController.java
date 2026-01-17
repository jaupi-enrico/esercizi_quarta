package com.calcolatrice.operazioni;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
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
        eseguis();
    }

    @FXML
    protected void onMinusButtonClick() {
        operazione = "-";
        signLabel.setText("-");
        eseguis();
    }

    @FXML
    protected void onPersButtonClick() {
        operazione = "*";
        signLabel.setText("*");
        eseguis();
    }

    @FXML
    protected void onDivisButtonClick() {
        operazione = "/";
        signLabel.setText("/");
        eseguis();
    }

    public void eseguis() {
        double num1 = Double.parseDouble(numberOneTextField.getText());
        double num2 = Double.parseDouble(numberTwoTextField.getText());
        if (operazione.equals("+")) {
            resultLabel.setText(Double.toString(num1 + num2));
        }
        else if (operazione.equals("-")) {
            resultLabel.setText(Double.toString(num1 - num2));
        }
        else if (operazione.equals("*")) {
            resultLabel.setText(Double.toString(num1 * num2));
        }
        else if (operazione.equals("/")) {
            resultLabel.setText(Double.toString(num1 / num2));
        }
    }
}