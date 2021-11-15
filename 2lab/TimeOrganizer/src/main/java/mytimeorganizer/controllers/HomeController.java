package mytimeorganizer.controllers;

import mytimeorganizer.logic.View;
import mytimeorganizer.logic.ViewSwitcher;

public class HomeController {

    public void onSignOut() {
        ViewSwitcher.switchTo(View.LOGIN);
    }

    public void onJournalingButton() {
        ViewSwitcher.switchTo(View.JOURNAL);
    }
}
