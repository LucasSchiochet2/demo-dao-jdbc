package db;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static Connection con = null;
    public static Connection getConnection()  {
        if (con == null) {
            Properties prop = loadProperties();
            String url = prop.getProperty("dburl");
            try {
                con = DriverManager.getConnection(url,prop);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return con;
    }
    public static void closeConnection()  {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
    public static Properties loadProperties() {
        try(FileInputStream fis = new FileInputStream("db.properties")) {
            Properties prop = new Properties();
            prop.load(fis);
            return prop;
        }catch(Exception e) {
            throw new DbException(e.getMessage());
        }
    }
    public static void closeStatement(Statement stmt) {
        try{
            stmt.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
    public static void closeResultSet(ResultSet rs) {
        try {
            rs.close();
        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
