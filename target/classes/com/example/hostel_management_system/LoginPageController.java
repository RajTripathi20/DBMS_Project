import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PleaseProvideControllerClassName {

    @FXML
    private Button cancelButton;

    @FXML
    private PasswordField enterPasswordFIeld;

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
    protected void onLoginButtonClick() {
        if(usernameTextField.getText().toString().equals("admin") && enterPasswordField.getText().toString.equals("admin")){

            }
    }
}
