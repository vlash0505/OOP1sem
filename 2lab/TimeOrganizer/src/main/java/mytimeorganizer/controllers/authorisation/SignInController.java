package mytimeorganizer.controllers.authorisation;

import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.*;

import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import mytimeorganizer.persistance.DAO.DriverUserDAO;
import mytimeorganizer.persistance.DAO.PropertiesLoader;
import mytimeorganizer.persistance.DAO.UserDAO;
import mytimeorganizer.view_logic.View;
import mytimeorganizer.view_logic.SceneViewSwitcher;

public class SignInController implements Initializable {

    @FXML
    private TextField signInUsernameField;

    @FXML
    private PasswordField signInPasswordField;

    @FXML
    public Text signInErrorMessageText;

    private UserDAO userDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DriverUserDAO driverUserDAO = PropertiesLoader.getDriverUserDAOInstance();
        userDAO = driverUserDAO.getUserDAO();
    }

    public void onSignIn() {
        if(userDAO.existsUser(signInUsernameField.getText(), signInPasswordField.getText())) {
            SceneViewSwitcher.switchTo(View.HOME);
            signInPasswordField.setText("");
            signInErrorMessageText.setText("");
        } else {
            signInErrorMessageText.setText("Wrong username or password.");
            signInErrorMessageText.setTextAlignment(TextAlignment.CENTER);
        }
    }

    /**
     * Switches user to sign up view.
     */

    public void onSignUpHere() {
        SceneViewSwitcher.switchTo(View.SIGNUP);
    }
}
