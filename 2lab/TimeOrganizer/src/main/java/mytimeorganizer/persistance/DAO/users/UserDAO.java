package mytimeorganizer.persistance.DAO.users;

import mytimeorganizer.models.User;
import mytimeorganizer.persistance.DAO.DAOException;

public interface UserDAO {

    public User findById(Long id) throws DAOException;

    public void addNewUser(User user) throws IllegalArgumentException, DAOException;

    public void deleteExistingUser(User user) throws DAOException;

    public Long existsUser(String username, String password) throws DAOException;
}
