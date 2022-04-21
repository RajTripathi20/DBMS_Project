import javafx.collections.FXCollections;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;publi class mySQLconnect{
    Connection conn = null;

    public static Connection ConnectDb(){
        try.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@pranjal_laptop:1521:XE");
        JOptionPane.showMessageDialog(null,"connectionEstablished");
        return conn;
    } catch (Exception e){
        JOptionPane.showMessageDialog(null,e);
        return null;
    }
}

public static ObservableList<students> getDatastudents(){
    Connection conn =ConnectDb();
    ObservableList<students> list = FXCollections.ObservableArrayList();
    try{
        PreparedStatement ps = conn.prepareStatement("select * from students");
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            list.add(new students(Integer.parseInt(rs.getString("Student_ID")),rs.getString("First_Name"),rs.getString("Last_Name"),Integer.parseInt(rs.getString("Room_Number")),rs.getString("Gender"),Integer.parseInt(rs.getString("Hostel_ID")),rs.getString("DOB"),rs.getString("Address"),rs.getString("Emergency_Contact"),rs.getString("Emergency_Contact"),rs.getString("Emergency_Contact"));
        }catch (Exception e){
        }
        return list;
    }
}