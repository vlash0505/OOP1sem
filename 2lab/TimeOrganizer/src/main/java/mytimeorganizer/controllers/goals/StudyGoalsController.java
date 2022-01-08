package mytimeorganizer.controllers.goals;

import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import mytimeorganizer.view_logic.PaneViewSwitcher;
import mytimeorganizer.view_logic.View;
import mytimeorganizer.visual_components.PaneWithInput;

public class StudyGoalsController {

    @FXML
    VBox studyGoalsVBox;

    /**
     * Adds study goal.
     *
     * @param actionEvent "Add" button pressed.
     */

    public void onAddStudyGoalButton(ActionEvent actionEvent) {
        PaneWithInput paneWithInput = new PaneWithInput();
        paneWithInput.getController().getCheckmarkView().setOnMouseClicked(e -> {
            studyGoalsVBox.getChildren().remove(paneWithInput);
            addDescription(paneWithInput.getController().getTextField().getText());
        });
        studyGoalsVBox.getChildren().add(paneWithInput);
    }

    public void addDescription(String description) {
        JFXCheckBox box = new JFXCheckBox(description);
        box.setMinHeight(50.0);
        studyGoalsVBox.getChildren().add(box);
    }

    /**
     * Switches to the personal goals view.
     *
     * @param mouseEvent mouse clicked on the "Next"
     *                   image.
     */

    public void onSwitchToPersonalGoalsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.PERSONAL_GOALS);
    }

    /**
     * Switches to the work goals view.
     *
     * @param mouseEvent mouse clicked on the "Previous"
     *                   image.
     */


    public void onSwitchToWorkGoalsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.WORK_GOALS);
    }
}
