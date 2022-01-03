package mytimeorganizer.controllers;

import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class GoalsController {
    @FXML
    VBox studyGoalsVBox;

    @FXML
    VBox workGoalsVBox;

    @FXML
    VBox personalGoalsVBox;


    public void onAddStudyGoalButton() {
       studyGoalsVBox.getChildren().add(new JFXCheckBox("Study"));
       //still todo
    }

    public void onAddWorkGoalButton() {
        workGoalsVBox.getChildren().add(new JFXCheckBox("Work"));
        //still todo
    }

    public void onAddPersonalGoalButton() {
        personalGoalsVBox.getChildren().add(new JFXCheckBox("Personal"));
        //still todo
    }
}
