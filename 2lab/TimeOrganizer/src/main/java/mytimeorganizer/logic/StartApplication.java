package mytimeorganizer.logic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartApplication extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Pane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.LOGIN);

        stage.setTitle("Organizer");
        stage.getIcons().add(new Image("/assets/2910020.png"));
        stage.setMinWidth(550.0);
        stage.setMinHeight(450.0);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
