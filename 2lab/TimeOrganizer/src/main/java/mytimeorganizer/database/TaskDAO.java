package mytimeorganizer.database;

public interface TaskDAO extends DAO{
    public void insertTask();
    public void updateTask();
    public void deleteTask();
}
