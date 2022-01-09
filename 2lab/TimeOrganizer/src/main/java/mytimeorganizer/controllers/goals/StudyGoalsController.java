package mytimeorganizer.controllers.goals;

import com.jfoenix.controls.JFXCheckBox;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_BLUEPeer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import mytimeorganizer.view_logic.PaneViewSwitcher;
import mytimeorganizer.view_logic.View;

public class StudyGoalsController extends GoalsController {

    @FXML
    private VBox studyGoalsVBox;

    /**
     * Adds study goal.
     *
     * @param actionEvent "Add" button pressed.
     */

    public void onAddStudyGoalButton(ActionEvent actionEvent) {
        super.onAddGoalButton(studyGoalsVBox);
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
