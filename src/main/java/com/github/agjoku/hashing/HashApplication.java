package com.github.agjoku.hashing;

import javafx.application.Application;
import javafx.stage.Stage;

public class HashApplication extends Application {
    @Override
    public void start(Stage stage) {
        HashController hashController = new HashController();

        hashController.showStage();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
