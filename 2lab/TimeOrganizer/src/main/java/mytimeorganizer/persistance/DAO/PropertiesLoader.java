package mytimeorganizer.persistance.DAO;

public class PropertiesLoader {
    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD = "password";

    public static DriverUserDAO getDriverUserDAOInstance() {
        DAOProperties properties = new DAOProperties("javabase.jdbc");
        String url = properties.getProperty(PROPERTY_URL, true);
        String driverClassName = properties.getProperty(PROPERTY_DRIVER, false);
        String password = properties.getProperty(PROPERTY_PASSWORD, false);
        String username = properties.getProperty(PROPERTY_USERNAME, password != null);

        return new DriverUserDAO(url, username, password);
    }
}
