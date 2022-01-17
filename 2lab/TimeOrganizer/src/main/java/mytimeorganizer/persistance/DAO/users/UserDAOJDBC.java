package mytimeorganizer.persistance.DAO.users;

import mytimeorganizer.models.User;
import mytimeorganizer.persistance.DAO.DAOException;

import java.sql.*;

public class UserDAOJDBC implements UserDAO {

    private static final String SQL_FIND_USER_BY_ID_QUERY =
            "SELECT id, email, username FROM users WHERE id = ?";

    private static final String SQL_INSERT_USER_QUERY =
            "INSERT INTO users (email, username, password) VALUES (?, ?, ?)";

    private static final String SQL_DELETE_USER_QUERY =
            "DELETE FROM users WHERE id = ?";

    private static final String SQL_USER_EXISTS_QUERY =
            "SELECT id FROM users WHERE username = ? AND password = ?";

    private final DriverUserDAO driverUserDAO;

    public UserDAOJDBC(DriverUserDAO driverUserDAO) {
        this.driverUserDAO = driverUserDAO;
    }

    @Override
    public User findById(Long id) throws DAOException {
        return findByProperty(SQL_FIND_USER_BY_ID_QUERY, id);
    }

    private User findByProperty(String sqlQuery, Object... values) throws DAOException {
        User user = null;

        try (
                Connection connection = driverUserDAO.getConnection();
                PreparedStatement statement = prepareStatement(connection, sqlQuery, false, values);
                ResultSet resultSet = statement.executeQuery()
        ) {
            if (resultSet.next()) {
                user = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return user;
    }

    @Override
    public void addNewUser(User user) throws IllegalArgumentException, DAOException {
        if (user.getId() != null) {
            throw new IllegalArgumentException("User is already created, the user ID is not null.");
        }

        Object[] values = {
                user.getEmail(),
                user.getUsername(),
                user.getPassword()
        };

        try (
                Connection connection = driverUserDAO.getConnection();
                PreparedStatement statement = prepareStatement(connection, SQL_INSERT_USER_QUERY, true, values)
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                } else {
                    throw new DAOException("Creating user failed, no generated key obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteExistingUser(User user) throws DAOException {

        Object[] values = {
                user.getId()
        };

        try (
                Connection connection = driverUserDAO.getConnection();
                PreparedStatement statement = prepareStatement(connection, SQL_DELETE_USER_QUERY, false, values)
        ) {
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("Deleting user failed, no rows affected.");
            } else {
                user.setId(null);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public Long existsUser(String username, String password) throws DAOException {
        Object[] values = {
                username,
                password
        };
        Long id = null;
        try (
                Connection connection = driverUserDAO.getConnection();
                PreparedStatement statement = prepareStatement(connection, SQL_USER_EXISTS_QUERY, false, values);
                ResultSet resultSet = statement.executeQuery()
        ) {
            if(resultSet.next()) {
                id = resultSet.getLong("id");
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return id;
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

    private static User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setEmail(resultSet.getString("email"));
        user.setUsername(resultSet.getString("username"));
        return user;
    }
}
