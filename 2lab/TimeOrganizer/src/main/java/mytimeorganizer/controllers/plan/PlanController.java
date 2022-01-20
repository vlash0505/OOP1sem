package mytimeorganizer.controllers.plan;

import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import mytimeorganizer.models.Task;
import mytimeorganizer.persistance.DAO.PropertiesLoader;
import mytimeorganizer.persistance.DAO.tasks.DriverTaskDAO;
import mytimeorganizer.persistance.DAO.tasks.TaskDAO;
import mytimeorganizer.visual_components.PaneWithInput;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Class describes the controller for plan
 * section.
 */

public class PlanController implements Initializable {

    @FXML
    private DatePicker datePicker;

    @FXML
    private VBox tasksVBox;


    private TaskDAO taskDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DriverTaskDAO driverTaskDAO = PropertiesLoader.getDriverTaskDAOInstance();
        taskDAO = driverTaskDAO.getTaskDAO();

        datePicker.valueProperty().addListener(
                (o, oldDate, date) -> tasksVBox.getChildren().addAll(getTasksByDate(date))
        );

        datePicker.setValue(LocalDate.now());
    }

    public void onAddTaskButton() {
        if(tasksVBox.getChildren().stream().anyMatch(e -> e instanceof PaneWithInput)) {
            return;
        }
        PaneWithInput paneWithInput = new PaneWithInput();
        tasksVBox.getChildren().add(paneWithInput);

        paneWithInput.getController().getCheckmarkView().setOnMouseClicked(e -> {
            String description = paneWithInput.getController().getTextField().getText();

            Task task = new Task();
            task.setDate(
                    datePicker.getValue()
            );
            task.setDescription(description);

            tasksVBox.getChildren().remove(paneWithInput);
            taskDAO.addNewTask(task);
            addCheckboxWithDescription(description);
        });
    }

    public void addCheckboxWithDescription(String description) {
        JFXCheckBox jfxCheckBox = new JFXCheckBox(description);
        jfxCheckBox.setMinHeight(30.0);
        tasksVBox.getChildren().add(jfxCheckBox);
    }

    public List<JFXCheckBox> getTasksByDate(LocalDate localDate) {
        tasksVBox.getChildren().clear();

        List<Task> tasks = taskDAO.findByDateAndUserID(localDate, Task.USER_ID);
        List<JFXCheckBox> checkBoxes = new ArrayList<>();
        tasks.forEach(e -> checkBoxes.add(new JFXCheckBox(e.getDescription())));
        return checkBoxes;
    }
}
