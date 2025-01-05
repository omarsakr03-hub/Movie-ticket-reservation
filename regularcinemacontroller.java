package com.example.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.util.Pair;
import java.util.Map;
import java.sql.*;

public class regularcinemacontroller implements Initializable {


    @FXML
    private ToggleButton toggleButton1;

    @FXML
    private ToggleButton toggleButton10;

    @FXML
    private ToggleButton toggleButton11;

    @FXML
    private ToggleButton toggleButton12;

    @FXML
    private ToggleButton toggleButton13;

    @FXML
    private ToggleButton toggleButton14;

    @FXML
    private ToggleButton toggleButton15;

    @FXML
    private ToggleButton toggleButton16;

    @FXML
    private ToggleButton toggleButton17;

    @FXML
    private ToggleButton toggleButton18;

    @FXML
    private ToggleButton toggleButton19;

    @FXML
    private ToggleButton toggleButton2;

    @FXML
    private ToggleButton toggleButton20;

    @FXML
    private ToggleButton toggleButton21;

    @FXML
    private ToggleButton toggleButton22;

    @FXML
    private ToggleButton toggleButton23;

    @FXML
    private ToggleButton toggleButton24;

    @FXML
    private ToggleButton toggleButton25;

    @FXML
    private ToggleButton toggleButton26;

    @FXML
    private ToggleButton toggleButton27;

    @FXML
    private ToggleButton toggleButton28;

    @FXML
    private ToggleButton toggleButton29;

    @FXML
    private ToggleButton toggleButton3;

    @FXML
    private ToggleButton toggleButton30;

    @FXML
    private ToggleButton toggleButton31;

    @FXML
    private ToggleButton toggleButton32;

    @FXML
    private ToggleButton toggleButton33;

    @FXML
    private ToggleButton toggleButton34;

    @FXML
    private ToggleButton toggleButton35;

    @FXML
    private ToggleButton toggleButton36;

    @FXML
    private ToggleButton toggleButton37;

    @FXML
    private ToggleButton toggleButton38;

    @FXML
    private ToggleButton toggleButton39;

    @FXML
    private ToggleButton toggleButton4;

    @FXML
    private ToggleButton toggleButton40;

    @FXML
    private ToggleButton toggleButton41;

    @FXML
    private ToggleButton toggleButton42;

    @FXML
    private ToggleButton toggleButton43;

    @FXML
    private ToggleButton toggleButton44;

    @FXML
    private ToggleButton toggleButton45;

    @FXML
    private ToggleButton toggleButton46;

    @FXML
    private ToggleButton toggleButton47;

    @FXML
    private ToggleButton toggleButton48;

    @FXML
    private ToggleButton toggleButton49;

    @FXML
    private ToggleButton toggleButton5;

    @FXML
    private ToggleButton toggleButton50;

    @FXML
    private ToggleButton toggleButton51;

    @FXML
    private ToggleButton toggleButton52;

    @FXML
    private ToggleButton toggleButton53;

    @FXML
    private ToggleButton toggleButton54;

    @FXML
    private ToggleButton toggleButton55;

    @FXML
    private ToggleButton toggleButton56;

    @FXML
    private ToggleButton toggleButton57;

    @FXML
    private ToggleButton toggleButton58;

    @FXML
    private ToggleButton toggleButton59;

    @FXML
    private ToggleButton toggleButton6;

    @FXML
    private ToggleButton toggleButton60;

    @FXML
    private ToggleButton toggleButton7;

    @FXML
    private ToggleButton toggleButton8;

    @FXML
    private ToggleButton toggleButton9;
    @FXML
    private ToggleButton[] toggleButtons;
    @FXML
    private Button backButton;
    @FXML
    private Button checkoutButton;
    @FXML
    private ListView<String> StandardListView;
    @FXML
    private Label movienamedate;
    @FXML
    private ImageView regimage;
    @FXML
    private Label totalLabel;

