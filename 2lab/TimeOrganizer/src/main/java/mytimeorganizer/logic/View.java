package mytimeorganizer.logic;

public enum View {
    SIGNIN("/views/signInView.fxml"),
    SIGNUP("/views/signUpView.fxml"),
    TODO("/views/toDoView.fxml");

    private final String filename;

    View(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
