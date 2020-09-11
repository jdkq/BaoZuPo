package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection
{
	private static String url = "jdbc:mysql://localhost:3306/chuzupo?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
	private static String user = "root";
	private static String pw = "234523";
	
	public static Connection getConnection()
	{
		Connection connection = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pw);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException();
		}
		return connection;
	}

}
