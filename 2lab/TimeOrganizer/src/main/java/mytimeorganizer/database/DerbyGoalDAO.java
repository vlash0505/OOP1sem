package mytimeorganizer.database;

import mytimeorganizer.models.Goal;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DerbyGoalDAO implements GoalDAO {
    private Connection connection;
    private QueryRunner dbAccess = new QueryRunner();

    /**
     * Method that initializes the database.
     */

    @Override
    public void setup() {
        try {
            connection = DriverManager.getConnection("jdbc:derby:goals.db;create=true");

            dbAccess.update(connection, "CREATE TABLE Goals ("
                    + "uniqueID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "name VARCHAR(30), authors VARCHAR(100), publishedYear INTEGER, available BOOLEAN"
                    + ")"
            );
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method establishes connection with the database.
     */

    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:derby:goals.db");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that closes the connection with the database.
     */

    @Override
    public void close() {
        try {
            connection.close();
            DriverManager.getConnection("jdbc:derby:books.db;shutdown=true");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that updates goal instance in the database.
     *
     * @param   goal instance to be inserted
     * @return  id of the newly created instance,
     *          -1 if process failed.
     */

    @Override
    public long insertGoal(Goal goal) {
        try {
            return dbAccess.insert(
                    connection, "INSERT INTO Goals (type, description, isCompleted) " +
                                    "VALUES (?, ?, ?)",
                    new ScalarHandler<BigDecimal>(), goal.getType(),
                                                     goal.getDescription(),
                                                     goal.isDone()
            ).longValue();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1L;
    }

    /**
     * Method that updates goal instance in the database.
     *
     * @param   goal instance to be updated.
     *
     * @return  true if it was updated successfully,
     *          false otherwise.
     */

    @Override
    public boolean updateGoal(Goal goal) {
        try {
            dbAccess.update(connection, "UPDATE Goals " +
                                            "SET type=?, description=?, " +
                                            "isCompleted=? " +
                                            "WHERE uniqueID=?",
                    goal.getType(), goal.getDescription(), goal.isDone(), goal.getUniqueID()
            );
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method that deletes goal instance in the database.
     *
     * @param   goal instance to be deleted
     * @return  true if it was deleted successfully,
     *          false otherwise.
     */

    @Override
    public boolean deleteGoal(Goal goal) {
        try {
            dbAccess.update(connection, "DELETE FROM Goals WHERE uniqueID=?", goal.getUniqueID());
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method that finds instances in the database by the
     * specified property.
     *
     * @param searchType specified property
     * @param value      property value
     *
     * @return           List of the instances found by specified
     *                   property.
     */

    @Override
    public List<Goal> findGoalByProperty(GoalSearchType searchType, Object value) {
        return null;
    }

    /**
     * Method that finds all goal instances in the database.
     *
     * @return list of all instances.
     */

    @Override
    public List<Goal> findAll() {
        try {
            return dbAccess.query(connection, "SELECT * FROM Goals", new BeanListHandler<>(Goal.class));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
