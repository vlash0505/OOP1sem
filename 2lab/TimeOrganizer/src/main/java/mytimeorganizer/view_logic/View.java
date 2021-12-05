package mytimeorganizer.view_logic;

import javafx.scene.Node;

import java.util.Collection;

/**
 * ENUM class that
 */

public enum View {
    LOGIN("/views/signInView.fxml"),
    SIGNUP("/views/signUpView.fxml"),
    HOME("/views/homeView.fxml"),
    START("/views/startView.fxml"),
    JOURNAL("/views/journalingView.fxml"),
    PLAN("/views/planView.fxml"),
    GOALS("/views/goalsView.fxml"),
    ACHIEVEMENTS("/views/achievementsView.fxml"),
    TIMER("/views/timerView.fxml");

    private final String filename;

    /**
     * Sets the view mode.
     *
     * @param filename file of a scene
     */

    View(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
