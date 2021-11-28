package mytimeorganizer.controllers;

import javafx.fxml.FXML;

import java.util.regex.*;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import mytimeorganizer.view_logic.View;
import mytimeorganizer.view_logic.ViewSwitcher;

public class SignInController {

    @FXML
    private TextField signInUsernameField;

    @FXML
    private PasswordField signInPasswordField;

    public void onSignIn() {
        if (regularExpressionsValidator(signInUsernameField.getText().trim()) && regularExpressionsValidator(signInPasswordField.getText().trim())) {
            ViewSwitcher.switchTo(View.HOME);
        }
    }

    public void onSignUpHere() {
        ViewSwitcher.switchTo(View.SIGNUP);
    }

    public boolean regularExpressionsValidator(String toInspect) {
        Pattern pattern = Pattern.compile("^[A-Za-z][A-Za-z0-9_]{7,29}$");
        Matcher match = pattern.matcher(toInspect);
        return match.matches();
    }
}
