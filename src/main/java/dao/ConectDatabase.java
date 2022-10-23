package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConectDatabase {
	public static Connection con = null;
	private static ConectDatabase instance = new ConectDatabase();
	
	public static ConectDatabase getInstance() {
		return instance;
	}
	
	public void connect()  {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String URL="jdbc:sqlserver://localhost:1433;databaseName=QuanLyCuaHangQuaoAoTHEBLUES";
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