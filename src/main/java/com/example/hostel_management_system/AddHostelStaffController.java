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
import java.util.ResourceBundle;

public class AddHostelStaffController implements Initializable {

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
        Stage stage = (Stage) addHostelStaffButton.getScene().getWindow();
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
        Stage stage = (Stage) addHostelStaffButton.getScene().getWindow();
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
        Stage stage = (Stage) addHostelStaffButton.getScene().getWindow();
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
        Stage stage = (Stage) addHostelStaffButton.getScene().getWindow();
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
        Stage stage = (Stage) addHostelStaffButton.getScene().getWindow();
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
        Stage home = (Stage) addHostelStaffButton.getScene().getWindow();
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
    private Button addHostelStaffButton;

    @FXML
    private TextField age_textfield;

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
    private TextField secndary_phoneNo_textfield;

    @FXML
    private Menu studentsButton;

    @FXML
    private TextField work_textfield;

    @FXML
    void AddHostelStaff(ActionEvent event) throws IOException {
        String first_name = this.first_name_textfield.getText().toString();
        String last_name = this.last_name_textfield.getText().toString();
        Integer age = Integer.parseInt(this.age_textfield.getText().toString());
        String gender = this.gender_textfield.getText().toString();
        String phone_number = this.primary_phoneNo_textfield.getText().toString();
        //String secondary_phone_number = this.secndary_phoneNo_textfield.getText().toString();
        String work = this.work_textfield.getText().toString();
        Integer hostel_ID = Integer.parseInt(this.hostel_ID_textfield.getText().toString());

        ObservableList<Student> data;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try
        {
            Connection conn = DbConnection.dbConnect();
            String sql3 = "SELECT * FROM HOSTEL WHERE \"Hostel_ID\" = "+ hostel_ID ;
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql3);
            ResultSet checkIDSet = preparedStatement.executeQuery();

            String sql4 = "SELECT * FROM HSTAFFSAL WHERE \"Work\" = "+"\'"+ work +"\'" ;
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql4);
            resultSet = preparedStatement.executeQuery();
            System.out.println("done work");
            //resultSet.next();
            if( resultSet.next() && checkIDSet.next()) {
                String sql = "INSERT INTO HOSTELSTAFF VALUES (DEFAULT,\'" + first_name + "\',\'" + last_name + "\',\'" + gender + "\', " + hostel_ID + ", " + age + ", \'" + work + "\')";
                preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                //System.out.println("done");
                resultSet.next();
                System.out.println("done Hostelstaff");


                String sql1 = "SELECT * FROM HOSTELSTAFF WHERE \"Employee_ID\" = (SELECT MAX(\"Employee_ID\") FROM HOSTELSTAFF)";
                preparedStatement = (PreparedStatement) conn.prepareStatement(sql1);
                resultSet = preparedStatement.executeQuery();
                //System.out.println("done");
                resultSet.next();
                System.out.println("done id");
                Integer employee_ID = resultSet.getInt("Employee_ID");
                System.out.println(employee_ID);

                String sql2 = "INSERT INTO HSTAFFPHONENO VALUES (" + employee_ID + ",\'" + phone_number + "\')";
                preparedStatement = (PreparedStatement) conn.prepareStatement(sql2);
                resultSet = preparedStatement.executeQuery();
                //System.out.println("done");
                resultSet.next();
                System.out.println("done phone no.");


                /*String sql3 = "INSERT INTO HSTAFFPHONENO VALUES (" + employee_ID + ",\'" + secondary_phone_number + "\')";
                preparedStatement = conn.prepareStatement(sql3);
                resultSet = preparedStatement.executeQuery();
                System.out.println("done work");
                resultSet.next();

                 */

                String sql5 = "UPDATE HOSTEL SET \"Number_of_Workers\" = \"Number_of_Workers\" + 1, \"Annual_Expense\" = \"Annual_Expense\" + (SELECT \"Salary\" FROM HSTAFFSAL WHERE \"Work\" =\'" + work + "\') WHERE \"Hostel_ID\" =" + hostel_ID;
                preparedStatement = (PreparedStatement) conn.prepareStatement(sql5);
                resultSet = preparedStatement.executeQuery();
                //System.out.println("done");
                resultSet.next();
                System.out.println("done annual expense");

                Stage stage = (Stage)this.addHostelStaffButton.getScene().getWindow();
                Stage newStage = new Stage();
                Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("HostelStaffPage.fxml"));
                newStage.setTitle("Hostel Staff Page");
                newStage.setScene(new Scene(root, 800.0, 600.0));
                newStage.setMaximized(true);
                stage.close();
                newStage.show();

            }
            else if(resultSet.next() && !checkIDSet.next())  {
                error_msg.setText("Hostel ID does not exist! Try Again");
            }
            else if(!resultSet.next() && checkIDSet.next())  {
                error_msg.setText("Wrong work Assigned! Try Again");
            }
            else{
                error_msg.setText("Wrong Work Assigned and Hostel ID does not exist! Try Again");
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
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
