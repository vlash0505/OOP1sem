package mytimeorganizer.persistance.DAO.tasks;

import mytimeorganizer.models.Goal;
import mytimeorganizer.models.Task;
import mytimeorganizer.persistance.DAO.DAOException;
import mytimeorganizer.persistance.DAO.DAOUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class TaskDAOJDBC implements TaskDAO {

    private static final String SQL_INSERT_TASK_QUERY =
            "INSERT INTO tasks (date, description, is_completed, user_id) VALUES (?, ?, false, ?)";

    private static final String SQL_SELECT_UNCOMPLETED_BY_DATE_AND_USER_ID_ORDER_BY_ID_QUERY =
            "SELECT * FROM tasks WHERE user_id = ? AND date = ? AND is_completed = false ORDER BY id";

    private static final String SQL_SELECT_COMPLETED_BY_TYPE_AND_USER_ID_ORDER_BY_ID_QUERY =
            "SELECT * FROM tasks WHERE user_id = ? AND date = ? AND is_completed = true ORDER BY id";

    private static final String SQL_MAKE_TASK_COMPLETED_QUERY =
            "UPDATE tasks SET is_completed = true WHERE id = ?";

    private static final String SQL_MAKE_TASK_UNCOMPLETED_QUERY =
            "UPDATE tasks SET is_completed = false WHERE id = ?";



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
        if (task.getId() != null) {
            throw new IllegalArgumentException("Task is already created, the task ID is not null.");
        }

        Object[] values = {
                task.getDate(),
                task.getDescription(),
                Goal.USER_ID
        };

        try (
                Connection connection = driverTaskDAO.getConnection();
                PreparedStatement statement = DAOUtils.prepareStatement(connection, SQL_INSERT_TASK_QUERY, true, values)
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Creating task failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    task.setId(generatedKeys.getLong(1));
                } else {
                    throw new DAOException("Creating task failed, no generated key obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Task> findAllTasks() {
        return null;
    }

    @Override
    public List<Task> findByDateAndUserID(LocalDate date, Long userId) {
        List<Task> tasks = new ArrayList<>();
        try (
                var connection = driverTaskDAO.getConnection();
                PreparedStatement statement = DAOUtils.prepareStatement(connection, SQL_SELECT_UNCOMPLETED_BY_DATE_AND_USER_ID_ORDER_BY_ID_QUERY, true, userId, DAOUtils.toSqlDate(date));
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                tasks.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return tasks;
    }

    @Override
    public void deleteExistingTask(Task task) throws DAOException {

    }

    private static Task map(ResultSet resultSet) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getLong("id"));
        task.setDate(Date.valueOf(String.valueOf(resultSet.getDate("date"))).toLocalDate());
        task.setDescription(resultSet.getString("description"));
        return task;
    }
}
