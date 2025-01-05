package com.example.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class goldcinemacontroller {

    @FXML
    private ListView<String> vipListView;

    @FXML
    private Label totalLabel;

    @FXML
    private ToggleButton toggleButton1, toggleButton2, toggleButton3, toggleButton4,
            toggleButton5, toggleButton6, toggleButton7, toggleButton8,
            toggleButton9, toggleButton10, toggleButton11, toggleButton12,
            toggleButton13, toggleButton14, toggleButton15, toggleButton16,
            toggleButton17, toggleButton18, toggleButton19, toggleButton20,
            toggleButton21, toggleButton22, toggleButton23, toggleButton24,
            toggleButton25, toggleButton26, toggleButton27, toggleButton28,
            toggleButton29, toggleButton30, toggleButton31, toggleButton32;

    @FXML
    private Button backButton, checkoutButton;

    @FXML
    private Label goldlabel;

    @FXML
    private ImageView goldimg;

    private String actiontype;
    private String moviename;
    public String duration;
    public String agelimit;
    public String screennumber;
    public String category;
    public String timing;
    public String email;
    public int ShowId=0;


    private static final int SEAT_PRICE = 250; // Adjust the seat price as needed
    Image image1 = new Image(getClass().getResourceAsStream("/images/now1.jpg"));
    Image image2 = new Image(getClass().getResourceAsStream("/images/now2.jpg"));
    Image image3 = new Image(getClass().getResourceAsStream("/images/now3.jpg"));
    Image image4 = new Image(getClass().getResourceAsStream("/images/now4.jpg"));
    Image image5 = new Image(getClass().getResourceAsStream("/images/now5.jpg"));
    Image image6 = new Image(getClass().getResourceAsStream("/images/now6.jpg"));

    private static final String DB_URL = "jdbc:mysql://localhost:3306/cinema_booking";
    private static final String USER = "root";
    private static final String PASS = "123456789";

    private final ObservableList<String> selectedSeatsList = FXCollections.observableArrayList();
    private Map<String, ToggleButton> seatButtons = new HashMap<>();
    public double total;
    @FXML
    public void initialize() {
        // Initialize all toggle buttons
        initializeToggleButtons();

        // Load seat status from database
        loadSeatStatus();

        vipListView.setItems(selectedSeatsList);
    }
    private void initializeToggleButtons() {
        // Manually add all toggle buttons to the map
        seatButtons.put("A1", toggleButton1);
        seatButtons.put("A2", toggleButton2);
        seatButtons.put("A3", toggleButton3);
        seatButtons.put("A4", toggleButton4);
        seatButtons.put("A5", toggleButton5);
        seatButtons.put("A6", toggleButton6);
        seatButtons.put("A7", toggleButton7);
        seatButtons.put("A8", toggleButton8);

        seatButtons.put("B1", toggleButton9);
        seatButtons.put("B2", toggleButton10);
        seatButtons.put("B3", toggleButton11);
        seatButtons.put("B4", toggleButton12);
        seatButtons.put("B5", toggleButton13);
        seatButtons.put("B6", toggleButton14);
        seatButtons.put("B7", toggleButton15);
        seatButtons.put("B8", toggleButton16);

        seatButtons.put("C1", toggleButton17);
        seatButtons.put("C2", toggleButton18);
        seatButtons.put("C3", toggleButton19);
        seatButtons.put("C4", toggleButton20);
        seatButtons.put("C5", toggleButton21);
        seatButtons.put("C6", toggleButton22);
        seatButtons.put("C7", toggleButton23);
        seatButtons.put("C8", toggleButton24);

        seatButtons.put("D1", toggleButton25);
        seatButtons.put("D2", toggleButton26);
        seatButtons.put("D3", toggleButton27);
        seatButtons.put("D4", toggleButton28);
        seatButtons.put("D5", toggleButton29);
        seatButtons.put("D6", toggleButton30);
        seatButtons.put("D7", toggleButton31);
        seatButtons.put("D8", toggleButton32);

        // Add event listeners to each button
        for (Map.Entry<String, ToggleButton> entry : seatButtons.entrySet()) {
            entry.getValue().setOnAction(event -> handleSeatSelection(entry.getKey()));
        }
    }

    public void movietransmission1(String moviename, String duration, String agelimit, String screennumber, String category, String timing,String email) {
        this.moviename = moviename;
        this.duration = duration;
        this.agelimit = agelimit;
        this.screennumber = screennumber;
        this.category = category;
        this.timing = timing;
        this.email = email;
    }

    public void setActiontype(String actiontype) {
        this.actiontype = actiontype;
    }

    public void checker() {
        if (actiontype != null) {
            switch (actiontype) {
                case "movie1gold5pm":
                    goldlabel.setText("TEFFIFIER - 5 PM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image1);
                    goldimg.setVisible(true);
                    ShowId=7;
                    break;
                case "movie1gold8pm":
                    goldlabel.setText("TEFFIFIER - 8 PM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image1);
                    goldimg.setVisible(true);
                    ShowId=8;
                    break;
                case "movie1gold12am":
                    goldlabel.setText("TEFFIFIER - 12 AM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image1);
                    goldimg.setVisible(true);
                    ShowId=9;
                    break;
                case "movie2gold5pm":
                    goldlabel.setText("RED ONE - 5 PM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image2);
                    goldimg.setVisible(true);
                    ShowId=16;
                    break;
                case "movie2gold8pm":
                    goldlabel.setText("RED ONE - 8 PM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image2);
                    goldimg.setVisible(true);
                    ShowId=17;
                    break;
                case "movie2gold12am":
                    goldlabel.setText("RED ONE - 12 AM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image2);
                    goldimg.setVisible(true);
                    ShowId=18;
                    break;
                case "movie3gold5pm":
                    goldlabel.setText("GLADIATOR - 5 PM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image3);
                    goldimg.setVisible(true);
                    ShowId=25;
                    break;
                case "movie3gold8pm":
                    goldlabel.setText("GLADIATOR - 8 PM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image3);
                    goldimg.setVisible(true);
                    ShowId=26;
                    break;
                case "movie3gold12am":
                    goldlabel.setText("GLADIATOR - 12 AM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image3);
                    goldimg.setVisible(true);
                    ShowId=27;
                    break;
                case "movie4gold5pm":
                    goldlabel.setText("ELHAWA SULTAN - 5 PM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image4);
                    goldimg.setVisible(true);
                    ShowId=34;
                    break;
                case "movie4gold8pm":
                    goldlabel.setText("ELHAWA SULTAN - 8 PM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image4);
                    goldimg.setVisible(true);
                    ShowId=35;
                    break;
                case "movie4gold12am":
                    goldlabel.setText("ELHAWA SULTAN - 12 AM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image4);
                    goldimg.setVisible(true);
                    ShowId=36;
                    break;
                case "movie5gold5pm":
                    goldlabel.setText("MOANA 2 - 5 PM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image5);
                    goldimg.setVisible(true);
                    ShowId=43;
                    break;
                case "movie5gold8pm":
                    goldlabel.setText("MOANA 2 - 8 PM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image5);
                    goldimg.setVisible(true);
                    ShowId=44;
                    break;
                case "movie5gold12am":
                    goldlabel.setText("MOANA 2 - 12 AM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image5);
                    goldimg.setVisible(true);
                    ShowId=45;
                    break;
                case "movie6gold5pm":
                    goldlabel.setText("ELHAREFA 2 - 5 PM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image6);
                    goldimg.setVisible(true);
                    ShowId=52;
                    break;
                case "movie6gold8pm":
                    goldlabel.setText("ELHAREFA 2 - 8 PM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image6);
                    goldimg.setVisible(true);
                    ShowId=53;
                    break;
                case "movie6gold12am":
                    goldlabel.setText("ELHAREFA 2 - 12 AM");
                    goldlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    goldimg.setImage(image6);
                    goldimg.setVisible(true);
                    ShowId=54;
                    break;
            }
        }
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        // Map of action types to their corresponding FXML and window titles
        Map<String, Pair<String, String>> movieScreenMap = Map.ofEntries(
                Map.entry("movie1gold5pm", new Pair<>("movienow1.fxml", "TERRIFIER 3")),
                Map.entry("movie1gold8pm", new Pair<>("movienow1.fxml", "TERRIFIER 3")),
                Map.entry("movie1gold12am", new Pair<>("movienow1.fxml", "TERRIFIER 3")),
                Map.entry("movie2gold5pm", new Pair<>("movienow2.fxml", "RED ONE")),
                Map.entry("movie2gold8pm", new Pair<>("movienow2.fxml", "RED ONE")),
                Map.entry("movie2gold12am", new Pair<>("movienow2.fxml", "RED ONE")),
                Map.entry("movie3gold5pm", new Pair<>("movienow3.fxml", "GLADIATOR")),
                Map.entry("movie3gold8pm", new Pair<>("movienow3.fxml", "GLADIATOR")),
                Map.entry("movie3gold12am", new Pair<>("movienow3.fxml", "GLADIATOR")),
                Map.entry("movie4gold5pm", new Pair<>("movienow4.fxml", "ELHAWA SULTAN")),
                Map.entry("movie4gold8pm", new Pair<>("movienow4.fxml", "ELHAWA SULTAN")),
                Map.entry("movie4gold12am", new Pair<>("movienow4.fxml", "ELHAWA SULTAN")),
                Map.entry("movie5gold5pm", new Pair<>("movienow5.fxml", "MOANA 2")),
                Map.entry("movie5gold8pm", new Pair<>("movienow5.fxml", "MOANA 2")),
                Map.entry("movie5gold12am", new Pair<>("movienow5.fxml", "MOANA 2")),
                Map.entry("movie6gold5pm", new Pair<>("movienow6.fxml", "ELHAREFA 2")),
                Map.entry("movie6gold8pm", new Pair<>("movienow6.fxml", "ELHAREFA 2")),
                Map.entry("movie6gold12am", new Pair<>("movienow6.fxml", "ELHAREFA 2"))
        );

        try {
            if (actiontype != null) {
                Pair<String, String> screenDetails = movieScreenMap.get(actiontype);

                if (screenDetails != null) {
                    // Fallback to event source if backButton is null
                    Stage currentStage = backButton != null
                            ? (Stage) backButton.getScene().getWindow()
                            : (Stage) ((Node) event.getSource()).getScene().getWindow();

                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(screenDetails.getKey()));
                    Scene scene = new Scene(fxmlLoader.load(), 603, 596);

                    Stage newStage = new Stage();
                    newStage.setTitle(screenDetails.getValue());
                    newStage.setScene(scene);
                    newStage.setResizable(false);
                    newStage.show();

                    currentStage.close();
                } else {
                    System.err.println("Invalid action type: " + actiontype);
                    showAlert("Navigation Error", "Unable to navigate back for this movie.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred while navigating back.");
        }
    }

    private void loadSeatStatus() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String query = "SELECT seat_number, is_reserved FROM seat_reservations WHERE show_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, ShowId); // Assume you have the current show ID

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String seatNumber = rs.getString("seat_number");
                boolean isReserved = rs.getBoolean("is_reserved");

                ToggleButton button = seatButtons.get(seatNumber);
                if (button != null) {
                    if (isReserved) {
                        // Disable and change color of reserved seats
                        button.setDisable(true);
                        button.setStyle("-fx-background-color: red;");
                    } else {
                        // Reset button style if the seat is not reserved
                        button.setStyle(""); // Set to default style
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection error
            showAlert("Database Error", "Could not load seat status");
        }
    }

    // Helper method to show an alert dialog
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void handleCheckoutButton() throws IOException {
        if (selectedSeatsList.isEmpty()) {
            showAlert("No Seats Selected", "Please select at least one seat");
        }
        else {
            // Store selected seats in the database
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
                String reserveQuery = "INSERT INTO seat_reservations (show_id, seat_number, is_reserved,user_email) " +
                        "VALUES (?, ?, true,?) " +
                        "ON DUPLICATE KEY UPDATE is_reserved = true";

                PreparedStatement reserveStmt = conn.prepareStatement(reserveQuery);
                for (String seatNumber : selectedSeatsList) {
                    reserveStmt.setInt(1, ShowId);
                    reserveStmt.setString(2, seatNumber);
                    reserveStmt.setString(3, email);
                    reserveStmt.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                showAlert("Database Error", "Could not reserve seats in the database");
                return; // Exit the method if there was an error
            }

            // Proceed to payment screen
//            Stage currentStage = (Stage) checkoutButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PaymentFrame.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 450, 350);
            Stage paymentFrame = new Stage();
            paymentFrame.setTitle("Payment");
            paymentFrame.setScene(scene);
            paymentFrame.setResizable(false);
            paymentFrame.show();
//            currentStage.close();

            PaymentController controller = fxmlLoader.getController();
            controller.movietransmission2(moviename, duration, agelimit, screennumber, category, timing,email,total);
            controller.setSelectedSeats(selectedSeatsList);
        }
    }

    private void handleSeatSelection(String seatNumber) {
        ToggleButton selectedButton = seatButtons.get(seatNumber);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            if (isSeatReserved(conn, seatNumber)) {
                handleReservedSeat(selectedButton);
                return;
            }

            toggleSeatSelection(selectedButton, seatNumber);
            updateTotal();

        } catch (SQLException e) {
            showAlert("Reservation Error", "Could not reserve seat");
            selectedButton.setSelected(false);
        }
    }

    private boolean isSeatReserved(Connection conn, String seatNumber) throws SQLException {
        String checkQuery = "SELECT is_reserved FROM seat_reservations WHERE seat_number = ? AND show_id = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, seatNumber);
            checkStmt.setInt(2, ShowId);
            ResultSet rs = checkStmt.executeQuery();
            return rs.next() && rs.getBoolean("is_reserved");
        }
    }

    private void handleReservedSeat(ToggleButton selectedButton) {
        selectedButton.setStyle("-fx-background-color: red;");
        selectedButton.setSelected(false);
        showAlert("Seat Unavailable", "This seat is already reserved");
    }

    private void toggleSeatSelection(ToggleButton selectedButton, String seatNumber) {
        if (selectedButton.isSelected()) {
            selectedSeatsList.add(seatNumber);
            selectedButton.setStyle("-fx-background-color: green");
        } else {
            selectedSeatsList.remove(seatNumber);
            selectedButton.setStyle(""); // Reset to default style
        }
    }

    private void updateTotal() {
        total = selectedSeatsList.size()* SEAT_PRICE;
        totalLabel.setText(String.format("Total: %.2f", total));
    }
}