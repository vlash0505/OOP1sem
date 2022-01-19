package mytimeorganizer.controllers.achievements;

import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import mytimeorganizer.persistance.DAO.PropertiesLoader;
import mytimeorganizer.persistance.DAO.goals.DriverGoalDAO;
import mytimeorganizer.persistance.DAO.goals.GoalDAO;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AchievementsController implements Initializable {

    protected GoalDAO goalDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DriverGoalDAO driverGoalDAO = PropertiesLoader.getDriverGoalDAOInstance();
        goalDAO = driverGoalDAO.getGoalDAO();
    }

    public void addAchievementAsText(String description, VBox vBox) {
        Text text = new Text();
        text.prefHeight(40);
        text.setText(description);
        vBox.getChildren().add(text);
    }

}
