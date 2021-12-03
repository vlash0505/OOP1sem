package mytimeorganizer.controllers;

import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

/**
 * Class describes the controller for plan
 * section.
 */

public class PlanController {
    @FXML
    VBox tasks;

    public void onAddButton() {
        tasks.getChildren().add(new JFXCheckBox("Task1"));
    }
}
