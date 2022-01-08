package mytimeorganizer.controllers.custom_elements;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PaneWithInputController implements Initializable {

    @FXML
    public TextField textField;

    @FXML
    public ImageView checkmarkView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Getter for the text field.
     *
     * @return text field of the custom pane with
     *         input.
     */

    public TextField getTextField() {
        return textField;
    }

    /**
     * Getter for the image(checkmark) view.
     *
     * @return image view of the custom pane
     *         with input.
     */

    public ImageView getCheckmarkView() {
        return checkmarkView;
    }
}
