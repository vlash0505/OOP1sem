package mytimeorganizer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import mytimeorganizer.view_logic.View;
import mytimeorganizer.view_logic.SceneViewSwitcher;

import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that represents controller for sign up
 * view.
 */

public class SignUpController {
    @FXML
    TextField signUpEmailTextField;

    @FXML
    TextField signUpUsernameTextField;

    @FXML
    PasswordField signUpPasswordField;

    /**
     * Method that handles user registration when the signup
     * button is pressed.
     */

    public void onSignUpButton() {
        if(!validateInputFields()) { return; }

    }

    /**
     * Method that validates input fields.
     *
     * @return true if inputs are validated
     *         false - otherwise.
     */

    public boolean validateInputFields() {
        return (regExValidation(signUpEmailTextField.getText(),    RegularExpression.EMAIL) &&
                regExValidation(signUpUsernameTextField.getText(), RegularExpression.USERNAME) &&
                regExValidation(signUpPasswordField.getText(),     RegularExpression.PASSWORD));
    }

    /**
     * Method that switches to log in view when the log in
     * hyperlink is pressed.
     */

    public void onLogInHyperlink() {
        SceneViewSwitcher.switchTo(View.LOGIN);
    }

    /**
     * Method that validates user input using regular
     * expression.
     *
     * @param toInspect          string that will be inspected
     * @param regularExpression  regular expression
     *
     * @return                   true if the string matches regular expression,
     *                           false - otherwise.
     */

    public boolean regExValidation(String toInspect, RegularExpression regularExpression) {
        Pattern pattern = Pattern.compile(regularExpression.getRegularExpression(), Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(toInspect);
        return match.matches();
    }
}
