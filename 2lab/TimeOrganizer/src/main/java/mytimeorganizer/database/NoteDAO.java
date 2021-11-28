package mytimeorganizer.database;

public interface NoteDAO extends DAO {
    public void insertNote();
    public void updateNote();
    public void deleteNote();
}
