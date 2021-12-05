package mytimeorganizer.database;

import mytimeorganizer.models.Task;

import java.util.List;

public interface TaskDAO extends DAO{
    public void insertTask();
    public void updateTask();
    public void deleteTask();

    public List<Task> findTaskByProperty(TaskSearchType searchType, Object value);
    public List<Task> findAll();
}
