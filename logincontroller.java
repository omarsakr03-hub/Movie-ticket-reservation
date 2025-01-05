package com.example.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.*;
import javafx.concurrent.Task;


public class logincontroller {
    @FXML
    private Button signupbutton;
    @FXML
    private Button loginbutton;
    @FXML
    private TextField emailtextfeild;
    @FXML
    private TextField passwordtextfeild;
    @FXML
    private Label emailmsglabel;
    @FXML
    private Label passwordmsglabel;


    public void signupbuttonOnAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) signupbutton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage signup = new Stage();
        signup.setTitle("signup page");
        signup.setScene(scene);
        signup.setResizable(false);
        currentStage.close();
        signup.show();
    }


    public void loginbuttonOnAction(ActionEvent event) throws IOException {
        emailmsglabel.setText("");
        passwordmsglabel.setText("");

        boolean allFieldsValid = true;
        if (emailtextfeild.getText().isBlank()) {
            emailmsglabel.setText("Please enter your email");
            allFieldsValid = false;
        }
        if (passwordtextfeild.getText().isBlank()) {
            passwordmsglabel.setText("Please enter your password");
            allFieldsValid = false;
        }

        if (allFieldsValid) {
            Databasecontroller controller = new Databasecontroller();
            String email = emailtextfeild.getText();
            String password = passwordtextfeild.getText();

            // Modify userinfo constructor to return a boolean indicating login success
            boolean loginSuccessful = new userinfo(email, password).isLoginSuccessful();

            if (loginSuccessful) {
                String Email = emailtextfeild.getText();
                Stage currentStage = (Stage) loginbutton.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("moviepage.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 1000);
                Stage movie = new Stage();
                movie.setTitle("Movie Page");
                movie.setScene(scene);
                movie.setResizable(false);
                currentStage.close();
                movie.show();
                moviespagecontroller controller1 = fxmlLoader.getController();
                controller1.emailtransform1(Email);
            }
        }
    }
}