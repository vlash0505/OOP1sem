package mytimeorganizer.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import mytimeorganizer.view_logic.TestSwitcher;
import mytimeorganizer.view_logic.View;

public class HomeController {
    @FXML
    AnchorPane contentArea;

    @FXML
    public void initialize() {
        TestSwitcher.setPane(contentArea);
        TestSwitcher.switchTo(View.START);
    }

    public void onHomeButton() {
        TestSwitcher.switchTo(View.START);
    }

    public void onPlanButton() {
        TestSwitcher.switchTo(View.PLAN);
    }

    public void onGoalsButton() {
        TestSwitcher.switchTo(View.GOALS);
    }

    public void onJournalingButton() {
        TestSwitcher.switchTo(View.JOURNAL);
    }
}
