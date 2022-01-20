package mytimeorganizer.persistance.DAO.notes;

import mytimeorganizer.models.Note;

import java.time.LocalDate;
import java.util.List;

public interface NoteDAO {

    public Note findByID(Long id);

    public Note findByDateAndUserID(Long userId, LocalDate date);

    public void addNote(Note note);

    public void updateNoteDescription(String description, Long userId, LocalDate date);

    public boolean hasNoteAtDate(Long userId, LocalDate localDate);
}
