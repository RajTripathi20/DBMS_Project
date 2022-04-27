package com.example.hostel_management_system;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.SQLException;

public class HStaffSal {

    Connection conn = DbConnection.dbConnect();

    private SimpleStringProperty work;

    private SimpleIntegerProperty salary;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
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

    public int getSalary() {
        return salary.get();
    }

    public SimpleIntegerProperty salaryProperty() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary.set(salary);
    }

    public HStaffSal() throws SQLException, ClassNotFoundException {
    }
}
