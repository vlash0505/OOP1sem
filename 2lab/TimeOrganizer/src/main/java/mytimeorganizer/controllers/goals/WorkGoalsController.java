package mytimeorganizer.controllers.goals;

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

public class WorkGoalsController extends GoalsController implements Initializable {

    @FXML
    private VBox workGoalsVBox;

    //Initializable override

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        List<Goal> goals = goalDAO.findUncompletedByTypeAndUserId(Goal.USER_ID, "work");
        goals.forEach(e -> super.addCheckboxWithDescription(e, workGoalsVBox));
    }

    /**
     * Adds pane with input when the "Add" button is pressed.
     *
     * @param actionEvent press on the "Add" button.
     */

    public void onAddWorkGoalButton(ActionEvent actionEvent) {
        super.onAddGoalButton(workGoalsVBox, "work");
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
