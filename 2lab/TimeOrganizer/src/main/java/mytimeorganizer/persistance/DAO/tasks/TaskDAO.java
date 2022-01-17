package mytimeorganizer.persistance.DAO.tasks;

import mytimeorganizer.models.Task;
import mytimeorganizer.persistance.DAO.DAOException;

import java.util.List;

public interface TaskDAO {
    public Task findById(Long id) throws DAOException;

    public void addNewTask(Task task) throws IllegalArgumentException, DAOException;

    public List<Task> findAllTasks();

    public List<Task> findByDateAndUserID();

    public void deleteExistingTask(Task task) throws DAOException;
}
