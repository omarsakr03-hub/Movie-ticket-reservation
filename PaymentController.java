package com.example.java;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class PaymentController {
     public String moviename;
    public String duration;
    public String agelimit;
    public String screennumber;
    public String category;
    public String timing;
    public String email;
    public double total;
    @FXML
    private TextField cardNumberField;
    @FXML
    private TextField cardHolderField;
    @FXML
    private TextField cvvField;
    @FXML
    private TextField expirationMonthField; // New field for month
    @FXML
    private TextField expirationYearField;  // New field for year
    @FXML
    private Label messageLabel;
    @FXML
    private Label messageLabel1;

    @FXML
    private Label messageLabel2;

    @FXML
    private Label messageLabel3;

    @FXML
    private Label messageLabel4;
    @FXML
    private Button submitButton;

    private List<String> selectedSeats;
    public String seatsString;
    private ticketcontroller controller;

    public void setSelectedSeats(List<String> selectedSeats) {
        this.seatsString = String.join(", ", selectedSeats);
        System.out.println(seatsString);
    }


    @FXML
    private void handleSubmit() throws IOException {
        String cardNumber = cardNumberField.getText();
        String cardHolder = cardHolderField.getText();
        String cvv = cvvField.getText();
        String expirationMonth = expirationMonthField.getText(); // Get the month
        String expirationYear = expirationYearField.getText();   // Get the year

        if (expirationMonth.isEmpty() || expirationYear.isEmpty()) {
            messageLabel.setText("Please enter both expiration month and year.");
            return;
        }

        if (validateInputs(cardNumber, cardHolder, cvv, expirationMonth, expirationYear)) {
            messageLabel.setText("Payment successful!");
//            Stage currentStage = (Stage) submitButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ticket.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 402);
            Stage signup = new Stage();
            signup.setTitle("TICKET");
            signup.setScene(scene);
            signup.setResizable(false);
            signup.show();
//            currentStage.close();
            controller = fxmlLoader.getController();
            controller.movietransmission3(moviename,duration,agelimit,screennumber,category,timing,email,total,seatsString); // Set the action type
        }
//        Stage currentStage = (Stage) submitButton.getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ticket.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 700, 402);
//        Stage signup = new Stage();
//        signup.setTitle("TICKET");
//        signup.setScene(scene);
//        signup.setResizable(false);
//        signup.show();
//        currentStage.close();
//        controller = fxmlLoader.getController();
//        controller.movietransmission3(moviename,duration,agelimit,screennumber,category,timing,email,total,seatsString); // Set the action type
//        controller.displaySelectedSeats(seatsString);
    }
    public void movietransmission2(String moviename,String duration,String agelimit,String screennumber,String category,String timing,String email,double total) {
        this.moviename=moviename;
        this.duration=duration;
        this.agelimit=agelimit;
        this.screennumber=screennumber;
        this.category=category;
        this.timing=timing;
        this.email=email;
        this.total=total;
    }

    private boolean validateInputs(String cardNumber, String cardHolder, String cvv, String expirationMonth, String expirationYear) {
        boolean isValid = true;

        if (!isValidCardNumber(cardNumber)) {
            messageLabel1.setText("Invalid card number");
            isValid = false;
        }
        if (!isValidCardHolder(cardHolder)) {
            messageLabel2.setText("Invalid card holder name");
            isValid = false;
        }
        if (!isValidCVV(cvv)) {
            messageLabel3.setText("Invalid CVV");
            isValid = false;
        }

        String expirationMessage = isValidExpirationDate(expirationMonth, expirationYear);
        if (expirationMessage != null) {
            messageLabel4.setText(expirationMessage);
            isValid = false;
        }

        return isValid;
    }

    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber.matches("\\d{16}"); // Check for exactly 16 digits
    }

    private boolean isValidCardHolder(String cardHolder) {
        return cardHolder.matches("[a-zA-Z .'-]+"); // Allow letters, spaces, dots, hyphens, and apostrophes
    }

    private boolean isValidCVV(String cvv) {
        return cvv.matches("\\d{3}"); // Check for exactly 3 digits
    }

    private String isValidExpirationDate(String month, String year) {
        try {
            int monthInt = Integer.parseInt(month);
            int yearInt = Integer.parseInt(year);

            if (monthInt < 1 || monthInt > 12) {
                return "Invalid month. Please enter a value between 01 and 12.";
            }

            // Create a LocalDate for the first day of the expiration month and year
            LocalDate date = LocalDate.of(yearInt + 2000, monthInt, 1); // Assuming year is in 00-99 format

            if (date.isBefore(LocalDate.now())) {
                return "The expiration date is in the past.";
            } else {
                return null; // Valid expiration date
            }
        } catch (NumberFormatException e) {
            return "Invalid input. Please enter numeric values for month and year.";
        } catch (DateTimeParseException e) {
            return "Invalid date. Please check the month and year.";
        }
    }
}