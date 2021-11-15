package mytimeorganizer.logic;

/**
 * ENUM class that
 */

public enum View {
    LOGIN("/views/signInView.fxml"),
    SIGNUP("/views/signUpView.fxml"),
    HOME("/views/homeView.fxml"),
    JOURNAL("/views/journalingView.fxml"),
    TODO("/views/shortTermTasks.fxml");

    private final String filename;

    /**
     * Sets the initial view mode.
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
