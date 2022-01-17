package mytimeorganizer.controllers.goals;

import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import mytimeorganizer.models.Goal;
import mytimeorganizer.persistance.DAO.*;
import mytimeorganizer.persistance.DAO.goals.DriverGoalDAO;
import mytimeorganizer.persistance.DAO.goals.GoalDAO;
import mytimeorganizer.visual_components.PaneWithInput;

import java.net.URL;
import java.util.ResourceBundle;

public class GoalsController implements Initializable {

    protected GoalDAO goalDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DriverGoalDAO driverGoalDAO = PropertiesLoader.getDriverGoalDAOInstance();
        goalDAO = driverGoalDAO.getGoalDAO();
    }

    public void onAddGoalButton(VBox vBox, String goalType) {
        PaneWithInput paneWithInput = new PaneWithInput();
        vBox.getChildren().add(paneWithInput);

        paneWithInput.getController().getCheckmarkView().setOnMouseClicked(e -> {
            vBox.getChildren().remove(paneWithInput);

            String description = paneWithInput.getController().getTextField().getText();
            addCheckboxWithDescription(description, vBox);

            addToDatabase(description, goalType);
        });
    }

    public void addCheckboxWithDescription(String description, VBox vbox) {
        JFXCheckBox box = new JFXCheckBox(description);
        box.setMinHeight(30.0);
        vbox.getChildren().add(box);
    }

    public void addToDatabase(String description, String goalType) {
        Goal goal = new Goal();
        goal.setDescription(description);
        goal.setType(goalType);
        goalDAO.addGoal(goal);
    }
}
