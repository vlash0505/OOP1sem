package mytimeorganizer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import mytimeorganizer.logic.View;
import mytimeorganizer.logic.ViewSwitcher;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class JournalingController {

    @FXML
    DatePicker datePicker;

    @FXML
    TextArea textArea;

    private Map<LocalDate, String> data = new HashMap<>();

    public void onHomeButton() {
        save();
        ViewSwitcher.switchTo(View.HOME);
    }

    @FXML
    public void initialize() {
        load();
        datePicker.valueProperty().addListener((o, oldDate, date) -> textArea.setText(data.getOrDefault(date, "")));
        datePicker.setValue(LocalDate.now());
    }

    public void updateNotes() {
        data.put(datePicker.getValue(), textArea.getText());
    }

    private void save() {
        try(ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(Paths.get("notes.data")))) {
            stream.writeObject(data);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void load() {
        Path file = Paths.get("notes.data");
        try(ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(file))) {
            data = (Map<LocalDate, String>) stream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
