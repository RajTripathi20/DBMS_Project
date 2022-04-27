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
import java.util.ResourceBundle;


public class RoomsPageController implements Initializable {

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

    @FXML
    private TableColumn<Room, String> Status;

    @FXML
    private TextField filterField;

    @FXML
    private Button addRoomButton;

    @FXML
    private TableColumn<Room, String> first_Name;

    @FXML
    private TableColumn<Room, Integer> floor;

    @FXML
    private TableColumn<Room, String> gender;

    @FXML
    private TableColumn<Room, String> hostel_Name;

    @FXML
    private TableColumn<Room, String> last_Name;

    @FXML
    private TableColumn<Room, String> phone_Number;

    @FXML
    private TableView<Room> roomView;

    @FXML
    private TableColumn<Room, Integer> room_number;

    @FXML
    private TableColumn<Room, Integer> student_ID;

    public RoomsPageController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    void openAddRoom(ActionEvent event) throws IOException {
        Stage stage = (Stage) addRoomButton.getScene().getWindow();
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddRoom.fxml"));
        newStage.setTitle("Home Page");
        newStage.setScene(new Scene(root, 800, 600));
        newStage.setMaximized(true);
        stage.close();
        newStage.show();

    }

    //TableColumn room_number = new TableColumn("room_number");

    private ObservableList<Room> data;








    //Populate Room
    @FXML
    private void populateRoom (Room rm) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Room> roomData = FXCollections.observableArrayList();
        //Add room to the ObservableList
        roomData.add(rm);
        //Set items to the employeeTable
        roomView.setItems(roomData);
    }


    //Populate Rooms for TableView
    private void populateRooms(){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {

            String sql = "SELECT * FROM ROOM";
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            data = FXCollections.observableArrayList();
            Room roomInstance;

            while (resultSet.next()) {
                roomInstance = new Room(resultSet.getInt("room_number"), resultSet.getInt("hostel_ID"), resultSet.getString("status"), resultSet.getInt("floor"), resultSet.getInt("student_ID"));
                data.add(roomInstance);

            }

        } catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console" + ex.getMessage());
            //JOptionPane.showMessageDialog(null, "Connection Error",  "Error", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    }







    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateRooms();

        first_Name.setCellValueFactory(new PropertyValueFactory<Room,String>("first_name"));
        last_Name.setCellValueFactory(new PropertyValueFactory<Room,String>("last_name"));
        Status.setCellValueFactory(new PropertyValueFactory<Room,String>("Status"));
        floor.setCellValueFactory(new PropertyValueFactory<Room,Integer>("floor"));
        student_ID.setCellValueFactory(new PropertyValueFactory<Room,Integer>("student_ID"));
        phone_Number.setCellValueFactory(new PropertyValueFactory<Room,String>("phone_number"));
        room_number.setCellValueFactory(new PropertyValueFactory<Room,Integer>("room_number"));
        gender.setCellValueFactory(new PropertyValueFactory<Room,String>("gender"));
        hostel_Name.setCellValueFactory(new PropertyValueFactory<Room,String>("hostel_Name"));






        roomView.setItems(data);
    }









    @FXML
    protected void searchByRoomID()  {
        String search = filterField.getText().toString();

        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {

            String sql = "SELECT * FROM ROOM WHERE \"Room_Number\"="+Integer.parseInt(search);
            preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            data = FXCollections.observableArrayList();
            Room roomInstance;

            while (resultSet.next()) {
                roomInstance = new Room(resultSet.getInt("room_number"), resultSet.getInt("hostel_ID"), resultSet.getString("status"), resultSet.getInt("floor"), resultSet.getInt("student_ID"));
                data.add(roomInstance);

            }

        } catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console" + ex.getMessage());
            //JOptionPane.showMessageDialog(null, "Connection Error",  "Error", JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        roomView.setItems(data);

    }





}

