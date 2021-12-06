package mytimeorganizer.view_logic;

/**
 * Enumerator for views that are used in the app.
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

    /**
     * Getter for the filename.
     *
     * @return filename as String.
     */

    public String getFilename() {
        return filename;
    }
}
