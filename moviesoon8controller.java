package com.example.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class moviesoon8controller {
    @FXML
    private Hyperlink soon8trailer;
    @FXML
    private Button backbutton;
    public void backbutton(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) backbutton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("moviepage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 1000);
        Stage movie = new Stage();
        movie.setTitle("Movie Page");
        movie.setScene(scene);
        movie.setResizable(false);
        movie.show();
        currentStage.close();
    }
    @FXML
    private void soon8trailer(ActionEvent event) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(java.net.URI.create("https://youtu.be/o17MF9vnabg?si=bW7davz58kTSa9Pj"));
    }
}
