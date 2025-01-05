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

public class movienow6controller {
    public String moviename;
    public String duration;
    public String agelimit;
    public String screennumber;
    public String category;
    public String timing;
    public String email;
    @FXML
    private Hyperlink now6trailer;
    @FXML
    private Button regular5pm ;
    @FXML
    private Button regular8pm ;
    @FXML
    private Button regular12am ;
    @FXML
    private Button imax5pm ;
    @FXML
    private Button imax8pm ;
    @FXML
    private Button imax12am ;
    @FXML
    private Button gold5pm ;
    @FXML
    private Button gold8pm ;
    @FXML
    private Button gold12am ;
    @FXML
    private Button backbutton;
    movieclass x=new screenclass();
    public void emailtransform2(String email) {
        this.email = email;
    }
    @FXML
    private void now6trailer(ActionEvent event) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(java.net.URI.create("https://youtu.be/iny7249Z6AQ?si=FFaWnyjWm6woQmxH"));
    }
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
    public void regular5pmOnAction(ActionEvent event) throws IOException {
        ((screenclass)x).connector("ELHAREFA 2", "117 min ", "RATED G", "Screen 16", "Regular", "At 5 PM");
        moviename = x.getMoviename();
        duration = x.getDuaration();
        agelimit = x.getAgelimit();
        screennumber = ((screenclass)x).getScreennum();
        category = ((screenclass)x).getCategory();
        timing = ((screenclass)x).getTiming();
        Stage currentStage = (Stage) regular5pm.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("regularcinema.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        regularcinemacontroller controller = fxmlLoader.getController();
        controller.setActiontype("movie6regular5pm");// Set the action type
        controller.checker();
        controller.movietransmission1(moviename,duration,agelimit,screennumber,category,timing,email);
        Stage signup = new Stage();
        signup.setTitle("ELHAREFA 2 5PM");
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }
    public void regular8pmOnAction(ActionEvent event) throws IOException {
        ((screenclass)x).connector("ELHAREFA 2", "117 min ", "RATED G", "Screen 16", "Regular", "At 8 PM");
        moviename = x.getMoviename();
        duration = x.getDuaration();
        agelimit = x.getAgelimit();
        screennumber = ((screenclass)x).getScreennum();
        category = ((screenclass)x).getCategory();
        timing = ((screenclass)x).getTiming();
        Stage currentStage = (Stage) regular8pm.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("regularcinema.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        regularcinemacontroller controller = fxmlLoader.getController();
        controller.setActiontype("movie6regular8pm");// Set the action type
        controller.checker();
        controller.movietransmission1(moviename,duration,agelimit,screennumber,category,timing,email);
        Stage signup = new Stage();
        signup.setTitle("ELHAREFA 2 8PM");
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }
    public void regular12amOnAction(ActionEvent event) throws IOException {
        ((screenclass)x).connector("ELHAREFA 2", "117 min ", "RATED G", "Screen 16", "Regular", "At 12 AM");
        moviename = x.getMoviename();
        duration = x.getDuaration();
        agelimit = x.getAgelimit();
        screennumber = ((screenclass)x).getScreennum();
        category = ((screenclass)x).getCategory();
        timing = ((screenclass)x).getTiming();
        Stage currentStage = (Stage) regular12am.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("regularcinema.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        regularcinemacontroller controller = fxmlLoader.getController();
        controller.setActiontype("movie6regular12am");// Set the action type
        controller.checker();
        controller.movietransmission1(moviename,duration,agelimit,screennumber,category,timing,email);
        Stage signup = new Stage();
        signup.setTitle("ELHAREFA 2 12AM");
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }
    public void imax5pmOnAction(ActionEvent event) throws IOException {
        ((screenclass)x).connector("ELHAREFA 2", "117 min ", "RATED G", "Screen 17", "Imax", "At 5 PM");
        moviename = x.getMoviename();
        duration = x.getDuaration();
        agelimit = x.getAgelimit();
        screennumber = ((screenclass)x).getScreennum();
        category = ((screenclass)x).getCategory();
        timing = ((screenclass)x).getTiming();
        Stage currentStage = (Stage) imax5pm.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("imaxcinema.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        imaxcinemacontroller controller = fxmlLoader.getController();
        controller.setActiontype("movie6imax5pm");// Set the action type
        controller.checker();
        controller.movietransmission1(moviename,duration,agelimit,screennumber,category,timing,email);
        Stage signup = new Stage();
        signup.setTitle("ELHAREFA 2  5pm");
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }
    public void imax8pmOnAction(ActionEvent event) throws IOException {
        ((screenclass)x).connector("ELHAREFA 2", "117 min ", "RATED G", "Screen 17", "Imax", "At 8 PM");
        moviename = x.getMoviename();
        duration = x.getDuaration();
        agelimit = x.getAgelimit();
        screennumber = ((screenclass)x).getScreennum();
        category = ((screenclass)x).getCategory();
        timing = ((screenclass)x).getTiming();
        Stage currentStage = (Stage) imax8pm.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("imaxcinema.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        imaxcinemacontroller controller = fxmlLoader.getController();
        controller.setActiontype("movie6imax8pm");// Set the action type
        controller.checker();
        controller.movietransmission1(moviename,duration,agelimit,screennumber,category,timing,email);
        Stage signup = new Stage();
        signup.setTitle("ELHAREFA 2 -  8pm");
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }
    public void imax12amOnAction(ActionEvent event) throws IOException {
        ((screenclass)x).connector("ELHAREFA 2", "117 min ", "RATED G", "Screen 17", "Imax", "At 12 AM");
        moviename = x.getMoviename();
        duration = x.getDuaration();
        agelimit = x.getAgelimit();
        screennumber = ((screenclass)x).getScreennum();
        category = ((screenclass)x).getCategory();
        timing = ((screenclass)x).getTiming();
        Stage currentStage = (Stage) imax12am.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("imaxcinema.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        imaxcinemacontroller controller = fxmlLoader.getController();
        controller.setActiontype("movie6imax12am");// Set the action type
        controller.checker();
        controller.movietransmission1(moviename,duration,agelimit,screennumber,category,timing,email);
        Stage signup = new Stage();
        signup.setTitle("ELHAREFA 2  12Am");
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }
    public void gold5pmOnAction(ActionEvent event) throws IOException {
        ((screenclass)x).connector("ELHAREFA 2", "117 min ", "RATED G", "Screen 18", "Gold", "At 5 PM");
        moviename = x.getMoviename();
        duration = x.getDuaration();
        agelimit = x.getAgelimit();
        screennumber = ((screenclass)x).getScreennum();
        category = ((screenclass)x).getCategory();
        timing = ((screenclass)x).getTiming();
        Stage currentStage = (Stage) gold5pm.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("goldcinema.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        goldcinemacontroller controller = fxmlLoader.getController();
        controller.setActiontype("movie6gold5pm");// Set the action type
        controller.checker();
        controller.movietransmission1(moviename,duration,agelimit,screennumber,category,timing,email);
        Stage signup = new Stage();
        signup.setTitle("ELHAREFA 2 -  5pm");
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }
    public void gold8pmOnAction(ActionEvent event) throws IOException {
        ((screenclass)x).connector("terrifier 3 ", "125 min ", "RATED 18+", "Screen 18", "Gold", "At 8 PM");
        moviename = x.getMoviename();
        duration = x.getDuaration();
        agelimit = x.getAgelimit();
        screennumber = ((screenclass)x).getScreennum();
        category = ((screenclass)x).getCategory();
        timing = ((screenclass)x).getTiming();
        Stage currentStage = (Stage) gold8pm.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("goldcinema.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        goldcinemacontroller controller = fxmlLoader.getController();
        controller.setActiontype("movie6gold8pm");// Set the action type
        controller.checker();
        controller.movietransmission1(moviename,duration,agelimit,screennumber,category,timing,email);
        Stage signup = new Stage();
        signup.setTitle("ELHAREFA 2 -  8pm");
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
    }
    public void gold12amOnAction(ActionEvent event) throws IOException {
        ((screenclass)x).connector("terrifier 3 ", "125 min ", "RATED 18+", "Screen 18", "Regular", "At 12 AM");
        moviename = x.getMoviename();
        duration = x.getDuaration();
        agelimit = x.getAgelimit();
        screennumber = ((screenclass)x).getScreennum();
        category = ((screenclass)x).getCategory();
        timing = ((screenclass)x).getTiming();
        Stage currentStage = (Stage) gold12am.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("goldcinema.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        goldcinemacontroller controller = fxmlLoader.getController();
        controller.setActiontype("movie6gold12am");// Set the action type
        controller.checker();
        controller.movietransmission1(moviename,duration,agelimit,screennumber,category,timing,email);
        Stage signup = new Stage();
        signup.setTitle("ELHAREFA 2 - 12am");
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
        currentStage.close();
    }


}
