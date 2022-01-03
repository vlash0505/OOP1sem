package mytimeorganizer.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import mytimeorganizer.visual_components.PaneWithInput;

/**
 * Class describes the controller for plan
 * section.
 */

public class PlanController {
    private static final int MAXIMUM_NUMBER_OF_TASKS = 15;

    @FXML
    VBox tasks;

    public void onAddButton() {
        if(tasks.getChildren().size() > MAXIMUM_NUMBER_OF_TASKS) { return; }

        requestTaskDescription();
    }

    public void requestTaskDescription() {
        tasks.getChildren().add(new PaneWithInput());
    }

    public void addNewTask(String description) {

    }
}
