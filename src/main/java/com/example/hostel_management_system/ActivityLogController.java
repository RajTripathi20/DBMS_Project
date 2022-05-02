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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class ActivityLogController implements Initializable {

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
        Stage stage = (Stage) addActivityButton.getScene().getWindow();
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
        Stage stage = (Stage) addActivityButton.getScene().getWindow();
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
        Stage stage = (Stage) addActivityButton.getScene().getWindow();
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
        Stage stage = (Stage) addActivityButton.getScene().getWindow();
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
        Stage stage = (Stage) addActivityButton.getScene().getWindow();
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
        Stage home = (Stage) addActivityButton.getScene().getWindow();
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
    private TableColumn<StudentActivity, String> check_Out_Time;

    @FXML
    private TableColumn<?, ?> activity;

    @FXML
    private Button addActivityButton;

    @FXML
    private TableColumn<StudentActivity, String> check_In_Time;

    @FXML
    private TextField filterField;

    @FXML
    private TableColumn<StudentActivity, String> first_name;

    @FXML
    private TableView<StudentActivity> studentActivityView;

    @FXML
    private TableColumn<StudentActivity, Integer> student_ID;

    @FXML
    private Button searchButton;


    @FXML
    void searchByStudentID(ActionEvent event) {
        String search = this.filterField.getText().toString();

        try {
            String sql = "SELECT * FROM STUDENTACTIVITY WHERE \"Student_ID\"= " + Integer.parseInt(search);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            this.data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                StudentActivity studentActivityInstance = new StudentActivity(resultSet.getInt("Student_ID"), resultSet.getString("Check_Out"), resultSet.getString("Check_In"));
                this.data.add(studentActivityInstance);
            }
        } catch (SQLException var6) {
            System.out.println("Connection Failed! Check output console" + var6.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.studentActivityView.setItems(this.data);

    }

    @FXML
    protected void OpenAddActivity() throws IOException {
        Stage home = (Stage) addActivityButton.getScene().getWindow();
        Stage room = new Stage();
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("RoomsPage.fxml"));
        //FXMLLoader loader = new FXMLLoader( getClass().getResource( "target/classes/com/example/hostel_management_system/RoomsPage.fxml" ) );
        //Parent root = loader.load();
        Parent root = FXMLLoader.load(getClass().getResource("AddActivity.fxml"));
        room.setTitle("Add Activity");
        room.setScene(new Scene(root, 800, 600));
        room.setMaximized(true);
        home.close();
        room.show();
    }


    private static Connection conn;


    private ObservableList<StudentActivity> data;

    static {
        try {
            conn = DbConnection.dbConnect();
        } catch (SQLException var1) {
            throw new RuntimeException(var1);
        } catch (ClassNotFoundException var2) {
            throw new RuntimeException(var2);
        }
    }

    private void populateStudentActivities() {
        try {
            String sql = "SELECT * FROM STUDENTACTIVITY";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            this.data = FXCollections.observableArrayList();

            while(resultSet.next()) {
                StudentActivity studentActivityInstance = new StudentActivity(resultSet.getInt("Student_ID"), resultSet.getString("Check_Out"), resultSet.getString("Check_In"));
                this.data.add(studentActivityInstance);
            }
        } catch (SQLException var5) {
            System.out.println("Connection Failed! Check output console" + var5.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.populateStudentActivities();
        this.student_ID.setCellValueFactory(new PropertyValueFactory<StudentActivity,Integer>("student_ID"));
        this.check_In_Time.setCellValueFactory(new PropertyValueFactory<StudentActivity,String>("check_in"));
        this.check_Out_Time.setCellValueFactory(new PropertyValueFactory<StudentActivity,String>("check_out"));

        this.first_name.setCellValueFactory(new PropertyValueFactory<StudentActivity,String>("first_name"));

        this.studentActivityView.setItems(this.data);


    }
}
