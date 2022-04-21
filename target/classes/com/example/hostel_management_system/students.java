import javax.print.DocFlavor;
import java.lang.String;

public class students {
    int student_ID,hostel_ID,roomNumber,studentAge,studentFees;
    String studentFirstName,studentLastName,dateOfBirth,studentGender,studentAddress,studentEmegencyContact;

    public int getStudent_ID() {
        return student_ID;
    }

    public int getHostel_ID() {
        return hostel_ID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public int getStudentFees() {
        return studentFees;
    }

    public String getStudentFirstName(){
        return studentFirstName;
    }

    public String getStudentLastName(){
        return studentLastName;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getStudentGender(){
        return studentGender;
    }

    public String getStudentAddress(){
        return studentAddress;
    }

    public String getStudentEmegencyContact(){
        return studentEmegencyContact;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID= student_ID;
    }

    public void setHostel_ID(int hostel_ID) {
        this.hostel_ID= hostel_ID;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber=roomNumber;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge= studentAge;
    }

    public void setStudentFees(int studentFees) {
        this.studentFees= studentFees;
    }

    public void setStudentFirstName(String studentFirstName){
        this.studentFirstName= studentFirstName;
    }

    public void setStudentLastName(String studentLastName){
        this.studentLastName=studentLastName;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth= dateOfBirth;
    }

    public void setStudentGender(String studentGender){
        this.studentGender=studentGender;
    }

    public void setStudentAddress(String studentAddress){
        this.studentAddress= studentAddress;
    }

    public String getStudentEmegencyContact(){
        return studentEmegencyContact;
    }

    public students(int student_ID, int hostel_ID, int roomNumber, int studentAge, String studentFirstName, String studentLastName, String dateOfBirth,String studentGender,String studentAddress,String studentEmegencyContact,int studentFees){
        this.student_ID=student_ID;
        this.dateOfBirth=dateOfBirth;
        this.hostel_ID=hostel_ID;
        this.roomNumber=roomNumber;
        this.studentAddress=studentAddress;
        this.studentAge=studentAge;
        this.studentEmegencyContact=studentEmegencyContact;
        this.studentFees=studentFees;
        this.studentFirstName=studentFirstName;
        this.studentGender=studentGender;
        this.studentLastName=studentLastName;
    }
}