package com.github.agjoku.hashing;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;


public class CloseController {

    private final Stage stage;

    @FXML private Button close;

    @FXML private Button noclose;

    @FXML private Label test;

    private final NextController nextController;
    public CloseController(NextController nextController) {
        this.nextController = nextController;

        stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(CloseController.class.getResource("check.fxml"));
            loader.setController(this);
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("check");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize(){
        close.setOnAction(event -> Close());
        noclose.setOnAction((event -> noClose()));
    }

    public void showStage() {
        stage.showAndWait();
    }

    void Close() {
        stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
        nextController.closeNext();
    }

    void noClose(){
        stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
    }
}
