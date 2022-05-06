package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class customConnection {

	public static String url = "jdbc:postgresql://"+System.getenv("my_DB_EndPoint")+"/project1";
	public static String username = System.getenv("my_Db_User");
	public static String password = System.getenv("my_Db_Password");
	
	static { //(this would normally go into your dao layer)
	      try {
	          Class.forName("org.postgresql.Driver");
	      }catch(ClassNotFoundException e) {
	          e.printStackTrace();
	          System.out.println("Static block has failed me");
	      }
	}
	

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
