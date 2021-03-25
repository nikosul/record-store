package javaweb.part1.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChinookDatabase {
    private static final String URL = "jdbc:sqlite:src/sqlite/Chinook_Sqlite.sqlite";

    public static Connection connect() {
    	Connection connect = null;
    
       try {
    	   Class.forName("org.sqlite.JDBC");
       
       connect = DriverManager.getConnection(URL);
    }catch (SQLException | ClassNotFoundException e) {
    	throw new RuntimeException (e);
    }
       return connect;
    }
	protected static void close(PreparedStatement ps, ResultSet rs, Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected static void close(PreparedStatement ps, Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
