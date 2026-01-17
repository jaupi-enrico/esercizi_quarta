package net.imparando.daditesto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DadiTestoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DadiTestoApplication.class.getResource("dadi-testo-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dadi");
        stage.setScene(scene);
        stage.show();
    }
}
