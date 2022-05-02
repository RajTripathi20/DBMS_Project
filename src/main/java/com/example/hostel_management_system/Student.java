package com.example.hostel_management_system;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    Connection conn = DbConnection.dbConnect();


    private SimpleIntegerProperty student_ID;
    private SimpleStringProperty first_name;
    private SimpleStringProperty last_name;
    private SimpleIntegerProperty hostel_ID;
    private SimpleIntegerProperty room_number;
    private String dob;
    private SimpleIntegerProperty age;
    private SimpleStringProperty gender;
    private SimpleStringProperty address;
    private SimpleStringProperty emergency_contact;
    private SimpleIntegerProperty fees;

    public Student(int student_id, String first_name) throws SQLException, ClassNotFoundException {
        this.student_ID = new SimpleIntegerProperty(student_id);
        this.first_name = new SimpleStringProperty(first_name);
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

    public String getFirst_name() {
        return first_name.get();
    }

    public SimpleStringProperty first_nameProperty() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name.set(first_name);
    }

    public String getLast_name() {
        return last_name.get();
    }

    public SimpleStringProperty last_nameProperty() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name.set(last_name);
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

    public int getRoom_number() {
        return room_number.get();
    }

    public SimpleIntegerProperty room_numberProperty() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number.set(room_number);
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getEmergency_contact() {
        return emergency_contact.get();
    }

    public SimpleStringProperty emergency_contactProperty() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact.set(emergency_contact);
    }

    public int getFees() {
        return fees.get();
    }

    public SimpleIntegerProperty feesProperty() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees.set(fees);
    }



    public int getFloor() throws SQLException, ClassNotFoundException {
        Connection conn = DbConnection.dbConnect();

        String sql = "SELECT * FROM ROOM WHERE \"Student_ID\" = "+this.getStudent_ID();
        PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("floor");
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

    public String getHostel_name() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM HOSTEL WHERE \"Hostel_ID\" = "+this.getHostel_ID();
        PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("Name");
    }




    public Student(Integer student_ID, String first_name, String last_name, Integer hostel_ID, Integer room_number, String dob, Integer age, String gender, String address, String emergency_contact, Integer fees) throws ParseException, SQLException, ClassNotFoundException {
        this.student_ID = new SimpleIntegerProperty(student_ID);
        this.first_name = new SimpleStringProperty(first_name);
        this.last_name = new SimpleStringProperty(last_name);
        this.hostel_ID = new SimpleIntegerProperty(hostel_ID);
        this.room_number = new SimpleIntegerProperty(room_number);
        this.dob = dob;
        this.age = new SimpleIntegerProperty(age);
        this.gender = new SimpleStringProperty(gender);
        this.address = new SimpleStringProperty(address);
        this.emergency_contact = new SimpleStringProperty(emergency_contact);
        this.fees = new SimpleIntegerProperty(fees);
    }



}
