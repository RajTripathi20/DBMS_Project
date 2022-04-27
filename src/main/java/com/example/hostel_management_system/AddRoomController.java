package com.example.hostel_management_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddRoomController implements Initializable {

    @FXML
    private MenuItem activityLogMenu;

    @FXML
    private MenuItem homeMenu;

    @FXML
    private MenuItem hostelStaffMenu;

    @FXML
    private MenuItem logOutMenu;

    @FXML
    private MenuItem roomMenu;

    @FXML
    private MenuItem studentMenu;

    @FXML
    void logOut() throws IOException {
        Stage stage = (Stage) addRoomButton.getScene().getWindow();
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        newStage.setTitle("Login Page");
        newStage.setScene(new Scene(root, 800, 600));
        newStage.setMaximized(true);
        stage.close();
        newStage.show();

    }

    @FXML
    void OpenHome() throws IOException {
        Stage stage = (Stage) addRoomButton.getScene().getWindow();
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        newStage.setTitle("Home Page");
        newStage.setScene(new Scene(root, 800, 600));
        newStage.setMaximized(true);
        stage.close();
        newStage.show();

    }

    @FXML
    void OpenHostelStaff() throws IOException {
        Stage stage = (Stage) addRoomButton.getScene().getWindow();
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("HostelStaffPage.fxml"));
        newStage.setTitle("Hostel Staff Page");
        newStage.setScene(new Scene(root, 800, 600));
        newStage.setMaximized(true);
        stage.close();
        newStage.show();

    }

    @FXML
    void OpenRoom() throws IOException {
        Stage stage = (Stage) addRoomButton.getScene().getWindow();
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("RoomsPage.fxml"));
        newStage.setTitle("Room Page");
        newStage.setScene(new Scene(root, 800, 600));
        newStage.setMaximized(true);
        stage.close();
        newStage.show();

    }

    @FXML
    void OpenStudent() throws IOException {
        Stage stage = (Stage) addRoomButton.getScene().getWindow();
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("StudentsPage.fxml"));
        newStage.setTitle("Student Page");
        newStage.setScene(new Scene(root, 800, 600));
        newStage.setMaximized(true);
        stage.close();
        newStage.show();

    }

    @FXML
    protected void OpenActivityLog() throws IOException {
        Stage home = (Stage) addRoomButton.getScene().getWindow();
        Stage room = new Stage();
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("RoomsPage.fxml"));
        //FXMLLoader loader = new FXMLLoader( getClass().getResource( "target/classes/com/example/hostel_management_system/RoomsPage.fxml" ) );
        //Parent root = loader.load();
        Parent root = FXMLLoader.load(getClass().getResource("ActivityLogPage.fxml"));
        room.setTitle("Activity Log Page");
        room.setScene(new Scene(root, 800, 600));
        room.setMaximized(true);
        home.close();
        room.show();



    }


    private Integer room_number;

    private Integer hostel_ID;

    private String status;

    private Integer floor;

    private Integer student_ID;

    @FXML
    private Button addRoomButton;

    @FXML
    private TextField floor_textfield;

    @FXML
    private Label error_msg;

    @FXML
    private Menu homeButton;

    @FXML
    private Menu hostelStaffButton;

    @FXML
    private TextField hostel_ID_textfield;

    @FXML
    private Menu logOutButton;

    @FXML
    private Menu roomButton;

    @FXML
    private TextField room_number_textfield;

    @FXML
    private TextField status_textfield;

    @FXML
    private TextField student_ID_textfield;

    @FXML
    private Menu studentsButton;

    @FXML
    void addNewRoom(ActionEvent event) throws IOException {
        try {
            room_number = Integer.parseInt(room_number_textfield.getText().toString());
            hostel_ID = Integer.parseInt(hostel_ID_textfield.getText().toString());
            floor = Integer.parseInt(floor_textfield.getText().toString());
        }
        catch(NumberFormatException n) {
            if(room_number_textfield.getText().toString().equals(""))
                room_number = null;
            else if(room_number == null)
                error_msg.setText("Invalid Input Try Again");

            if(hostel_ID_textfield.getText().toString().equals(""))
                hostel_ID = null;
            else if(hostel_ID == null)
                error_msg.setText("Invalid Input Try Again");


            if(floor_textfield.getText().toString().equals(""))
                floor = null;
            else if(floor == null)
                error_msg.setText("Invalid Input Try Again");



        }

        catch(NullPointerException e)  {
            error_msg.setText("Invalid Input Try Again");

        }

        Connection conn;
        ObservableList<Room> data;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            conn = DbConnection.dbConnect();

            String sql = "INSERT INTO ROOM VALUES(" + room_number + ", " + hostel_ID + ", \'"
                    + "Not Occupied" + "\', " + floor + ", " + null + ")";
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            preparedStatement.executeQuery();


        } catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console" + ex.getMessage());
            error_msg.setText("Constraints Violated");
            return;
            //JOptionPane.showMessageDialog(null, "Connection Error",  "Error", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) addRoomButton.getScene().getWindow();
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("RoomsPage.fxml"));
        newStage.setTitle("Home Page");
        newStage.setScene(new Scene(root, 800, 600));
        newStage.setMaximized(true);
        stage.close();
        newStage.show();




    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
