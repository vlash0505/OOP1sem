package mytimeorganizer.database;

import mytimeorganizer.models.Goal;
import mytimeorganizer.models.Task;

import java.util.List;

public interface GoalDAO extends DAO {
    public long insertGoal(Goal goal);
    public boolean updateGoal(Goal goal);
    public boolean deleteGoal(Goal goal);

    public List<Goal> findGoalByProperty(GoalSearchType searchType, Object value);
    public List<Goal> findAll();
}
