package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DbConnection;
import domain.User;

public class UserDao {
	
	Connection conn=DbConnection.getConnection();

	
	public User findUserByUsernameAndPwd(String u, String p, int type) {
		
		String sql = "select * from users where username = ? and password = ? and type = ?;";
		User user = new User();
		Connection connection = DbConnection.getConnection();
		PreparedStatement prepareStatement = null;
		
		try
		{
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, u);
			prepareStatement.setString(2, p);
			prepareStatement.setInt(3, type);
			ResultSet rs = prepareStatement.executeQuery();
			
			if(rs.next())
			{
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			else
			{
				return null;
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		finally 
		{
			try
			{
				prepareStatement.close();
				connection.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public User adminLogin(String u, String p) {
		
		String sql = "select * from admin where username = ? and password = ?;";
		User user = new User();
		Connection connection = DbConnection.getConnection();
		PreparedStatement prepareStatement = null;
		
		try
		{
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, u);
			prepareStatement.setString(2, p);
			ResultSet rs = prepareStatement.executeQuery();
			
			if(rs.next())
			{
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			else
			{
				return null;
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		finally 
		{
			try
			{
				prepareStatement.close();
				connection.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public boolean addUser(User u) {
		
		PreparedStatement st = null;
        try{   
            String sql = "insert into users(username,password,name,address,type) values(?,?,?,?,?)";
           
            st = conn.prepareStatement(sql);
           

          
            st.setString(1, u.getUserName());
            st.setString(2, u.getPassword());
            st.setString(3, u.getName());
            st.setString(4, u.getAddress());
            st.setInt(5, u.getType());
            
            
            int num = st.executeUpdate();
            if(num>0){
               return true;
            }
            else {
				return false;
			}
            
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

	}

}
