package mytimeorganizer.controllers.goals;

import com.jfoenix.controls.JFXCheckBox;
import javafx.scene.layout.VBox;
import mytimeorganizer.database.DerbyGoalDAO;
import mytimeorganizer.database.GoalDAO;
import mytimeorganizer.database.GoalsStorage;
import mytimeorganizer.visual_components.PaneWithInput;

public class GoalsController {

    private GoalsStorage goalsStorage;

    private GoalDAO buildDAO() {
        return new DerbyGoalDAO();
    }

    private GoalsStorage buildModel() {
        return new GoalsStorage(buildDAO());
    }

    public void onAddGoalButton(VBox vBox) {
        PaneWithInput paneWithInput = new PaneWithInput();
        vBox.getChildren().add(paneWithInput);
        paneWithInput.getController().getCheckmarkView().setOnMouseClicked(e -> {
            vBox.getChildren().remove(paneWithInput);
            addDescription(paneWithInput.getController().getTextField().getText(), vBox);
        });
    }

    public void addDescription(String description, VBox vbox) {
        JFXCheckBox box = new JFXCheckBox(description);
        box.setMinHeight(30.0);
        vbox.getChildren().add(box);
    }

}
