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

public class StudentController implements Initializable {



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
    private Menu activityLogButton;

    @FXML
    private Button addStudentButton;

    @FXML
    private TableColumn<Student,String> address;


    @FXML
    private TableColumn<Student, SimpleDateFormat> dob;

    @FXML
    private Button editStudentButton;

    @FXML
    private TableColumn<Student,String> emergency_contact;

    @FXML
    private TextField filterField;

    @FXML
    private Button findStudent;

    @FXML
    private TableColumn<Student,String> first_name;

    @FXML
    private TableColumn<Student,String> gender;

    @FXML
    private Menu homeButton;

    @FXML
    private Menu hostelStaffButton;

    @FXML
    private TableColumn<Student,String> hostel_name;

    @FXML
    private TableColumn<Student,String> last_name;

    @FXML
    private Menu logOutButton;

    @FXML
    private TableColumn<Student,String> phone_number;

    @FXML
    private TableColumn<?, ?> phone_number_secondary;

    @FXML
    private Menu roomButton;

    @FXML
    private TableColumn<Student,Integer> room_number;

    @FXML
    private TableView<Student> studentView;

    @FXML
    private TableColumn<Student,Integer> student_ID;

    @FXML
    private Menu studentsButton;



    @FXML
    void openAddStudent(ActionEvent event) throws IOException {
        Stage stage = (Stage) findStudent.getScene().getWindow();
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
        newStage.setTitle("Add Student");
        newStage.setScene(new Scene(root, 800, 600));
        newStage.setMaximized(true);
        stage.close();
        newStage.show();
    }

    @FXML
    void openEditStudent(ActionEvent event) throws IOException {
        Stage stage = (Stage) findStudent.getScene().getWindow();
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("EditStudent.fxml"));
        newStage.setTitle("Edit Student");
        newStage.setScene(new Scene(root, 800, 600));
        newStage.setMaximized(true);
        stage.close();
        newStage.show();

    }

    private static Connection conn;

    static {
        try {
            conn = DbConnection.dbConnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private ObservableList<Student> data;



    @FXML
    private void populateStudent(Student st) throws ClassNotFoundException {
        ObservableList<Student> studentData = FXCollections.observableArrayList();
        studentData.add(st);
        this.studentView.setItems(studentData);
    }

    private void populateStudents() {
        try {
            String sql = "SELECT * FROM STUDENT";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            this.data = FXCollections.observableArrayList();

            while(resultSet.next()) {
                Student studentInstance = new Student(resultSet.getInt("student_ID"), resultSet.getString("first_name"),resultSet.getString("last_name"), resultSet.getInt("hostel_ID"), resultSet.getInt("room_number"), resultSet.getString("dob"), resultSet.getInt("age"), resultSet.getString("gender"),resultSet.getString("address"),resultSet.getString("emergency_contact"),resultSet.getInt("fees"));
                this.data.add(studentInstance);
            }
        } catch (SQLException var5) {
            System.out.println("Connection Failed! Check output console" + var5.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.populateStudents();
        this.student_ID.setCellValueFactory(new PropertyValueFactory<Student,Integer>("student_ID"));
        this.first_name.setCellValueFactory(new PropertyValueFactory<Student,String>("first_name"));
        this.last_name.setCellValueFactory(new PropertyValueFactory<Student,String>("last_name"));
        this.room_number.setCellValueFactory(new PropertyValueFactory<Student,Integer>("room_number"));
        this.dob.setCellValueFactory(new PropertyValueFactory<Student,SimpleDateFormat>("dob"));
        this.gender.setCellValueFactory(new PropertyValueFactory<Student,String>("gender"));
        this.address.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));
        this.emergency_contact.setCellValueFactory(new PropertyValueFactory<Student,String>("emergency_contact"));

        this.hostel_name.setCellValueFactory(new PropertyValueFactory<Student,String>("hostel_name"));
        this.phone_number.setCellValueFactory(new PropertyValueFactory<Student,String>("phone_number"));
        this.studentView.setItems(this.data);
    }

    @FXML
    protected void findByStudentID() {
        String search = this.filterField.getText().toString();

        try {
            String sql = "SELECT * FROM STUDENT WHERE \"Student_ID\"=" + Integer.parseInt(search);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            this.data = FXCollections.observableArrayList();

            while(resultSet.next()) {
                Student studentInstance = new Student(resultSet.getInt("student_ID"), resultSet.getString("first_name"),resultSet.getString("last_name"), resultSet.getInt("hostel_ID"), resultSet.getInt("room_number"), resultSet.getString("dob"), resultSet.getInt("age"), resultSet.getString("gender"),resultSet.getString("address"),resultSet.getString("emergency_contact"),resultSet.getInt("fees"));
                this.data.add(studentInstance);
            }
        } catch (SQLException var6) {
            System.out.println("Connection Failed! Check output console" + var6.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.studentView.setItems(this.data);
    }

    static {
        try {
            conn = DbConnection.dbConnect();
        } catch (SQLException var1) {
            throw new RuntimeException(var1);
        } catch (ClassNotFoundException var2) {
            throw new RuntimeException(var2);
        }
    }

}
