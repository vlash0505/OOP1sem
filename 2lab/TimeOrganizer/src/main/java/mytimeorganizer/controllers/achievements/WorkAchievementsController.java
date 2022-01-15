package mytimeorganizer.controllers.achievements;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import mytimeorganizer.view_logic.PaneViewSwitcher;
import mytimeorganizer.view_logic.View;

public class WorkAchievementsController {

    @FXML
    public VBox workAchievementsVBox;

    public void onSwitchToStudyAchievementsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.STUDY_ACHIEVEMENTS);
    }

    public void onSwitchToPersonalAchievementsImage(MouseEvent mouseEvent) {
        PaneViewSwitcher.switchTo(View.PERSONAL_ACHIEVEMENTS);
    }
}
