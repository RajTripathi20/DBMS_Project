package com.example.hostel_management_system;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class StudentActivity {

    Connection conn = DbConnection.dbConnect();

    private SimpleIntegerProperty student_ID;

    private SimpleStringProperty check_out;

    private SimpleStringProperty check_in;

    public String getFirst_name() throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM STUDENT WHERE \"Student_ID\" = "+this.getStudent_ID();
        PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        try {
            return resultSet.getString("First_Name");
        } catch (SQLException e) {
            return null;
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
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

    public String getCheck_out() {
        return check_out.get();
    }

    public SimpleStringProperty check_outProperty() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out.set(check_out);
    }

    public String getCheck_in() {
        return check_in.get();
    }

    public SimpleStringProperty check_inProperty() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in.set(check_in);
    }

    public StudentActivity(Integer student_ID, String check_out, String check_in) throws SQLException, ClassNotFoundException {
        this.student_ID = new SimpleIntegerProperty(student_ID);
        this.check_out = new SimpleStringProperty(check_out);
        this.check_in = new SimpleStringProperty(check_in);
    }

    public StudentActivity() throws SQLException, ClassNotFoundException {
    }
}
