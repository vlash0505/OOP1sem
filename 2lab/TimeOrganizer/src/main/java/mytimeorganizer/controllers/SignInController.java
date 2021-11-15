package mytimeorganizer.controllers;

import javafx.fxml.FXML;

import java.util.regex.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;

import mytimeorganizer.logic.View;
import mytimeorganizer.logic.ViewSwitcher;

public class SignInController {

    @FXML
    private JFXButton signInButton;

    @FXML
    private PasswordField signInPasswordField;

    @FXML
    private JFXCheckBox signInRememberMeCheckBox;

    @FXML
    private Hyperlink signInToSignUpHyperlink;

    @FXML
    private TextField signInUsernameField;

    public void onSignUp() {
        ViewSwitcher.switchTo(View.SIGNUP);
    }

    public boolean validateUsername(String userEmail) {
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]$", Pattern.CASE_INSENSITIVE);
        Matcher matchEmail = emailPattern.matcher(userEmail);
        return matchEmail.find();
    }

    public boolean validatePassword(String username) {
        Pattern usernamePattern = Pattern.compile("^[A-Z0-9._%+-]$", Pattern.CASE_INSENSITIVE);
        Matcher matchUsername = usernamePattern.matcher(username);
        return matchUsername.find();
    }
}
