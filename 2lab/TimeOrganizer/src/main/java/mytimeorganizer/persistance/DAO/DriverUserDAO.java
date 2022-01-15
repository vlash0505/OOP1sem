package mytimeorganizer.persistance.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverUserDAO {

    private final String url;
    private final String username;
    private final String password;

    public DriverUserDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public UserDAO getUserDAO() {
        return new UserDAOJDBC(this);
    }
}
