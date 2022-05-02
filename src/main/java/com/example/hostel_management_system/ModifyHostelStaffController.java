package com.example.hostel_management_system;

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

public class ModifyHostelStaffController implements Initializable {

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
        Stage stage = (Stage) deleteHostelStaffButton.getScene().getWindow();
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
        Stage stage = (Stage) deleteHostelStaffButton.getScene().getWindow();
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
        Stage stage = (Stage) deleteHostelStaffButton.getScene().getWindow();
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
        Stage stage = (Stage) deleteHostelStaffButton.getScene().getWindow();
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
        Stage stage = (Stage) deleteHostelStaffButton.getScene().getWindow();
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
        Stage home = (Stage) deleteHostelStaffButton.getScene().getWindow();
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
    private TextField age_textfield;

    @FXML
    private Button deleteHostelStaffButton;

    @FXML
    private Button editHostelStaffButton;

    @FXML
    private TextField employee_ID_textfield;

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
    private TextField primary_phoneNo_textfield;

    @FXML
    private Menu roomButton;

    @FXML
    private TextField salary_textfield;

    @FXML
    private TextField secndary_phoneNo_textfield;

    @FXML
    private Menu studentsButton;

    @FXML
    private TextField work_textfield;

    @FXML
    void DeleteHostelStaff(ActionEvent event) throws IOException {
        Integer employee_ID = Integer.parseInt(this.employee_ID_textfield.getText().toString());

        try
        {
            Connection conn = DbConnection.dbConnect();
            String sql1 = "UPDATE HOSTEL SET \"Number_of_Workers\" = \"Number_of_Workers\" - 1, \"Annual_Expense\" = \"Annual_Expense\" - (SELECT \"Salary\" FROM HSTAFFSAL WHERE \"Work\"=(SELECT \"Work\" FROM HOSTELSTAFF WHERE \"Employee_ID\" ="  + employee_ID + ")) WHERE \"Hostel_ID\"= (SELECT \"Hostel_ID\" FROM HOSTELSTAFF WHERE \"Employee_ID\" =" + employee_ID + ")";
            PreparedStatement preparedStatement = conn.prepareStatement(sql1);
            preparedStatement.executeQuery();
            System.out.println("done 1");

            String sql2 = "DELETE FROM HSTAFFPHONENO WHERE \"Employee_ID\" =" + employee_ID ;
            preparedStatement = conn.prepareStatement(sql2);
            preparedStatement.executeQuery();
            System.out.println("done 2");

            String sql3 = "DELETE FROM HOSTELSTAFF WHERE \"Employee_ID\" =" + employee_ID;
            preparedStatement = conn.prepareStatement(sql3);
            preparedStatement.executeQuery();
            System.out.println("done 3");


        }
        catch(SQLException var20)
        {
            System.out.println("Connection Failed! Check output console" + var20.getMessage());
            return;
        }
        catch (ClassNotFoundException var21) {
            var21.printStackTrace();
        }

        Stage stage = (Stage)this.deleteHostelStaffButton.getScene().getWindow();
        Stage newStage = new Stage();
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("HostelStaffPage.fxml"));
        newStage.setTitle("Hostel Staff Page");
        newStage.setScene(new Scene(root, 800.0, 600.0));
        newStage.setMaximized(true);
        stage.close();
        newStage.show();
    }

    @FXML
    void EditHostelStaff(ActionEvent event) throws IOException {
        String first_name = this.first_name_textfield.getText().toString();
        String last_name = this.last_name_textfield.getText().toString();
        Integer age = Integer.parseInt(this.age_textfield.getText().toString());
        String gender = this.gender_textfield.getText().toString();
        String phone_number = this.primary_phoneNo_textfield.getText().toString();
        //String secondary_phone_number = this.secndary_phoneNo_textfield.getText().toString();
        String work = this.work_textfield.getText().toString();
        Integer hostel_ID = Integer.parseInt(this.hostel_ID_textfield.getText().toString());
        Integer employee_ID = Integer.parseInt(this.employee_ID_textfield.getText().toString());

        try
        {
            Connection conn = DbConnection.dbConnect();
            String sql1 = "UPDATE HOSTEL SET \"Annual_Expense\" = \"Annual_Expense\" - (SELECT \"Salary\" FROM HSTAFFSAL WHERE \"Work\" = (SELECT \"Work\" FROM HOSTELSTAFF WHERE \"Employee_ID\" = " + employee_ID + " )) WHERE \"Hostel_ID\" = (SELECT \"Hostel_ID\" FROM HOSTELSTAFF WHERE \"Employee_ID\" = " + employee_ID + " )";
            PreparedStatement preparedStatement = conn.prepareStatement(sql1);
            System.out.println("done 1");
            preparedStatement.executeQuery();
            String sql2 = "UPDATE HOSTEL SET \"Annual_Expense\" = \"Annual_Expense\" + (SELECT \"Salary\" FROM HSTAFFSAL WHERE \"Work\" = \'"+ work + "\') WHERE \"Hostel_ID\" =" + hostel_ID;
            preparedStatement = conn.prepareStatement(sql2);
            preparedStatement.executeQuery();
            System.out.println("done 2");

            String sql3 = "UPDATE HOSTELSTAFF SET \"First_Name\" = \'" + first_name + "\', \"Last_Name\" = \'" + last_name + "\', \"Gender\" = \'" + gender + "\', \"Hostel_ID\" =" + hostel_ID + ", \"Age\" =" + age + ", \"Work\" = \'" + work + "\' WHERE \"Employee_ID\" = " +  employee_ID;
            preparedStatement = conn.prepareStatement(sql3);
            preparedStatement.executeQuery();
            System.out.println("done 3");


            String sql4 = "UPDATE HSTAFFPHONENO SET \"Phone_Number\" = \'" + phone_number + "\' WHERE \"Employee_ID\" = "+ employee_ID;
            preparedStatement = conn.prepareStatement(sql4);
            preparedStatement.executeQuery();
            System.out.println("done 4");


        }
        catch(SQLException var20)
        {
            System.out.println("Connection Failed! Check output console" + var20.getMessage());
            error_msg.setText(var20.getMessage());
            return;
        }
        catch (ClassNotFoundException var21) {
            var21.printStackTrace();
        }

        Stage stage = (Stage)this.editHostelStaffButton.getScene().getWindow();
        Stage newStage = new Stage();
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("HostelStaffPage.fxml"));
        newStage.setTitle("Hostel Staff Page");
        newStage.setScene(new Scene(root, 800.0, 600.0));
        newStage.setMaximized(true);
        stage.close();
        newStage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}