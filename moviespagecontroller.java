package com.example.java;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class moviespagecontroller {

    @FXML
    private AnchorPane mainframe;

    @FXML
    private Button movienow1;

    @FXML
    private Button movienow2;

    @FXML
    private Button movienow3;

    @FXML
    private Button movienow4;

    @FXML
    private Button movienow5;

    @FXML
    private Button movienow6;

    @FXML
    private Button moviesoon1;

    @FXML
    private Button moviesoon2;

    @FXML
    private Button moviesoon3;

    @FXML
    private Button moviesoon4;

    @FXML
    private Button moviesoon5;

    @FXML
    private Button moviesoon6;

    @FXML
    private Button moviesoon7;

    @FXML
    private Button moviesoon8;

    @FXML
    private ImageView now0;

    @FXML
    private ImageView now1;

    @FXML
    private ImageView now2;
    @FXML
    private ImageView movieImageView;

    private ScheduledExecutorService scheduler;
    public String email;

    public void emailtransform1(String email) {
        this.email = email;
    }

    Image image1 = new Image(getClass().getResourceAsStream("/images/now1.jpg"));
    Image image2 = new Image(getClass().getResourceAsStream("/images/now2.jpg"));
    Image image3 = new Image(getClass().getResourceAsStream("/images/now3.jpg"));
    Image image4 = new Image(getClass().getResourceAsStream("/images/now4.jpg"));
    Image image5 = new Image(getClass().getResourceAsStream("/images/now5.jpg"));
    Image image6 = new Image(getClass().getResourceAsStream("/images/now6.jpg"));

    private int currentIndex = 0;
    private final Image[] movieImages = {
            image1,image2,image3,image4,image5,image6
    };

    @FXML
    public void initialize() {
        //slider every 3 sec
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::updateSlider, 0, 3, TimeUnit.SECONDS);

        // Initial update to show the first movie
        updateSlider();
    }


    private void updateSlider() {
        // making sure about the threads
        Platform.runLater(() -> {
            // Update the image
            movieImageView.setImage(movieImages[currentIndex]);


            currentIndex = (currentIndex + 1) % movieImages.length; // Loop back to the first image
        });
    }

    public void movienow1OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) movienow1.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("movienow1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 596);
        movienow1controller controller = fxmlLoader.getController();
        controller.emailtransform2(email);
        Stage signup = new Stage();
        signup.setTitle("TERRIFIER 3 "); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }

    public void movienow2OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) movienow2.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("movienow2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 596);
        movienow2controller controller = fxmlLoader.getController();
        controller.emailtransform2(email);
        Stage signup = new Stage();
        signup.setTitle("RED ONE"); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }

    public void movienow3OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) movienow3.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("movienow3.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 596);
        movienow3controller controller = fxmlLoader.getController();
        controller.emailtransform2(email);
        Stage signup = new Stage();
        signup.setTitle("GALIDATOR 2"); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }

    public void movienow4OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) movienow4.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("movienow4.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 596);
        movienow4controller controller = fxmlLoader.getController();
        controller.emailtransform2(email);
        Stage signup = new Stage();
        signup.setTitle("ELHAWA SULTAN "); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }

    public void movienow5OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) movienow5.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("movienow5.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 596);
        movienow5controller controller = fxmlLoader.getController();
        controller.emailtransform2(email);
        Stage signup = new Stage();
        signup.setTitle("MOANA 2"); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }

    public void movienow6OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) movienow6.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("movienow6.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 603, 596);
        movienow6controller controller = fxmlLoader.getController();
        controller.emailtransform2(email);
        Stage signup = new Stage();
        signup.setTitle("ELHAREFA 2"); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }

    public void moviesoon1OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) moviesoon1.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("moviesoon1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 596);
        Stage signup = new Stage();
        signup.setTitle("Mickey 17"); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }

    public void moviesoon2OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) moviesoon2.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("moviesoon2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 596);
        Stage signup = new Stage();
        signup.setTitle("Flight Risk "); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }

    public void moviesoon3OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) moviesoon3.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("moviesoon3.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 596);
        Stage signup = new Stage();
        signup.setTitle(" You Shall Not Sleep Tonight"); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }

    public void moviesoon4OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) moviesoon4.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("moviesoon4.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 596);
        Stage signup = new Stage();
        signup.setTitle("Paradox Effect"); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }

    public void moviesoon5OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) moviesoon5.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("moviesoon5.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 596);
        Stage signup = new Stage();
        signup.setTitle("William tell"); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }

    public void moviesoon6OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) moviesoon6.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("moviesoon6.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 596);
        Stage signup = new Stage();
        signup.setTitle("Blackwater Lane"); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }

    public void moviesoon7OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) moviesoon7.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("moviesoon7.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 596);
        Stage signup = new Stage();
        signup.setTitle("Kraven The Hunter"); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }

    public void moviesoon8OnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) moviesoon8.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("moviesoon8.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 596);
        Stage signup = new Stage();
        signup.setTitle("Mufasa : The Lion King "); // please a3ml method bta3t esm al movie
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }
}

