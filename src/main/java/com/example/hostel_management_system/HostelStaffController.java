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

public class HostelStaffController implements Initializable {

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
    private Menu activityLogButton;

    @FXML
    private Button addHostelStaffButton;

    @FXML
    private TableColumn<HostelStaff, String> address;

    @FXML
    private TableColumn<HostelStaff, Integer> age;

    @FXML
    private Button editHostelStaffButton;

    @FXML
    private TableColumn<HostelStaff, Integer> employee_ID;

    @FXML
    private TextField filterField;

    @FXML
    private TableColumn<HostelStaff, String> first_name;

    @FXML
    private TableColumn<HostelStaff, String> gender;

    @FXML
    private Menu homeButton;

    @FXML
    private Menu hostelStaffButton;

    @FXML
    private TableColumn<HostelStaff, String> hostel_name;

    @FXML
    private TableColumn<HostelStaff, String> last_name;

    @FXML
    private Menu logOutButton;

    @FXML
    private TableColumn<HostelStaff, String> phone_number_primary;



    @FXML
    private Menu roomButton;

    @FXML
    private TableColumn<HostelStaff, Integer> salary;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<HostelStaff> hostelStaffView;

    @FXML
    private Menu studentsButton;

    @FXML
    private TableColumn<HostelStaff, String> work;


    @FXML
    void OpenAddHostelStaff(ActionEvent event) throws IOException {
        Stage stage = (Stage) searchButton.getScene().getWindow();
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddHostelStaff.fxml"));
        newStage.setTitle("Add HostelStaff");
        newStage.setScene(new Scene(root, 800, 600));
        newStage.setMaximized(true);
        stage.close();
        newStage.show();

    }

    @FXML
    void OpenEditHostelStaff(ActionEvent event) throws IOException {
        Stage stage = (Stage) searchButton.getScene().getWindow();
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("EditHostelStaff.fxml"));
        newStage.setTitle("Edit HostelStaff");
        newStage.setScene(new Scene(root, 800, 600));
        newStage.setMaximized(true);
        stage.close();
        newStage.show();

    }

    private static Connection conn;


    private ObservableList<HostelStaff> data;


    @FXML
    void homeButton(ActionEvent event) {

    }


    @FXML
    void searchByEmployeeID(ActionEvent event) {
        String search = this.filterField.getText().toString();

        try {
            String sql = "SELECT * FROM HOSTELSTAFF WHERE \"Employee_ID\"=" + Integer.parseInt(search);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            this.data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                HostelStaff hostelStaffInstance = new HostelStaff(resultSet.getInt("employee_ID"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("gender"), resultSet.getInt("hostel_ID"), resultSet.getInt("age"), resultSet.getString("work"));
                this.data.add(hostelStaffInstance);
            }
        } catch (SQLException var6) {
            System.out.println("Connection Failed! Check output console" + var6.getMessage());
        } catch (ParseException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.hostelStaffView.setItems(this.data);


    }
    private void populateHostelStaff() {
        try {
            String sql = "SELECT * FROM HOSTELSTAFF";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            this.data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                HostelStaff hostelStaffInstance = new HostelStaff(resultSet.getInt("employee_ID"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("gender"), resultSet.getInt("hostel_ID"), resultSet.getInt("age"), resultSet.getString("work"));
                this.data.add(hostelStaffInstance);
            }
        } catch (SQLException var5) {
            System.out.println("Connection Failed! Check output console" + var5.getMessage());
        } catch (ParseException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.populateHostelStaff();
        this.employee_ID.setCellValueFactory(new PropertyValueFactory<HostelStaff,Integer>("employee_ID"));
        this.first_name.setCellValueFactory(new PropertyValueFactory<HostelStaff,String>("first_name"));
        this.last_name.setCellValueFactory(new PropertyValueFactory<HostelStaff,String>("last_name"));
        this.gender.setCellValueFactory(new PropertyValueFactory<HostelStaff,String>("gender"));
        this.hostel_name.setCellValueFactory(new PropertyValueFactory<HostelStaff,String>("hostel_name"));
        this.age.setCellValueFactory(new PropertyValueFactory<HostelStaff,Integer>("age"));
        this.work.setCellValueFactory(new PropertyValueFactory<HostelStaff,String>("work"));

        this.salary.setCellValueFactory(new PropertyValueFactory<HostelStaff,Integer>("salary"));
        this.phone_number_primary.setCellValueFactory(new PropertyValueFactory<HostelStaff,String>("phone_number"));

        this.hostelStaffView.setItems(this.data);


    }


    static {
        try {
            conn = DbConnection.dbConnect();
        } catch (SQLException | ClassNotFoundException var1) {
            throw new RuntimeException(var1);
        }
    }
}
