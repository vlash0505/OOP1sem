package mytimeorganizer.logic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartApplication extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Pane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.SIGNIN);

        stage.setTitle("Organizer");
        stage.setMinWidth(550.0);
        stage.setMinHeight(450.0);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
