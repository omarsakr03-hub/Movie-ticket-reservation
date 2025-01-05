package com.example.java;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ticketcontroller {
    @FXML
    private Label moviename;
    @FXML
    private Label date;
    @FXML
    private Label time;
    @FXML
    private Label price;
    @FXML
    private Label screennumber;
    @FXML
    private Label category;
    @FXML
    private Label seats;
    @FXML
    private Label agelimit;
    @FXML
    private Label duration;

    private String email;
    private String Seatsemail;
    private String totalprice;
    private String Moviename;
    private String Duration;
    private String Screennumber;
    private String Category;
    private String Agelimit;
    private String Time;
    private LocalDate today = LocalDate.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM");
    private String formattedDate = today.format(formatter);

    private static final Logger LOGGER = Logger.getLogger(ticketcontroller.class.getName());

//    public void displaySelectedSeats(String seatsString) {
//        this.Seatsemail = seatsString;
//        seats.setText(seatsString);
//    }


    public void movietransmission3(String moviename, String duration, String agelimit, String screennumber, String category, String timing, String email, double total,String seatsemail) {
        this.moviename.setText(moviename);
        this.Moviename = moviename;
        this.duration.setText(duration);
        this.Duration = duration;
        this.Screennumber = screennumber;
        this.agelimit.setText(agelimit);
        this.Category = category;
        this.screennumber.setText(screennumber);
        this.Time = timing;
        this.category.setText(category);
        this.Agelimit = agelimit;
        this.time.setText(timing);
        this.email = email;
        this.price.setText(String.valueOf(total));
        this.totalprice = String.valueOf(total);
        this.seats.setText(seatsemail);
        this.Seatsemail = seatsemail;

        // Send email after setting all details
        sendEmail();
    }


    private void sendEmail() {
        try {
            sendWelcomeEmail(email, totalprice, Seatsemail, Moviename, Duration, Screennumber, Category, Time, Agelimit);
            showAlert("Reservation Successful", "Reservation completed");
        } catch (MessagingException e) {
            LOGGER.log(Level.SEVERE, "Email sending failed", e);
            showErrorAlert(
                    "Email Sending Failed:\n" +
                            "1. Check Internet Connection\n" +
                            "2. Verify Email Configuration\n" +
                            "3. Confirm SMTP Server Settings\n\n" +
                            "Detailed Error: " + e.getMessage()
            );
        }
    }

    private void sendWelcomeEmail(String email, String totalprice, String seats, String moviename, String duration, String screennumber, String category, String time, String agelimit) throws MessagingException {
        final String fromEmail = "eclipseview3@gmail.com";
        final String password = "iueq bzqc qgww dgkp"; // Use environment variable or secure storage

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
            message.setSubject("Reservation completed!");

            String messageBody = String.format(
                    "Movie name: %s\n" +
                            "Duration: %s\n" +
                            "Timing: %s\n" +
                            "Age limit: %s\n" +
                            "Screen number: %s\n" +
                            "Category: %s\n" +
                            "Total price: %s\n" +
                            "Seats selected: %s\n",
                    Moviename, Duration, Time, Agelimit, Screennumber, Category, totalprice, Seatsemail
            );
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