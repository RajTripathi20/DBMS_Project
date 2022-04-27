package com.example.hostel_management_system;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class AddStudentController implements Initializable {

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
        Stage stage = (Stage) addStudentButton.getScene().getWindow();
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
        Stage stage = (Stage) addStudentButton.getScene().getWindow();
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
        Stage stage = (Stage) addStudentButton.getScene().getWindow();
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
        Stage stage = (Stage) addStudentButton.getScene().getWindow();
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
        Stage stage = (Stage) addStudentButton.getScene().getWindow();
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
        Stage home = (Stage) addStudentButton.getScene().getWindow();
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

    @FXML
    private Button addStudentButton;

    @FXML
    private TextField address_textfield;

    @FXML
    private TextField dob_textfield;

    @FXML
    private TextField emergency_contact_textfield;

    @FXML
    private TextField first_name_textfield;

    @FXML
    private TextField gender_textfield;

    @FXML
    private Menu homeButton;

    @FXML
    private Menu homeButton1;

    @FXML
    private Menu hostelStaffButton;

    @FXML
    private TextField hostel_ID_textfield;

    @FXML
    private TextField last_name_textfield;

    @FXML
    private Menu logOutButton;

    @FXML
    private TextField primary_phoneNo_textfield;

    @FXML
    private Menu roomButton;

    @FXML
    private TextField room_number_textfield;

    @FXML
    private TextField age_textfield;

    @FXML
    private TextField secondary_phoneNo_textfield;

    @FXML
    private Menu studentsButton;

    @FXML
    void addNewStudent(ActionEvent event) throws IOException, ParseException {

            String first_name = first_name_textfield.getText().toString();
            String last_name = last_name_textfield.getText().toString();
            Integer hostel_ID = Integer.parseInt(hostel_ID_textfield.getText().toString());
            Integer room_number = Integer.parseInt(room_number_textfield.getText().toString());
            Date dob = new SimpleDateFormat("dd-MMM-yyyy").parse(dob_textfield.getText().toString());
            Integer age = Integer.parseInt(age_textfield.getText().toString());
            String gender = gender_textfield.getText().toString();
            String address = address_textfield.getText().toString();
            String emergency_contact = emergency_contact_textfield.getText().toString();
            String phone_number = primary_phoneNo_textfield.getText().toString();







        ObservableList<Room> data;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            Connection conn = DbConnection.dbConnect();
            System.out.println(dob);
            String sql = "INSERT INTO STUDENT VALUES(DEFAULT" + ", \'" + first_name + "\', " + "\'" + last_name + "\', " + hostel_ID + ", " + room_number + ", \'" + dob + "\', " + age + ", \'" + gender + "\', " + "\'" + address + "\', " + "\'" + emergency_contact + "\', " + 2000 + ")";
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            int student_ID = resultSet.getInt("student_ID");
            String sql2 = "INSERT INTO STDPHONENO VALUES(" +  student_ID + ", " + "\'" + phone_number + "\');"+

            "UPDATE ROOM SET \"Status\" =" + "\'" + "Occupied" + "\', " + "\"Student_ID\" =" + student_ID + "WHERE \"Room_Number\" =" + room_number + "AND \"Hostel_ID\" =" + hostel_ID;

            preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console" + ex.getMessage());
            //error_msg.setText("Constraints Violated");
            return;
            //JOptionPane.showMessageDialog(null, "Connection Error",  "Error", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) addStudentButton.getScene().getWindow();
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
