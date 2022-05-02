package com.example.hostel_management_system;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddActivityController implements Initializable {

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
    private Menu ActivityButton;

    @FXML
    private TextField Activity_textfield;

    @FXML
    private Button addActivityButton;

    @FXML
    private TextField check_In_Time_textfield;

    @FXML
    private TextField check_Out_Time_textfield;

    @FXML
    private AnchorPane error_message;

    @FXML
    private Label error_msg;

    @FXML
    private TextField first_name_textfield;

    @FXML
    private Menu homeButton;

    @FXML
    private Menu hostelStaffButton;

    @FXML
    private Menu logOutButton;

    @FXML
    private Menu roomButton;

    @FXML
    private TextField student_ID_textfield;

    @FXML
    private Menu studentsButton;

    @FXML
    void OpenRoom(ActionEvent event) {

    }

    @FXML
    void addNewActivity(ActionEvent event) {

        Integer student_ID = Integer.parseInt(this.student_ID_textfield.getText().toString());
        String check_in = this.check_In_Time_textfield.getText().toString();
        String check_out = this.check_Out_Time_textfield.getText().toString();


        ObservableList<StudentActivity> data;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try
        {
            Connection conn = DbConnection.dbConnect();
            String sql3 = "SELECT * FROM STUDENT WHERE \"Student_ID\" = "+ student_ID ;
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql3);
            ResultSet checkIDSet = preparedStatement.executeQuery();

            //resultSet.next();
            if(checkIDSet.next()) {
                String sql = "INSERT INTO STUDENTACTIVITY VALUES (" + student_ID + ",TIMESTAMP \'" + check_out + "\'" +",TIMESTAMP \'" + check_in + "\')";
                preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
                preparedStatement.executeQuery();


                Stage stage = (Stage)this.addActivityButton.getScene().getWindow();
                Stage newStage = new Stage();
                Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("ActivityLogPage.fxml"));
                newStage.setTitle("Activity Log Page");
                newStage.setScene(new Scene(root, 800.0, 600.0));
                newStage.setMaximized(true);
                stage.close();
                newStage.show();

            }
            else  {
                error_msg.setText("The given Student ID was not found in the Database! Try Again");
            }
        }
        catch(SQLException var20)
        {
            System.out.println("Connection Failed! Check output console" + var20.getMessage());
            error_msg.setText(var20.getMessage());
            return;
        }
        catch (ClassNotFoundException var21) {
            var21.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
