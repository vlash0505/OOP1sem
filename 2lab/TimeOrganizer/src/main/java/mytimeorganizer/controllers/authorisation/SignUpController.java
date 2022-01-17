package mytimeorganizer.controllers.authorisation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import mytimeorganizer.models.User;
import mytimeorganizer.persistance.DAO.users.DriverUserDAO;
import mytimeorganizer.persistance.DAO.PropertiesLoader;
import mytimeorganizer.persistance.DAO.users.UserDAO;
import mytimeorganizer.view_logic.View;
import mytimeorganizer.view_logic.SceneViewSwitcher;

import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that represents controller for sign up
 * view.
 */

public class SignUpController implements Initializable {

    @FXML
    private Text signUpStatusBar;

    @FXML
    private TextField signUpEmailTextField;

    @FXML
    private TextField signUpUsernameTextField;

    @FXML
    private PasswordField signUpPasswordField;

    private UserDAO userDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DriverUserDAO driverUserDAO = PropertiesLoader.getDriverUserDAOInstance();
        userDAO = driverUserDAO.getUserDAO();
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
        Pattern pattern = Pattern.compile(regularExpression.getRegularExpression());
        Matcher match = pattern.matcher(toInspect);
        return match.matches();
    }

    public void onSignUpButton(ActionEvent actionEvent) {
        if(validateInputFields()) {
            User user = new User();
            user.setEmail(signUpEmailTextField.getText());
            user.setUsername(signUpUsernameTextField.getText());
            user.setPassword(signUpPasswordField.getText());
            userDAO.addNewUser(user);

            SceneViewSwitcher.switchTo(View.LOGIN);
        } else {
            signUpStatusBar.setText("Invalid data.");
        }
    }
}
