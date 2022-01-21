package mytimeorganizer.controllers.journaling;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import mytimeorganizer.models.Note;
import mytimeorganizer.persistance.DAO.PropertiesLoader;
import mytimeorganizer.persistance.DAO.notes.DriverNoteDAO;
import mytimeorganizer.persistance.DAO.notes.NoteDAO;

import java.time.LocalDate;

public class JournalingController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea textArea;

    private NoteDAO noteDAO;


    /**
     * Initializes Note DAO and places user on a current
     * date.
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
