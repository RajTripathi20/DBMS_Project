package com.example.hostel_management_system;

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
import java.text.ParseException;
import java.util.ResourceBundle;

public class ModifyStudentController implements Initializable {

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
        Stage stage = (Stage) deleteStudentButton.getScene().getWindow();
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
        Stage stage = (Stage) deleteStudentButton.getScene().getWindow();
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
        Stage stage = (Stage) deleteStudentButton.getScene().getWindow();
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
        Stage stage = (Stage) deleteStudentButton.getScene().getWindow();
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
        Stage stage = (Stage) deleteStudentButton.getScene().getWindow();
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
        Stage home = (Stage) deleteStudentButton.getScene().getWindow();
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
    private Label error_msg;

    @FXML
    private Menu activityLogButton;

    @FXML
    private TextField address_textfield;

    @FXML
    private Button deleteStudentButton;

    @FXML
    private TextField dob_textfield;

    @FXML
    private Button editStudentButton;

    @FXML
    private TextField emergency_contact_textfield;

    @FXML
    private TextField first_name_textfield;

    @FXML
    private TextField gender_textfield;

    @FXML
    private Menu homeButton;

    @FXML
    private Menu hostelStaffButton;

    @FXML
    private TextField hostel_ID_textfield;

    @FXML
    private TextField last_name_textfield;

    @FXML
    private Menu logOutButton;

    @FXML
    private TextField phone_number_primary_textfield;

    @FXML
    private TextField phone_number_secondary_textfield;

    @FXML
    private Menu roomButton;

    @FXML
    private TextField room_number_textfield;

    @FXML
    private TextField student_ID_textfield;

    @FXML
    private Menu studentsButton;



    //System.out.println(dob_textfield.getText().toString());
    //Integer age = Integer.parseInt(age_textfield.getText().toString());






    @FXML
    void DeleteStudent(ActionEvent event) throws IOException, ParseException, SQLException, ClassNotFoundException {
        Integer student_ID = Integer.parseInt(student_ID_textfield.getText().toString());

        ObservableList<Student> data;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        Connection conn = DbConnection.dbConnect();
        try {

            String sql = "UPDATE ROOM SET \"Status\" =" + "\'" + "Not Occupied" + "\', " + "\"Student_ID\" =" + " NULL " + " WHERE \"Student_ID\" =" + student_ID ;
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            System.out.println("done");
            resultSet.next();

            String sql2 = "DELETE FROM STDPHONENO WHERE \"Student_ID\" =" + student_ID ;
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql2);
            resultSet = preparedStatement.executeQuery();System.out.println("done");
            resultSet.next();

            String sql3 = "DELETE FROM STUDENTACTIVITY WHERE \"Student_ID\" =" + student_ID ;
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql3);
            resultSet = preparedStatement.executeQuery();
            System.out.println("done");
            resultSet.next();


