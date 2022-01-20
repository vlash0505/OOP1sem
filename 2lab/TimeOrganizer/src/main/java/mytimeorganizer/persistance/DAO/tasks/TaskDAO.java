package mytimeorganizer.persistance.DAO.tasks;

import mytimeorganizer.models.Task;
import mytimeorganizer.persistance.DAO.DAOException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TaskDAO {
    public Task findById(Long id) throws DAOException;

    public void addNewTask(Task task) throws IllegalArgumentException, DAOException;

    public List<Task> findAllTasks();

    public List<Task> findByDateAndUserID(LocalDate date, Long userId);

    public void deleteExistingTask(Task task) throws DAOException;
}
