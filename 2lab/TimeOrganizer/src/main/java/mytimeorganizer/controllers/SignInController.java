package mytimeorganizer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SignInController {

    @FXML
    private ImageView signInLogoIcon;

    @FXML
    private ImageView signInUsernameIcon;

    @FXML
    private ImageView signInPasswordIcon;

    @FXML
    private PasswordField signInPassword;

    @FXML
    private TextField signInUserName;

    @FXML
    private Button signInButton;

    @FXML
    void initialize() {

        signInButton.setOnAction(event -> {
            System.out.println("Login is clicked!");
        });
    }
}