    private String actiontype;
    private String moviename;
    public String duration;
    public String agelimit;
    public String screennumber;
    public String category;
    public String timing;
    public String email;
    public int ShowId=0;

    private static final int SEAT_PRICE = 100; // Adjust the seat price as needed
    private HashSet<String> selectedSeats= new HashSet<>();
    @FXML
    private Label regularlabel;
    Image image1 = new Image(getClass().getResourceAsStream("/images/now1.jpg"));
    Image image2 = new Image(getClass().getResourceAsStream("/images/now2.jpg"));
    Image image3 = new Image(getClass().getResourceAsStream("/images/now3.jpg"));
    Image image4 = new Image(getClass().getResourceAsStream("/images/now4.jpg"));
    Image image5 = new Image(getClass().getResourceAsStream("/images/now5.jpg"));
    Image image6 = new Image(getClass().getResourceAsStream("/images/now6.jpg"));

    private static final String DB_URL = "jdbc:mysql://localhost:3306/cinema_booking";
    private static final String USER = "root";
    private static final String PASS = "123456789";

    private ObservableList<String> selectedSeatsList = FXCollections.observableArrayList();
    private Map<String, ToggleButton> seatButtons = new HashMap<>();
    public double total;

    public regularcinemacontroller() {
        // Initialization code (if any)
    }
    public regularcinemacontroller(ListView<String> standardListView) {
        StandardListView = standardListView;
    }
    public void setActiontype(String actiontype) {
        this.actiontype = actiontype;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize the ListView
        StandardListView.setItems(selectedSeatsList);
        initializeToggleButtons();

        loadSeatStatus(); // Load initial seat status from the database
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
        seatButtons.put("A9", toggleButton9);
        seatButtons.put("A10", toggleButton10);

        seatButtons.put("B1", toggleButton11);
        seatButtons.put("B2", toggleButton12);
        seatButtons.put("B3", toggleButton13);
        seatButtons.put("B4", toggleButton14);
        seatButtons.put("B5", toggleButton15);
        seatButtons.put("B6", toggleButton16);
        seatButtons.put("B7", toggleButton17);
        seatButtons.put("B8", toggleButton18);
        seatButtons.put("B9", toggleButton19);
        seatButtons.put("B10", toggleButton20);

        seatButtons.put("C1", toggleButton21);
        seatButtons.put("C2", toggleButton22);
        seatButtons.put("C3", toggleButton23);
        seatButtons.put("C4", toggleButton24);
        seatButtons.put("C5", toggleButton25);
        seatButtons.put("C6", toggleButton26);
        seatButtons.put("C7", toggleButton27);
        seatButtons.put("C8", toggleButton28);
        seatButtons.put("C9", toggleButton29);
        seatButtons.put("C10", toggleButton30);

        seatButtons.put("D1", toggleButton31);
        seatButtons.put("D2", toggleButton32);
        seatButtons.put("D3", toggleButton33);
        seatButtons.put("D4", toggleButton34);
        seatButtons.put("D5", toggleButton35);
        seatButtons.put("D6", toggleButton36);
        seatButtons.put("D7", toggleButton37);
        seatButtons.put("D8", toggleButton38);
        seatButtons.put("D9", toggleButton39);
        seatButtons.put("D10", toggleButton40);

        seatButtons.put("E1", toggleButton41);
        seatButtons.put("E2", toggleButton42);
        seatButtons.put("E3", toggleButton43);
        seatButtons.put("E4", toggleButton44);
        seatButtons.put("E5", toggleButton45);
        seatButtons.put("E6", toggleButton46);
        seatButtons.put("E7", toggleButton47);
        seatButtons.put("E8", toggleButton48);
        seatButtons.put("E9", toggleButton49);
        seatButtons.put("E10", toggleButton50);

        seatButtons.put("F1", toggleButton51);
        seatButtons.put("F2", toggleButton52);
        seatButtons.put("F3", toggleButton53);
        seatButtons.put("F4", toggleButton54);
        seatButtons.put("F5", toggleButton55);
        seatButtons.put("F6", toggleButton56);
        seatButtons.put("F7", toggleButton57);
        seatButtons.put("F8", toggleButton58);
        seatButtons.put("F9", toggleButton59);
        seatButtons.put("F10", toggleButton60);

        // Add event listeners to each button
        for (Map.Entry<String, ToggleButton> entry : seatButtons.entrySet()) {
            entry.getValue().setOnAction(event -> handleSeatSelection(entry.getKey()));
        }
    }

