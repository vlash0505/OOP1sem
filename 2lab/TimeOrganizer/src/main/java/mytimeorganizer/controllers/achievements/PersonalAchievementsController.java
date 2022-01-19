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

public class PersonalAchievementsController extends AchievementsController implements Initializable {

    @FXML
    public VBox personalAchievementsVBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location, resources);
        List<Goal> goals = goalDAO.findCompletedByTypeAndUserId(Goal.USER_ID, "personal");
        goals.forEach(e -> super.addAchievementAsText(e.getDescription(), personalAchievementsVBox));
    }

    public void onSwitchToWorkAchievementsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.WORK_ACHIEVEMENTS);
    }

    public void onSwitchToStudyAchievementsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.STUDY_ACHIEVEMENTS);
    }
}
