package com.github.agjoku.hashing;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class HashController {
    @FXML private TextField hashTextField;

    @FXML private Button nextPagebutton;

    @FXML private Label emptylabel;

    public String[] strings;

    private final Stage stage;

    Hashing hashing = new Hashing();

    public HashController(){
        stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(HashApplication.class.getResource("hash.fxml"));
//          fx:controller="com.github.agjoku.hashing.HashController"
            loader.setController(this);
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("入力画面");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage(){
        stage.showAndWait();
    }

    @FXML
    private void initialize(){
        nextPagebutton.setOnAction(event -> nextPageButtonClick());
    }

    public String getEnteredText() throws NoSuchAlgorithmException  {
        Hashing hashing = new Hashing();
        String str = hashing.md5(hashTextField.getText());
        return hashTextField.getText();
    }

    public void setTextReturn(String text) {
        emptylabel.setText(text);
    }

    @FXML
    protected void nextPageButtonClick(){
        NextController nextController = new NextController(this);
        nextController.showStage();
    }
}
