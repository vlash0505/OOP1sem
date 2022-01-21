package mytimeorganizer.persistance.DAO.tasks;

import mytimeorganizer.models.Task;
import mytimeorganizer.persistance.DAO.DAOException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TaskDAO {

    public Long addNewTask(Task task) throws IllegalArgumentException, DAOException;

    public void makeTaskCompleted(Long id);

    public void makeTaskUncompleted(Long id);

    public List<Task> findByDateAndUserID(LocalDate date, Long userId);
}
