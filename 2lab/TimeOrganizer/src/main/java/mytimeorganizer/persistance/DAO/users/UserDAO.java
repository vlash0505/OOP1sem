package mytimeorganizer.persistance.DAO.users;

import mytimeorganizer.models.User;
import mytimeorganizer.persistance.DAO.DAOException;

public interface UserDAO {

    public void addNewUser(User user) throws IllegalArgumentException, DAOException;

    public boolean registrationValidation(String email, String username) throws DAOException;

    public Long existsUser(String username, String password) throws DAOException;
}
