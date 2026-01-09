package com.lanciadadi.lanciadadi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LanciaDadiController {
    private LanciaDadiModel tazza;
    public LanciaDadiController() {
        tazza = new LanciaDadiModel();
    }

    @FXML
    private Label lblLancio;
    @FXML
    private Label lblTypeDadi;
    @FXML
    private Label lblNDadi;

    @FXML
    protected void setNDado1() {
        tazza.setnDadi(1);
        lblNDadi.setText("1");
    }

    @FXML
    protected void setNDado2() {
        tazza.setnDadi(2);
        lblNDadi.setText("2");
    }

    @FXML
    protected void setNDado3() {
        tazza.setnDadi(3);
        lblNDadi.setText("3");
    }

    @FXML
    protected void setType6() {
        tazza.setTypeDadi(6);
        lblTypeDadi.setText("6");
    }

    @FXML
    protected void setType10() {
        tazza.setTypeDadi(10);
        lblTypeDadi.setText("10");
    }

    @FXML
    protected void setType20() {
        tazza.setTypeDadi(20);
        lblTypeDadi.setText("20");
    }

    @FXML
    protected void lancia() {
        int lancio = tazza.lancia();
        lblLancio.setText(Integer.toString(lancio));
    }
}