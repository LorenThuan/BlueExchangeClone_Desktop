package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConectDatabaseHDSD {
	public static Connection con = null;
	private static ConectDatabaseHDSD instance = new ConectDatabaseHDSD();
	
	public static ConectDatabaseHDSD getInstance() {
		return instance;
	}
	
	public void connect()  {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String URL="jdbc:sqlserver://localhost:1433;databaseName=HDSD";
			con = DriverManager.getConnection(URL, "sa", "123456");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void disconnect() {
		if(con != null) {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection() {
		return con;
	}
}