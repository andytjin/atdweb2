/*
 * Licsense Header
 */

package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Max
 */
public abstract class BaseDAO<T> {

    static final String DB_URL = "jdbc:mysql://localhost:3306/to4";
    static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_USERNAME = "root";
    static final String DB_PASSWORD = "";
    
    protected final Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    static {
        try {
            Class.forName(DB_DRIVER).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public abstract void create(T instance);
    
    public abstract void delete(T instance);
    
    public abstract void change(T instance, T newInstance);
    
    public abstract List<T> getAll();
}