            String sql1 = "DELETE FROM STUDENT WHERE \"Student_ID\" ="  + student_ID ;
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql1);
            resultSet = preparedStatement.executeQuery();
            System.out.println("done");
            resultSet.next();





            Stage stage = (Stage) editStudentButton.getScene().getWindow();
            Stage newStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("StudentsPage.fxml"));
            newStage.setTitle("Students Page");
            newStage.setScene(new Scene(root, 800, 600));
            newStage.setMaximized(true);
            stage.close();
            newStage.show();
        }
        catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console" + ex.getMessage());
            //error_msg.setText("Constraints Violated");
            return;
            //JOptionPane.showMessageDialog(null, "Connection Error",  "Error", JOptionPane.WARNING_MESSAGE);
        } /*catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }



    @FXML
    void EditStudent(ActionEvent event) throws IOException, ParseException{
        Integer student_ID = Integer.parseInt(student_ID_textfield.getText().toString());
        String first_name = first_name_textfield.getText().toString();
        String last_name = last_name_textfield.getText().toString();
        String dob = dob_textfield.getText().toString();
        String address = address_textfield.getText().toString();
        String gender = gender_textfield.getText().toString();
        String phone_number = phone_number_primary_textfield.getText().toString();
        String emergency_contact = emergency_contact_textfield.getText().toString();
        Integer hostel_ID = Integer.parseInt(hostel_ID_textfield.getText().toString());
        Integer room_number = Integer.parseInt(room_number_textfield.getText().toString());

        ObservableList<Student> data;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            Connection conn = DbConnection.dbConnect();

            String sql4 = "SELECT * FROM ROOM WHERE \"Room_Number\" = "+ room_number +" AND \"Hostel_ID\" ="+ hostel_ID ;
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql4);
            resultSet = preparedStatement.executeQuery();
            //System.out.println("done");
            resultSet.next();
            String status = resultSet.getString("Status");
            //System.out.println(status);

            String sql5 = "SELECT * FROM HOSTEL WHERE \"Hostel_ID\" = "+ hostel_ID ;
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql5);
            resultSet = preparedStatement.executeQuery();
            //System.out.println("done");
            resultSet.next();
            String gender_hostel = resultSet.getString("Gender");
            //System.out.println(gender_hostel);

            if ( status.equals("Not Occupied") && gender.equals(gender_hostel))  {

                String sql1 = "UPDATE STUDENT SET \"First_Name\" =" + "\'" + first_name + "\', " + "\"Last_Name\" =" + "\'"+ last_name + "\'," + "\"DOB\" = "+ "\'"+ dob + "\',"+ "\"Address\" = " + "\'" + address + "\',"+"\"Gender\"="+"\'"+gender+"\',"+ "\"Emergency_Contact\"="+"\'"+emergency_contact+"\',"+"\"Hostel_ID\"="+ hostel_ID+","+"\"Room_Number\"="+ room_number +" WHERE \"Student_ID\" =" + student_ID ;
                preparedStatement = (PreparedStatement) conn.prepareStatement(sql1);
                resultSet = preparedStatement.executeQuery();
                System.out.println("done Student");

                String sql2 = "UPDATE STDPHONENO SET \"Phone_Number\" =" + "\'" + phone_number  +"\'"+ " WHERE \"Student_ID\" =" + student_ID ;
                preparedStatement = (PreparedStatement) conn.prepareStatement(sql2);
                resultSet = preparedStatement.executeQuery();
                System.out.println("done stdphoneno");

                String sql3 = "UPDATE ROOM SET \"Status\" =" + "\'" + "Not Occupied" + "\', " + "\"Student_ID\" =" + " NULL" + " WHERE \"Student_ID\" =" + student_ID ;
                preparedStatement = (PreparedStatement) conn.prepareStatement(sql3);
                resultSet = preparedStatement.executeQuery();
                System.out.println("done not occupied");

                String sql6 = "UPDATE ROOM SET \"Status\" = " + "\'" + "Occupied" + "\', " + "\"Student_ID\" = " + student_ID + " WHERE \"Room_Number\" = " + room_number + " AND \"Hostel_ID\" = " + hostel_ID;
                preparedStatement = (PreparedStatement) conn.prepareStatement(sql6);
                resultSet = preparedStatement.executeQuery();
                System.out.println("done occupied");



                Stage stage = (Stage) editStudentButton.getScene().getWindow();
                Stage newStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("StudentsPage.fxml"));
                newStage.setTitle("Students Page");
                newStage.setScene(new Scene(root, 800, 600));
                newStage.setMaximized(true);
                stage.close();
                newStage.show();
            }
            else if(gender.equals(gender_hostel)&& status.equals("Occupied") ) {
                error_msg.setText("Room Occupied! Try Again");
            }
            else if(!gender.equals(gender_hostel)&& status.equals("Not Occupied") ) {
                error_msg.setText("Wrong Hostel Gender! Try Again");
            }
            else{
                error_msg.setText("Wrong Hostel Gender And Room Occupied! Try Again");
            }
        }
        catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console" + ex.getMessage());
            error_msg.setText(ex.getMessage());
            //error_msg.setText("Constraints Violated");
            return;
            //JOptionPane.showMessageDialog(null, "Connection Error",  "Error", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
