package com.example.hostel_management_system;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StdPhoneNo {
    private  SimpleIntegerProperty student_ID;
    private SimpleStringProperty phone_number;

    public int getStudent_ID() {
        return student_ID.get();
    }

    public SimpleIntegerProperty student_IDProperty() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID.set(student_ID);
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

    public StdPhoneNo(Integer student_ID, String phone_number) {
        this.student_ID = new SimpleIntegerProperty(student_ID);
        this.phone_number = new SimpleStringProperty(phone_number);
    }
}
