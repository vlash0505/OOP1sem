package mytimeorganizer.controllers.goals;

import com.jfoenix.controls.JFXCheckBox;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_BLUEPeer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import mytimeorganizer.models.Goal;
import mytimeorganizer.view_logic.PaneViewSwitcher;
import mytimeorganizer.view_logic.View;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StudyGoalsController extends GoalsController implements Initializable {

    @FXML
    private VBox studyGoalsVBox;

    //Initializable Override

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        List<Goal> goals = goalDAO.findUncompletedByTypeAndUserId(Goal.USER_ID, "study");
        goals.forEach(e -> super.addCheckboxWithDescription(e, studyGoalsVBox));
    }

    /**
     * Adds pane with input when the "Add" button is pressed.
     *
     * @param actionEvent "Add" button pressed.
     */

    public void onAddStudyGoalButton(ActionEvent actionEvent) {
        super.onAddGoalButton(studyGoalsVBox, "study");
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
