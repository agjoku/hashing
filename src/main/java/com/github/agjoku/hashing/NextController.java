package com.github.agjoku.hashing;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class NextController {

    final Clipboard clipboard = Clipboard.getSystemClipboard();
    final ClipboardContent content = new ClipboardContent();

    private final Stage stage;
    private final HashController hashController;

    @FXML private Button closenext;
    @FXML private Button copy;
    @FXML private TextField md5field;
    @FXML private TextField sha1field;
    @FXML private TextField sha256field;
    @FXML private TextField sha3_256field;
    @FXML private GridPane hashgrid;

    public NextController(HashController hashController) {
        this.hashController = hashController;

        stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(NextController.class.getResource("next.fxml"));
            loader.setController(this);
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("hash");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        stage.showAndWait();
    }

    @FXML
    private void initialize() throws NoSuchAlgorithmException {
        Hashing hashing = new Hashing();
        String str = hashController.getEnteredText();
        md5field.setText(hashing.md5(str));
        sha1field.setText(hashing.sha1(str));
        sha256field.setText(hashing.sha256(str));
        sha3_256field.setText(hashing.sha3_256(str));

        setFieldInit();
        closenext.setOnAction(event -> clickButton());
        copy.setOnAction(event -> copy());

        hashgrid.setStyle("-fx-grid-lines-visible: true;");
    }

    public void clickButton() {
        CloseController closeController = new CloseController(this);
        hashController.setTextReturn("ウィンドウを閉じました");

        closeController.showStage();
    }

    public void closeNext() {
        stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public void copy() {
        content.putString(md5field.getText());
        clipboard.setContent(content);
    }

    void setFieldInit() {
        md5field.setEditable(false);
        sha1field.setEditable(false);
        sha256field.setEditable(false);
        sha3_256field.setEditable(false);
    }
}
