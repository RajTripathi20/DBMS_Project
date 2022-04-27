package com.example.hostel_management_system;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.SQLException;

public class Hostel {
    Connection conn = DbConnection.dbConnect();

    private SimpleIntegerProperty hostel_ID;

    private SimpleStringProperty name;

    private SimpleIntegerProperty number_of_rooms;

    private  SimpleStringProperty gender;

    private SimpleStringProperty location;

    private SimpleIntegerProperty annual_expense;

    private SimpleIntegerProperty number_of_workers;

    private SimpleIntegerProperty floors;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
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

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getNumber_of_rooms() {
        return number_of_rooms.get();
    }

    public SimpleIntegerProperty number_of_roomsProperty() {
        return number_of_rooms;
    }

    public void setNumber_of_rooms(int number_of_rooms) {
        this.number_of_rooms.set(number_of_rooms);
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

    public String getLocation() {
        return location.get();
    }

    public SimpleStringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public int getAnnual_expense() {
        return annual_expense.get();
    }

    public SimpleIntegerProperty annual_expenseProperty() {
        return annual_expense;
    }

    public void setAnnual_expense(int annual_expense) {
        this.annual_expense.set(annual_expense);
    }

    public int getNumber_of_workers() {
        return number_of_workers.get();
    }

    public SimpleIntegerProperty number_of_workersProperty() {
        return number_of_workers;
    }

    public void setNumber_of_workers(int number_of_workers) {
        this.number_of_workers.set(number_of_workers);
    }

    public int getFloors() {
        return floors.get();
    }

    public SimpleIntegerProperty floorsProperty() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors.set(floors);
    }

    public Hostel() throws SQLException, ClassNotFoundException {
    }
}
