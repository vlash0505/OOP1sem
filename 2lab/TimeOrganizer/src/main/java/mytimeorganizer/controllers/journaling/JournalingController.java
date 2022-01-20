package mytimeorganizer.controllers.journaling;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import mytimeorganizer.models.Note;
import mytimeorganizer.models.Task;
import mytimeorganizer.persistance.DAO.PropertiesLoader;
import mytimeorganizer.persistance.DAO.notes.DriverNoteDAO;
import mytimeorganizer.persistance.DAO.notes.NoteDAO;
import mytimeorganizer.persistance.DAO.tasks.DriverTaskDAO;
import mytimeorganizer.view_logic.View;
import mytimeorganizer.view_logic.SceneViewSwitcher;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JournalingController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea textArea;

    private NoteDAO noteDAO;

    /**
     * Initialize pane view and place user on current
     */

    @FXML
    public void initialize() {
        DriverNoteDAO driverNoteDAO = PropertiesLoader.getDriverNoteDAOInstance();
        noteDAO = driverNoteDAO.getNoteDAO();

        datePicker.valueProperty().addListener(
                (o, oldDate, date) -> textArea.setText(
                        noteDAO.findByDateAndUserID(Note.USER_ID, date).getDescription()
                )
        );

        datePicker.setValue(LocalDate.now());
    }

    /**
     * Update notes in DB on "Update notes" button
     * press.
     */

    public void onUpdateNotesButton() {
        Note note = new Note();
        note.setDate(
                datePicker.getValue()
        );
        note.setDescription(textArea.getText());
        if(noteDAO.hasNoteAtDate(Note.USER_ID, datePicker.getValue())) {
            noteDAO.updateNoteDescription(note.getDescription(), Note.USER_ID, datePicker.getValue());
        } else {
            noteDAO.addNote(note);
        }
    }
}
