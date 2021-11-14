package mytimeorganizer.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class SignUpController {
    @FXML
    private JFXButton signUpButton;

    @FXML
    private ImageView signUpEmailIcon;

    @FXML
    private TextField signUpEmailTextField;

    @FXML
    private Hyperlink signUpHyperlinkToSignIn;

    @FXML
    private ImageView signUpMainLogo;

    @FXML
    private ImageView signUpPasswordIcon;

    @FXML
    private PasswordField signUpPasswordTextField;

    @FXML
    private ImageView signUpProfileIcon;

    @FXML
    private Text signUpTextToSignIn;

    @FXML
    private TextField signUpUsernameTextField;
}
