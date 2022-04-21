import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.ResourceBundle;

public class StudentPageController implements Initializable {

    @FXML
    private TextField filterField;

    @FXML
    private TableColumn<students, String> hostelName;

    @FXML
    private TableColumn<students, Integer> roomNumber;

    @FXML
    private TableColumn<students,String> studentAddress;

    @FXML
    private TableColumn<students, String> studentDateOfBirth;

    @FXML
    private TableColumn<students, String> studentEmergencyContact;

    @FXML
    private TableColumn<students, String> studentFirstName;

    @FXML
    private TableColumn<students, String> studentGender;

    @FXML
    private TableColumn<students, Integer> studentID;

    @FXML
    private TableColumn<students, String> studentLastName;

    @FXML
    private TableColumn<students, String> studentPhoneNumberPrimary;

    @FXML
    private TableColumn<students, String> studentPhoneNumberSecondary;

    @FXML
    private TableView<students> studentView;

    ObservableList<students> listM;
    int index = -1;
    Collection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        studentID.setCellValueFactory(new PropertyValueFactory<students,Integer>("Student ID"));
        studentFirstName.setCellValueFactory(new PropertyValueFactory<students,String>("First Name"));
        studentLastName.setCellValueFactory(new PropertyValueFactory<students,String>("Last Name"));
        roomNumber.setCellValueFactory(new PropertyValueFactory<students,Integer>("Room No."));
        studentGender.setCellValueFactory(new PropertyValueFactory<students,String >("Gender"));
        hostelName.setCellValueFactory(new PropertyValueFactory<students,Integer>("Hostel"));
        studentDateOfBirth.IDsetCellValueFactory(new PropertyValueFactory<students,String>("Date of Birth"));
        studentAddress.setCellValueFactory(new PropertyValueFactory<students,String>("Address"));
        studentPhoneNumberPrimary.setCellValueFactory(new PropertyValueFactory<students,Integer>("Phone No."));
        studentPhoneNumberSecondary.setCellValueFactory(new PropertyValueFactory<students,Integer>("Secondary Phone No."));
        studentEmergencyContact.setCellValueFactory(new PropertyValueFactory<students,Integer>("Emergency Contact"));

        listM = mySQLconnect.getdatastudents();
        table_students.setItems(listM);

    }

}