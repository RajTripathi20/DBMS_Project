package com.example.hostel_management_system;

import javafx.beans.property.SimpleIntegerProperty;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class StudentActivity {

    Connection conn = DbConnection.dbConnect();

    private SimpleIntegerProperty student_ID;

    private SimpleDateFormat check_out;

    private SimpleDateFormat check_in;

    public StudentActivity() throws SQLException, ClassNotFoundException {
    }
}
