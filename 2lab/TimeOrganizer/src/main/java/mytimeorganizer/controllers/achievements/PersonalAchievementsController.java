package mytimeorganizer.controllers.achievements;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import mytimeorganizer.view_logic.PaneViewSwitcher;
import mytimeorganizer.view_logic.View;

public class PersonalAchievementsController {

    @FXML
    public VBox personalAchievementsVBox;

    public void onSwitchToWorkAchievementsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.WORK_ACHIEVEMENTS);
    }

    public void onSwitchToStudyAchievementsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.STUDY_ACHIEVEMENTS);
    }
}
