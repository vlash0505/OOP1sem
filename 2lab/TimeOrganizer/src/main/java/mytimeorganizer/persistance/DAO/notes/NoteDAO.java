package mytimeorganizer.persistance.DAO.notes;

import mytimeorganizer.models.Note;

import java.util.List;

public interface NoteDAO {

    public Note findByID(Long id);

    public List<Note> findByDateAndUserID();

    public List<Note> findAll();

    public void addNote(Note note);

    public void deleteNoteByID(Long id);
}
