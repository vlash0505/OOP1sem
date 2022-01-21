package mytimeorganizer.controllers.goals;

import mytimeorganizer.models.Goal;
import mytimeorganizer.persistance.DAO.*;
import mytimeorganizer.persistance.DAO.goals.DriverGoalDAO;
import mytimeorganizer.persistance.DAO.goals.GoalDAO;
import mytimeorganizer.visual_components.PaneWithInput;

import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GoalsController implements Initializable {

    protected GoalDAO goalDAO;

    //Initializable override

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DriverGoalDAO driverGoalDAO = PropertiesLoader.getDriverGoalDAOInstance();
        goalDAO = driverGoalDAO.getGoalDAO();
    }


    /**
     * Adds input pane when the "Add" button is pressed.
     *
     * @param vBox     vbox to which the pane will be added.
     * @param goalType type of the goal that will be added.
     */

    public void onAddGoalButton(VBox vBox, String goalType) {
        if(vBox.getChildren().stream().anyMatch(e -> e instanceof PaneWithInput)) {
            return;
        }

        PaneWithInput paneWithInput = new PaneWithInput();
        vBox.getChildren().add(paneWithInput);

        paneWithInput.getController().getCheckmarkView().setOnMouseClicked(e -> {
            String description = paneWithInput.getController().getTextField().getText();

            Goal goal = new Goal();
            goal.setType(goalType);
            goal.setDescription(description);

            vBox.getChildren().remove(paneWithInput);
            goal.setId(addToDatabase(description, goalType));
            addCheckboxWithDescription(goal, vBox);
        });
    }

    /**
     * Adds checkbox with goal description to the VBox.
     *
     * @param goal goal to be added.
     * @param vbox vbox that goal will be added to.
     */

    public void addCheckboxWithDescription(Goal goal, VBox vbox) {
        String description = goal.getDescription();
        JFXCheckBox box = new JFXCheckBox(description);
        box.setMinHeight(30.0);

        box.setOnMouseClicked(e -> {
            vbox.getChildren().remove(box);
            if(box.isSelected()) {
                vbox.getChildren().add(box);
                goalDAO.makeGoalCompleted(goal.getId());
            } else {
                vbox.getChildren().add(0, box);
                goalDAO.makeGoalUncompleted(goal.getId());
            }
        });
        vbox.getChildren().add(box);
    }

    /**
     * Adds goal instance to the database.
     *
     * @param description description of a goal to be added
     * @param goalType    type of goal to be added.
     *
     * @return            id of the created goal, null otherwise.
     */

    public Long addToDatabase(String description, String goalType) {
        Goal goal = new Goal();
        goal.setDescription(description);
        goal.setType(goalType);

        return goalDAO.addGoal(goal);
    }
}
