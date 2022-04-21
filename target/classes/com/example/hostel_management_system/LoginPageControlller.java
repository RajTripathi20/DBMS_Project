import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ResourceBundle;
import java.net.URL;

public class LoginPageController implements Intializable {
    File brandingFile
}
    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;

    @Override
    public void intialize(URL url, ResourceBundle resourceBundle)

    public loginButtonOnAction(ActionEvent event) {
        loginMessageLabel.setText("You try to login");
    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}