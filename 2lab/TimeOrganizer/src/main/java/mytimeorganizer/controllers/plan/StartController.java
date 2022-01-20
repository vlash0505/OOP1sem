package mytimeorganizer.controllers.plan;

import com.jfoenix.controls.JFXCheckBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import mytimeorganizer.models.Task;
import mytimeorganizer.persistance.DAO.PropertiesLoader;
import mytimeorganizer.persistance.DAO.tasks.DriverTaskDAO;
import mytimeorganizer.persistance.DAO.tasks.TaskDAO;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @FXML
    private VBox todayTasksVBox;

    private TaskDAO taskDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DriverTaskDAO driverTaskDAO = PropertiesLoader.getDriverTaskDAOInstance();
        taskDAO = driverTaskDAO.getTaskDAO();

        List<Task> tasks = taskDAO.findByDateAndUserID(LocalDate.now(), Task.USER_ID);
        List<JFXCheckBox> checkBoxes = new ArrayList<>();
        tasks.forEach(e -> checkBoxes.add(new JFXCheckBox(e.getDescription())));

        todayTasksVBox.getChildren().addAll(checkBoxes);
    }
}
