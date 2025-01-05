package com.example.java;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

public class userinfo {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String gender;
    private String age;
    private String mobile;

    private static final Logger LOGGER = Logger.getLogger(userinfo.class.getName());

    private boolean loginSuccessful = false;

    public userinfo() {}

    public userinfo(String email, String password, String firstname, String lastname, String gender, String age, String mobile) {
        Databasecontroller controller = new Databasecontroller();
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
        this.mobile = mobile;
        String sql = "INSERT INTO users (email, password, firstname, lastname, age, gender, mobile) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = controller.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the values in the prepared statement
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password); // Consider hashing the password
            preparedStatement.setString(3, firstname);
            preparedStatement.setString(4, lastname);
            preparedStatement.setInt(5, parseInt(age));
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, mobile);

            // Execute the insert statement
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("A new user was inserted successfully!");
                // Load the main scene
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("signin.fxml"));
                Scene scene = new Scene(loader.load(), 600, 400);
            }
        } catch (SQLException | IOException ex) {
            LOGGER.log(Level.SEVERE, "Error during user registration", ex);
            throw new RuntimeException(ex);
        }
    }

    public userinfo(String email, String password) {
        Databasecontroller controller = new Databasecontroller();
        this.email = email;
        this.password = password;
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection connection = controller.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // User found
                    loginSuccessful = true;
                    showAlert("Login successful!", "Welcome back to Eclipse View");

                    try {
                        sendWelcomeEmail(email);
                    } catch (Exception e) {
                        LOGGER.log(Level.SEVERE, "Email sending failed", e);
                        showErrorAlert("Email Sending Failed:\n" + e.getMessage());
                    }
                } else {
                    // User not found
                    loginSuccessful = false;
                    showAlert("Invalid Inputs", "Email or password is incorrect.");
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE , "Error during login", ex);
            loginSuccessful = false;
        }
    }

    // Add getter for login successful status
    public boolean isLoginSuccessful() {
        return loginSuccessful;
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void sendWelcomeEmail(String email) throws MessagingException {
        final String fromEmail = "eclipseview3@gmail.com";
        final String password = "iueq bzqc qgww dgkp"; // Your App Password

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Welcome Back to Eclipse view!");

            String messageBody = "Dear,\n\nWelcome back to Eclipse View!\n\nWe're excited to have you back!\n\nBest regards,\nEclipse View Team";
            message.setText(messageBody);

            try (Transport transport = session.getTransport("smtp")) {
                transport.connect(fromEmail, password);
                transport.sendMessage(message, message.getAllRecipients());
            }

            LOGGER.info("Welcome email sent successfully to " + email);
        } catch (MessagingException e) {
            LOGGER.log(Level.SEVERE, "Detailed email sending error", e);
            throw e;
        }
    }

    private void showErrorAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Email Sending Failed");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}