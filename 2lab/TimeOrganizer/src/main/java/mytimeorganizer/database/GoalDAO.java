package mytimeorganizer.database;

import mytimeorganizer.models.Task;

import java.util.List;

public interface GoalDAO {
    public void insertGoal();
    public void updateGoal();
    public void deleteGoal();

    public List<Task> findGoalByProperty(GoalSearchType searchType, Object value);
    public List<Task> findAll();
}
