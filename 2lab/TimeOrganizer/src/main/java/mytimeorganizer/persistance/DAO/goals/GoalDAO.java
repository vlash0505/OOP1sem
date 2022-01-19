package mytimeorganizer.persistance.DAO.goals;

import mytimeorganizer.models.Goal;
import mytimeorganizer.persistance.DAO.DAOException;

import java.util.List;

public interface GoalDAO {

    public Goal findByID(Long id) throws DAOException;
    public List<Goal> findAll() throws DAOException;
    public List<Goal> findUncompletedByTypeAndUserId(Long id, String type) throws DAOException;
    public List<Goal> findCompletedByTypeAndUserId(Long id, String type) throws DAOException;

    public void makeGoalUncompleted(Long id) throws DAOException;
    public void makeGoalCompleted(Long Id) throws DAOException;

    public Long addGoal(Goal goal) throws IllegalArgumentException, DAOException;
    public void deleteGoal(Long id) throws DAOException;
    public void editGoal(Long id) throws DAOException;
}
