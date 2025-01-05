package com.example.java;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.lang.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class signupcontroller {
    @FXML
    private TextField emailtextfeild;
    @FXML
    private TextField passwordtextfeild;
    @FXML
    private TextField firstnametextfeild;
    @FXML
    private TextField lastnamefeild;
    @FXML
    private TextField agetextfeild;
    @FXML
    private TextField mobilephonetextfeild;
    @FXML
    private Button submit;
    @FXML
    private ComboBox<String> gendercombobox;
    @FXML
    private Label emailmsglabel;
    @FXML
    private Label passwordmsglabel;
    @FXML
    private Label firstnamemsglabel;
    @FXML
    private Label lastnamemsglabel;
    @FXML
    private Label gendermsglabel;
    @FXML
    private Label agemsglabel;
    @FXML
    private Label mobilephonemsglabel;

    private static final Logger LOGGER = Logger.getLogger(signupcontroller.class.getName());

    public void initialize() {
        gendercombobox.setItems(FXCollections.observableArrayList("male", "Female"));
    }

    public void submitbuttonOnAction(ActionEvent event) throws IOException {
        boolean allFieldsValid = true;
        if (emailtextfeild.getText().isBlank()) {
            emailmsglabel.setText("please enter your email");
            allFieldsValid = false;
        }
        if (passwordtextfeild.getText().isBlank()) {
            passwordmsglabel.setText("please enter your password");
            allFieldsValid = false;
        }
        if (firstnametextfeild.getText().isBlank()) {
            firstnamemsglabel.setText("please enter your first name");
            allFieldsValid = false;
        }
        if (lastnamefeild.getText().isBlank()) {
            lastnamemsglabel.setText("please enter your last name");
            allFieldsValid = false;
        }
        if (mobilephonetextfeild.getText().isBlank()) {
            mobilephonemsglabel.setText("please enter your mobile phone");
            allFieldsValid = false;
        }
        if (agetextfeild.getText().isBlank()) {
            agemsglabel.setText("please enter your age");
            allFieldsValid = false;
        }
        if (gendercombobox.getValue() == null) {
            gendermsglabel.setText("please select your gender");
            allFieldsValid = false;
        }

        // If all fields are valid, proceed with user info creation
        if (allFieldsValid) {
            String firstName = firstnametextfeild.getText();
            String lastName = lastnamefeild.getText();
            String age = agetextfeild.getText();
            String email = emailtextfeild.getText();
            String password = passwordtextfeild.getText();
            String gender = gendercombobox.getValue();
            String mobilePhone = mobilephonetextfeild.getText();

            userinfo userinfoo = new userinfo(email, password, firstName, lastName, gender, age, mobilePhone);

            try {
                sendWelcomeEmail(firstName,email);

                // Show success message only if email is sent successfully
                showAlert("Signup Successful", "Welcome to eclipse view");



            } catch (Exception e) {
                // Log the full exception for debugging
                LOGGER.log(Level.SEVERE, "Email sending failed", e);

                // More detailed error handling
                showErrorAlert(
                        "Email Sending Failed:\n" +
                                "1. Check Internet Connection\n" +
                                "2. Verify Email Configuration\n" +
                                "3. Confirm SMTP Server Settings\n\n" +
                                "Detailed Error: " + e.getMessage()
                );
            }
            Stage currentStage = (Stage) submit.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("signin.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage movie = new Stage();
            movie.setTitle("login");
            movie.setScene(scene);
            movie.setResizable(false);
            currentStage.close();
            movie.show();



        }
    }

    private void sendWelcomeEmail(String firstName, String email) throws MessagingException {
        // Detailed email configuration
        final String fromEmail = "eclipseview3@gmail.com";
        final String password = "iueq bzqc qgww dgkp"; // Your App Password

        // Comprehensive SMTP properties with explicit configuration
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Create session with explicit authentication
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        // Enable detailed debugging
        session.setDebug(true);

        try {
            // Create message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Welcome to Eclipse View!");

            // Construct message body
            String messageBody = String.format(
                    "Dear %s,\n\n" +
                            "Welcome to our Eclipse View!\n\n" +
                            "We're excited to have you join us!\n\n" +
                            "Best regards,\nEclipse View Team",
                    firstName
            );
            message.setText(messageBody);

            // Use Transport to send message with explicit connection
            try (Transport transport = session.getTransport("smtp")) {
                transport.connect(fromEmail, password);
                transport.sendMessage(message, message.getAllRecipients());
            }

            // Log successful email sending
            LOGGER.info("Welcome email sent successfully to " + email);

        } catch (MessagingException e) {
            // Log detailed error information
            LOGGER.log(Level.SEVERE, "Detailed email sending error", e);
            throw e;
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showErrorAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Email Sending Failed");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}