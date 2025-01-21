/**
 * 
 */
package utils;

import java.sql.*;

/**
 * 
 */
public class DbConnectionManager {

	private static DbConnectionManager instance;
    private Connection connection;
	
	private static final String URL = "jdbc:mysql://localhost:3306/ecole?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static DbConnectionManager getInstance() {
        if (instance == null) {
            instance = new DbConnectionManager();
        }
        return instance;
    }

    public static Connection getConnection(){
//        return DriverManager.getConnection(URL, USER, PASSWORD);
    	try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
