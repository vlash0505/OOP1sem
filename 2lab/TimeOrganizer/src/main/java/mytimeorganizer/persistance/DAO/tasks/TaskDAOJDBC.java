package mytimeorganizer.persistance.DAO.tasks;

import mytimeorganizer.models.Task;
import mytimeorganizer.persistance.DAO.DAOException;

import java.util.List;

public class TaskDAOJDBC implements TaskDAO {

    private final DriverTaskDAO driverTaskDAO;

    public TaskDAOJDBC(DriverTaskDAO driverTaskDAO) {
        this.driverTaskDAO = driverTaskDAO;
    }

    @Override
    public Task findById(Long id) throws DAOException {
        return null;
    }

    @Override
    public void addNewTask(Task task) throws IllegalArgumentException, DAOException {

    }

    @Override
    public List<Task> findAllTasks() {
        return null;
    }

    @Override
    public List<Task> findByDateAndUserID() {
        return null;
    }

    @Override
    public void deleteExistingTask(Task task) throws DAOException {

    }
}
