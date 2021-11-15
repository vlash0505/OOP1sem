package mytimeorganizer.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import mytimeorganizer.logic.View;
import mytimeorganizer.logic.ViewSwitcher;

public class SignUpController {

    public void onLogInHyperlink() {
        ViewSwitcher.switchTo(View.LOGIN);
    }

    public void regExEmailValidation() {

    }

    public void regExUsernameValidation() {

    }

    public void regExPasswordValidation() {

    }
}
