package mytimeorganizer.persistance.DAO.goals;

import mytimeorganizer.models.Goal;
import mytimeorganizer.persistance.DAO.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoalDAOJDBC implements GoalDAO {

    private static final String SQL_INSERT_GOAL_QUERY =
            "INSERT INTO goals (type, description, is_completed, user_id) VALUES (?, ?, false, ?)";

    private static final String SQL_ORDER_GOALS_BY_ID =
            "SELECT * FROM goals WHERE user_id = ? AND type = ? AND is_completed = false ORDER BY id";

    private final DriverGoalDAO driverGoalDAO;

    public GoalDAOJDBC(DriverGoalDAO driverGoalDAO) {
        this.driverGoalDAO = driverGoalDAO;
    }


    @Override
    public Goal findByID(Long id) throws DAOException {
        return null;
    }

    @Override
    public List<Goal> findAll() throws DAOException {
        return new ArrayList<>();
    }

    @Override
    public List<Goal> findByTypeAndUserId(Long ID, String type) throws DAOException {
        List<Goal> goals = new ArrayList<>();

        Object[] values = {
                ID,
                type
        };

        try (
                Connection connection = driverGoalDAO.getConnection();
                PreparedStatement statement = prepareStatement(connection, SQL_ORDER_GOALS_BY_ID, true, values);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                goals.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return goals;
    }

    @Override
    public List<Goal> findNotCompleted() throws DAOException {
        return null;
    }

    @Override
    public void addGoal(Goal goal) throws IllegalArgumentException, DAOException {
        if (goal.getId() != null) {
            throw new IllegalArgumentException("Goal is already created, the goal ID is not null.");
        }

        Object[] values = {
                goal.getType(),
                goal.getDescription(),
                Goal.USER_ID
        };

        try (
                Connection connection = driverGoalDAO.getConnection();
                PreparedStatement statement = prepareStatement(connection, SQL_INSERT_GOAL_QUERY, true, values)
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Creating goal failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    goal.setId(generatedKeys.getLong(1));
                } else {
                    throw new DAOException("Creating goal failed, no generated key obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteGoal(Long id) throws DAOException {

    }

    @Override
    public void editGoal(Long id) throws DAOException {

    }

    public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            statement.setObject(i + 1, values[i]);
        }
    }

    public static PreparedStatement prepareStatement
            (Connection connection, String sql, boolean returnGeneratedKeys, Object... values)
            throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql,
                returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
        setValues(statement, values);
        return statement;
    }

    private static Goal map(ResultSet resultSet) throws SQLException {
        Goal goal = new Goal();
        goal.setId(resultSet.getLong("id"));
        goal.setType(resultSet.getString("type"));
        goal.setDescription(resultSet.getString("description"));
        return goal;
    }
}
