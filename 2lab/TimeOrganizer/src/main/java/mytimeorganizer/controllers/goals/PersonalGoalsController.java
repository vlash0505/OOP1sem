package mytimeorganizer.controllers.goals;

import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import mytimeorganizer.models.Goal;
import mytimeorganizer.models.GoalTypes;
import mytimeorganizer.view_logic.PaneViewSwitcher;
import mytimeorganizer.view_logic.View;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PersonalGoalsController extends GoalsController implements Initializable {

    @FXML
    private VBox personalGoalsVBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        List<Goal> goals = goalDAO.findByTypeAndUserId(Goal.USER_ID, "personal");
        goals.forEach(e -> personalGoalsVBox.getChildren().add(new JFXCheckBox(e.getDescription())));
    }


    public void onAddPersonalGoalButton(ActionEvent actionEvent) {
        super.onAddGoalButton(personalGoalsVBox, "personal");
    }

    /**
     * Switches to the work goals view.
     *
     * @param mouseEvent mouse clicked on the "Next"
     *                   image.
     */

    public void onSwitchToWorkGoalsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.WORK_GOALS);
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
}
