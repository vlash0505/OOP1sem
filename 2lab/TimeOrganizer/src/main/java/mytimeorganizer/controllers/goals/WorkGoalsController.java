package mytimeorganizer.controllers.goals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import mytimeorganizer.view_logic.PaneViewSwitcher;
import mytimeorganizer.view_logic.View;

public class WorkGoalsController extends GoalsController {

    @FXML
    private VBox workGoalsVBox;

    public void onAddWorkGoalButton(ActionEvent actionEvent) {
        super.onAddGoalButton(workGoalsVBox);
    }

    /**
     * Switches to the study goals view.
     *
     * @param mouseEvent mouse clicked on the "Next"
     *                   image.
     */

    public void onSwitchToStudyGoalsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.STUDY_GOALS);
    }

    /**
     * Switches to the personal goals view.
     *
     * @param mouseEvent mouse clicked on the "Previous"
     *                   image.
     */


    public void onSwitchToPersonalGoalsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.PERSONAL_GOALS);
    }

}
