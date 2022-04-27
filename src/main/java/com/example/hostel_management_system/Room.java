package com.example.hostel_management_system;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room {
    Connection conn = DbConnection.dbConnect();

    private SimpleIntegerProperty room_number;
    private SimpleStringProperty status;
    private SimpleIntegerProperty floor;

    private SimpleIntegerProperty hostel_ID;
    private SimpleIntegerProperty student_ID;

    public Room() throws SQLException, ClassNotFoundException {

    }

    /*public Room() {

    }

     */




    public int getRoom_number() {
        return room_number.get();
    }

    public SimpleIntegerProperty room_numberProperty() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number.set(room_number);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public int getFloor() {
        return floor.get();
    }

    public SimpleIntegerProperty floorProperty() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor.set(floor);
    }

    public int getHostel_ID() {
        return hostel_ID.get();
    }

    public SimpleIntegerProperty hostel_IDProperty() {
        return hostel_ID;
    }

    public void setHostel_ID(int hostel_ID) {
        this.hostel_ID.set(hostel_ID);
    }

    public int getStudent_ID() {
        return student_ID.get();
    }

    public SimpleIntegerProperty student_IDProperty() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID.set(student_ID);
    }

    public Room(Integer room_number, Integer hostel_ID, String status, Integer floor, Integer student_ID) throws SQLException, ClassNotFoundException {
        this.room_number = new SimpleIntegerProperty(room_number);
        this.status = new SimpleStringProperty(status);
        this.floor = new SimpleIntegerProperty(floor);
        this.hostel_ID = new SimpleIntegerProperty(hostel_ID);
        this.student_ID = new SimpleIntegerProperty(student_ID);
    }


    public String getHostel_Name() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM HOSTEL WHERE \"Hostel_ID\" = "+this.getHostel_ID();
        PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("Name");
    }

    private ResultSet getStudentDetails() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM STUDENT WHERE \"Student_ID\" = "+this.getStudent_ID();
        PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;

    }


    public String getGender() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM STUDENT WHERE \"Student_ID\" = "+this.getStudent_ID();
        PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        try {
            return resultSet.getString("Gender");
        } catch (SQLException e) {
            return null;
        }
    }

    public String getFirst_name() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = getStudentDetails();
        resultSet.next();
        try {
            return resultSet.getString("First_Name");
        } catch (SQLException e) {
            return null;
        }
    }

    public String getLast_name() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = getStudentDetails();
        resultSet.next();
        try {
            return resultSet.getString("Last_Name");
        } catch (SQLException e) {
            return null;
        }
    }

    public String getPhone_number() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM STDPHONENO WHERE \"Student_ID\" = "+this.getStudent_ID();
        PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        try {
            return resultSet.getString("Phone_Number");
        } catch (SQLException e) {
            return null;
        }
    }
}
