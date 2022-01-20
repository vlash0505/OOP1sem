package mytimeorganizer.persistance.DAO.notes;

import mytimeorganizer.persistance.DAO.DriverDAO;
import mytimeorganizer.persistance.DAO.tasks.TaskDAO;
import mytimeorganizer.persistance.DAO.tasks.TaskDAOJDBC;

public class DriverNoteDAO extends DriverDAO {
    public DriverNoteDAO(String url, String username, String password) {
        super(url, username, password);
    }

    public NoteDAO getNoteDAO() {
        return new NoteDAOJDBC(this);
    }
}
