package mytimeorganizer.persistance.DAO.goals;

import mytimeorganizer.models.Goal;
import mytimeorganizer.persistance.DAO.DAOException;

import java.util.List;

public interface GoalDAO {

    public Goal findByID(Long id) throws DAOException;
    public List<Goal> findAll() throws DAOException;
    public List<Goal> findByTypeAndUserId(Long id, String type) throws DAOException;
    public List<Goal> findNotCompleted() throws DAOException;

    public void addGoal(Goal goal) throws IllegalArgumentException, DAOException;
    public void deleteGoal(Long id) throws DAOException;
    public void editGoal(Long id) throws DAOException;
}
