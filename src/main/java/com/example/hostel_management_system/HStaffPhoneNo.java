package com.example.hostel_management_system;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.SQLException;

public class HStaffPhoneNo {

    Connection conn = DbConnection.dbConnect();

    private SimpleIntegerProperty employee_ID;

    private SimpleStringProperty phone_number;

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

    public String getPhone_number() {
        return phone_number.get();
    }

    public SimpleStringProperty phone_numberProperty() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number.set(phone_number);
    }

    public HStaffPhoneNo() throws SQLException, ClassNotFoundException {
    }
}
