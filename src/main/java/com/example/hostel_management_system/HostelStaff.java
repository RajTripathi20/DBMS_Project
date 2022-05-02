package com.example.hostel_management_system;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public class HostelStaff {

    Connection conn = DbConnection.dbConnect();

    private SimpleIntegerProperty employee_ID;

    private SimpleStringProperty first_name;

    private  SimpleStringProperty last_name;

    private SimpleStringProperty gender;

    private  SimpleIntegerProperty hostel_ID;

    private SimpleIntegerProperty age;

    private SimpleStringProperty work;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public int getEmployee_ID() {
        return employee_ID.get();
    }

    public SimpleIntegerProperty employee_IDProperty() {
        return employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        this.employee_ID.set(employee_ID);
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

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
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

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getWork() {
        return work.get();
    }

    public SimpleStringProperty workProperty() {
        return work;
    }

    public void setWork(String work) {
        this.work.set(work);
    }

    public HostelStaff() throws SQLException, ClassNotFoundException {
    }

    public String getPhone_number() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM HSTAFFPHONENO WHERE \"Employee_ID\" = "+this.getEmployee_ID();
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

    public int getSalary() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM HSTAFFSAL WHERE \"Work\" = "+"'"+this.getWork()+"'";
        PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("Salary");
    }


    public HostelStaff(Integer employee_ID, String first_name, String last_name, String gender, Integer hostel_ID, Integer age, String work) throws ParseException, SQLException, ClassNotFoundException {
        this.employee_ID = new SimpleIntegerProperty(employee_ID);
        this.first_name = new SimpleStringProperty(first_name);
        this.last_name = new SimpleStringProperty(last_name);
        this.gender = new SimpleStringProperty(gender);
        this.hostel_ID = new SimpleIntegerProperty(hostel_ID);
        this.age = new SimpleIntegerProperty(age);
        this.work = new SimpleStringProperty(work);

    }
}
