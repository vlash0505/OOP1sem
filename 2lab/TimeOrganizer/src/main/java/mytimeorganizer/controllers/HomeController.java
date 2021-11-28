package mytimeorganizer.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import mytimeorganizer.logic.View;
import mytimeorganizer.logic.ViewSwitcher;

public class HomeController {
    @FXML
    VBox taskList;

    public void onSignOut() {
        ViewSwitcher.switchTo(View.LOGIN);
    }

    public void onJournalingButton() {
        ViewSwitcher.switchTo(View.JOURNAL);
    }
}
