package mytimeorganizer.persistance.DAO.goals;

import mytimeorganizer.models.Goal;
import mytimeorganizer.persistance.DAO.DAOException;

import java.util.List;

public interface GoalDAO {

    public List<Goal> findUncompletedByTypeAndUserId(Long id, String type) throws DAOException;
    public List<Goal> findCompletedByTypeAndUserId(Long id, String type) throws DAOException;

    public void makeGoalUncompleted(Long id) throws DAOException;
    public void makeGoalCompleted(Long Id) throws DAOException;

    public Long addGoal(Goal goal) throws IllegalArgumentException, DAOException;
}
