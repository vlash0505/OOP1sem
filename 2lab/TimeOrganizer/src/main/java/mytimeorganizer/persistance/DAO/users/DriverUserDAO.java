package mytimeorganizer.persistance.DAO.users;

import mytimeorganizer.persistance.DAO.DriverDAO;
import mytimeorganizer.persistance.DAO.users.UserDAO;
import mytimeorganizer.persistance.DAO.users.UserDAOJDBC;

public class DriverUserDAO extends DriverDAO {

    public DriverUserDAO(String url, String username, String password) {
        super(url, username, password);
    }

    public UserDAO getUserDAO() {
        return new UserDAOJDBC(this);
    }
}
