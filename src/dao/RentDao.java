package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbConnection;
import domain.Stock;

public class RentDao
{
	public boolean addGoods(Stock stock)
	{
		PreparedStatement prepareStatement = null;
        try{   
            String sql = "insert into stock(userName,`name`,path,`function`,price,state) values(?,?,?,?,?,?)";
            Connection conn = DbConnection.getConnection();
            prepareStatement = conn.prepareStatement(sql);
           
            prepareStatement.setString(1, stock.getUserName());
			prepareStatement.setString(2, stock.getName());
			prepareStatement.setString(3, stock.getPath());
			prepareStatement.setString(4, stock.getFunction());
			prepareStatement.setDouble(5, stock.getPrice());
			prepareStatement.setInt(6, stock.getState());
                 
            int num = prepareStatement.executeUpdate();
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
	public List<Stock> getGoods(String userName)
	{
		
		Connection connection = DbConnection.getConnection();
		PreparedStatement prepareStatement = null;
		String sql = "select * from stock where userName = ?;";
		List<Stock> list = new ArrayList<Stock>();
		try{
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, userName);
			ResultSet rs = prepareStatement.executeQuery();
			
			while(rs.next()){
					Stock stock = new Stock();
					stock.setPath(rs.getString("path"));
					stock.setUserName(rs.getString("userName"));
					stock.setName(rs.getString("name"));
					stock.setGoodsId(Integer.toString(rs.getInt("goodsId")));
					stock.setFunction(rs.getString("function"));
					stock.setPrice(rs.getDouble("price"));
					stock.setState(rs.getInt("state"));
					list.add(stock);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try{
				prepareStatement.close();
				connection.close();
			} 
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public boolean deleteGoods(String goodsId)
	{
		String sql = "delete from stock where goodsId = ?;";
		boolean flag = false;
		Connection connection = DbConnection.getConnection();
		PreparedStatement prepareStatement = null;
		
		try
		{
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, Integer.parseInt(goodsId));		
			
			if(prepareStatement.executeUpdate() == 1){
				flag = true;
			}
			else{
				flag = false;
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try{
				prepareStatement.close();
				connection.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return flag;
	}
}
