package net.imparando.daditesto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DadiTestoController {
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtFacce;
    @FXML
    private Label lblDadi;

    TazzaPerDadi dadi;

    @FXML
    protected void onLanciaButtonClick() {
        int nDadi = Integer.parseInt(txtNumero.getText());
        int nFacce = Integer.parseInt(txtFacce.getText());
        try {
            dadi = new TazzaPerDadi(nDadi, nFacce);
        } catch (Exception e) {
            String messaggio = e.toString();
            System.out.println(messaggio);

            return;
        }
        int n = dadi.lancia();
        lblDadi.setText("" + n);
    }
}
