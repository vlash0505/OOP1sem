package mytimeorganizer.controllers.achievements;

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

public class StudyAchievementsController extends AchievementsController implements Initializable {

    @FXML
    public VBox studyAchievementsVBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        List<Goal> goals = goalDAO.findCompletedByTypeAndUserId(Goal.USER_ID, "study");
        goals.forEach(e -> super.addAchievementAsText(e.getDescription(), studyAchievementsVBox));
    }

    public void onSwitchToPersonalAchievementsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.PERSONAL_ACHIEVEMENTS);
    }

    public void onSwitchToWorkAchievementsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.WORK_ACHIEVEMENTS);
    }
}
