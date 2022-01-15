package mytimeorganizer.controllers.achievements;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import mytimeorganizer.view_logic.PaneViewSwitcher;
import mytimeorganizer.view_logic.View;

public class StudyAchievementsController {

    @FXML
    public VBox studyAchievementsVBox;

    public void onSwitchToPersonalAchievementsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.PERSONAL_ACHIEVEMENTS);
    }

    public void onSwitchToWorkAchievementsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.WORK_ACHIEVEMENTS);
    }
}