    public void movietransmission1(String moviename,String duration,String agelimit,String screennumber,String category ,String timing,String email){
        this.moviename=moviename;
        this.duration=duration;
        this.agelimit=agelimit;
        this.screennumber=screennumber;
        this.category=category;
        this.timing=timing;
        this.email=email;
    }
    public void checker() {
        if (actiontype != null) {
            switch (actiontype) {
                case "movie1regular5pm":
                    regularlabel.setText("TEFFIFIER - 5 PM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image1);
                    regimage.setVisible(true);
                    ShowId=1;
                    break;
                case "movie1regular8pm":
                    regularlabel.setText("TEFFIFIER - 8 PM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image1);
                    regimage.setVisible(true);
                    ShowId=2;
                    break;
                case "movie1regular12am":
                    regularlabel.setText("TEFFIFIER - 12 AM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image1);
                    regimage.setVisible(true);
                    ShowId=3;
                    break;
                case "movie2regular5pm":
                    regularlabel.setText("RED ONE - 5 PM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image2);
                    regimage.setVisible(true);
                    ShowId=10;
                    break;
                case "movie2regular8pm":
                    regularlabel.setText("RED ONE - 8 PM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image2);
                    regimage.setVisible(true);
                    ShowId=11;
                    break;
                case "movie2regular12am":
                    regularlabel.setText("RED ONE - 12 AM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image2);
                    regimage.setVisible(true);
                    ShowId=12;
                    break;
                case "movie3regular5pm":
                    regularlabel.setText("GLADIATOR - 5 PM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image3);
                    regimage.setVisible(true);
                    ShowId=19;
                    break;
                case "movie3regular8pm":
                    regularlabel.setText("GLADIATOR - 8 PM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image3);
                    regimage.setVisible(true);
                    ShowId=20;
                    break;
                case "movie3regular12am":
                    regularlabel.setText("GLADIATOR - 12 AM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image3);
                    regimage.setVisible(true);
                    ShowId=21;
                    break;
                case "movie4regular5pm":
                    regularlabel.setText("ELHAWA SULTAN - 5 PM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image4);
                    regimage.setVisible(true);
                    ShowId=28;
                    break;
                case "movie4regular8pm":
                    regularlabel.setText("ELHAWA SULTAN - 8 PM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image4);
                    regimage.setVisible(true);
                    ShowId=29;
                    break;
                case "movie4regular12am":
                    regularlabel.setText("ELHAWA SULTAN - 12 AM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image4);
                    regimage.setVisible(true);
                    ShowId=30;
                    break;
                case "movie5regular5pm":
                    regularlabel.setText("MOANA 2 - 5 PM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image5);
                    regimage.setVisible(true);
                    ShowId=37;
                    break;
                case "movie5regular8pm":
                    regularlabel.setText("MOANA 2 - 8 PM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image5);
                    regimage.setVisible(true);
                    ShowId=38;
                    break;
                case "movie5regular12am":
                    regularlabel.setText("MOANA 2 - 12 AM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image5);
                    regimage.setVisible(true);
                    ShowId=39;
                    break;
                case "movie6regular5pm":
                    regularlabel.setText("ELHAREFA 2 - 5 PM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image6);
                    regimage.setVisible(true);
                    ShowId=46;
                    break;
                case "movie6regular8pm":
                    regularlabel.setText("ELHAREFA 2 - 8 PM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image6);
                    regimage.setVisible(true);
                    ShowId=47;
                    break;
                case "movie6regular12am":
                    regularlabel.setText("ELHAREFA 2 - 12 AM");
                    regularlabel.setFont(Font.font("Arial", FontWeight.BOLD, 13.5));
                    regimage.setImage(image6);
                    regimage.setVisible(true);
                    ShowId=48;
                    break;
            }
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

    private boolean isSeatReserved(Connection conn, String seatNumber) throws SQLException {
        String checkQuery = "SELECT is_reserved FROM seat_reservations WHERE seat_number = ? AND show_id = ?";
        try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, seatNumber);
            checkStmt.setInt(2, ShowId);
            ResultSet rs = checkStmt.executeQuery();
            return rs.next() && rs.getBoolean("is_reserved");
        }
    }

    private void loadSeatStatus() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String query = "SELECT seat_number, is_reserved FROM seat_reservations WHERE show_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, ShowId); // Assume you have the current show ID
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String seatNumber = rs.getString("seat_number");
                    boolean isReserved = rs.getBoolean("is_reserved");

                    ToggleButton button = findToggleButton(seatNumber);
                    if (button != null) {
                        if (isReserved) {
                            button.setDisable(true);
                            button.setStyle("-fx-background-color: red;");
                        } else {
                            button.setStyle(""); // Set to default style
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Database Error", "Could not load seat status");
        }
    }

    private ToggleButton findToggleButton(String seatNumber) {
        for (ToggleButton button : toggleButtons) {
            if (button.getText().equals(seatNumber)) {
                return button;
            }
        }
        return null;
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        // Map of action types to their corresponding FXML and window titles
        Map<String, Pair<String, String>> movieScreenMap = Map.ofEntries(
                Map.entry("movie1regular5pm", new Pair<>("movienow1.fxml", "TERRIFIER 3")),
                Map.entry("movie1regular8pm", new Pair<>("movienow1.fxml", "TERRIFIER 3")),
                Map.entry("movie1regular12am", new Pair<>("movienow1.fxml", "TERRIFIER 3")),
                Map.entry("movie2regular5pm", new Pair<>("movienow2.fxml", "RED ONE")),
                Map.entry("movie2regular8pm", new Pair<>("movienow2.fxml", "RED ONE")),
                Map.entry("movie2regular12am", new Pair<>("movienow2.fxml", "RED ONE")),
                Map.entry("movie3regular5pm", new Pair<>("movienow3.fxml", "GLADIATOR")),
                Map.entry("movie3regular8pm", new Pair<>("movienow3.fxml", "GLADIATOR")),
                Map.entry("movie3regular12am", new Pair<>("movienow3.fxml", "GLADIATOR")),
                Map.entry("movie4regular5pm", new Pair<>("movienow4.fxml", "ELHAWA SULTAN")),
                Map.entry("movie4regular8pm", new Pair<>("movienow4.fxml", "ELHAWA SULTAN")),
                Map.entry("movie4regular12am", new Pair<>("movienow4.fxml", "ELHAWA SULTAN")),
                Map.entry("movie5regular5pm", new Pair<>("movienow5.fxml", "MOANA 2")),
                Map.entry("movie5regular8pm", new Pair<>("movienow5.fxml", "MOANA 2")),
                Map.entry("movie5regular12am", new Pair<>("movienow5.fxml", "MOANA 2")),
                Map.entry("movie6regular5pm", new Pair<>("movienow6.fxml", "ELHAREFA 2")),
                Map.entry("movie6regular8pm", new Pair<>("movienow6.fxml", "ELHAREFA 2")),
                Map.entry("movie6regular12am", new Pair<>("movienow6.fxml", "ELHAREFA 2"))
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
        } else {
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

    private void updateTotal() {
        total = selectedSeatsList.size()* SEAT_PRICE;
        totalLabel.setText(String.format("Total: %.2f", total));
    }

}