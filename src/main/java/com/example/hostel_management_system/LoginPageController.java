package com.example.hostel_management_system;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {

    @FXML
    private Button cancelButton;

    @FXML
    private PasswordField enterPasswordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    protected void onCancelButtonClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onLoginButtonClick() throws IOException {
        String username = usernameTextField.getText().toString();
        String password = enterPasswordField.getText().toString();

        if(username.equals("admin") && password.equals("admin")){
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            Stage newStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            newStage.setTitle("Home Page");
            newStage.setScene(new Scene(root, 800, 600));
            newStage.setMaximized(true);
            stage.close();
            newStage.show();


        }
        else  {
            loginMessageLabel.setText("Invalid Credentials! Try Again");
        }
    }



}

