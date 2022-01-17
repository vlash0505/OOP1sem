package mytimeorganizer.controllers.goals;

import com.jfoenix.controls.JFXCheckBox;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        List<Goal> goals = goalDAO.findByTypeAndUserId(Goal.USER_ID, "work");
        goals.forEach(e -> workGoalsVBox.getChildren().add(new JFXCheckBox(e.getDescription())));
    }

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
