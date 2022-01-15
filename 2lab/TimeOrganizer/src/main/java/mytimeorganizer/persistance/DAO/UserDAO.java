package mytimeorganizer.persistance.DAO;

import mytimeorganizer.models.User;

public interface UserDAO {

    public User findById(Long id) throws DAOException;

    public void addNewUser(User user) throws IllegalArgumentException, DAOException;

    public void deleteExistingUser(User user) throws DAOException;

    public boolean existsUser(String username, String password) throws DAOException;
}
