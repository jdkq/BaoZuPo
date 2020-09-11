package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbConnection;
import domain.Lease;
import domain.Stock;

public class LeaseDao
{

	public boolean editLeaseState(int orderId, int state)
	{
		String sql = "update lease set state = ? where orderId = ?;";
		boolean flag = false;
		Connection connection = DbConnection.getConnection();
		PreparedStatement prepareStatement = null;
		
		try
		{
			prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setInt(1, state);
			prepareStatement.setInt(2, orderId);
			int i = prepareStatement.executeUpdate();
			
			if(i == 1)
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
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
		
		return flag;
	}
	
	
	public boolean editStockState(int goodsId, int state)
	{
		String sql = "update stock set state = ? where goodsId = ?;";
		boolean flag = false;
		Connection connection = DbConnection.getConnection();
		PreparedStatement prepareStatement = null;
		
		try
		{
			prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setInt(1, state);
			prepareStatement.setInt(2, goodsId);
			int i = prepareStatement.executeUpdate();
			
			if(i == 1)
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
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
		
		return flag;
	}

	public boolean leaseGoods(String userName, int days, String goodsId)
	{
		
		
		PreparedStatement prepareStatement = null;
        try{   
        	String sql = "insert into lease(userName, goodsId, days, total, state) values(?,?,?,?,?)";
            Connection conn = DbConnection.getConnection();
            prepareStatement = conn.prepareStatement(sql);
           
            prepareStatement.setString(1, userName);
			prepareStatement.setInt(2, Integer.parseInt(goodsId));
			prepareStatement.setInt(3, days);
			prepareStatement.setDouble(4, days * byGoodsID(goodsId).getPrice());
			prepareStatement.setInt(5, 3);
                 
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
	public List<Lease> getOrders(String userName)
	{
		
		Connection connection = DbConnection.getConnection();
		PreparedStatement prepareStatement = null;
		String sql = "select * from lease where userName = ?;";
		List<Lease> list = new ArrayList<Lease>();
		try{
			
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, userName);
			ResultSet rs = prepareStatement.executeQuery();
			
			while(rs.next()){
					Lease lease = new Lease();
					
					String date = rs.getTimestamp("time").toString();
					lease.setTime(date);
					lease.setDays(rs.getInt("days"));
					lease.setGoodsId(rs.getInt("goodsId"));
					String name = byGoodsID(Integer.toString(rs.getInt("goodsId"))).getName();
					if(name == null)
					{
						name = "该商品已被删除";
					}
					lease.setName(name);
					lease.setOrderId(rs.getInt("orderId"));
					lease.setState(rs.getInt("state"));
					lease.setTotal(rs.getDouble("total"));
					list.add(lease);
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
	public List<Stock> getGoods()
	{
		
		Connection connection = DbConnection.getConnection();
		PreparedStatement prepareStatement = null;
		String sql = "select * from stock where state = 2;";
		List<Stock> list = new ArrayList<Stock>();
		try{
			prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
			while(rs.next()){
					Stock stock = new Stock();
					stock.setPath(rs.getString("path"));
					stock.setUserName(rs.getString("userName"));
					stock.setName(rs.getString("name"));
					stock.setGoodsId(Integer.toString(rs.getInt("goodsId")));
					stock.setFunction(rs.getString("function"));
					stock.setPrice(rs.getDouble("price"));
					
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
	
	public Stock byGoodsID(String goodsID)
	{
		Connection connection = DbConnection.getConnection();
		PreparedStatement prepareStatement = null;
		String sql = "select * from stock where goodsId = ?;";
		Stock stock = new Stock();
		try{
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, Integer.parseInt(goodsID));
			ResultSet rs = prepareStatement.executeQuery();
			
			while(rs.next()){
				stock.setUserName(rs.getString("userName"));
				stock.setName(rs.getString("name"));
				stock.setGoodsId(Integer.toString(rs.getInt("goodsId")));
				stock.setFunction(rs.getString("function"));
				stock.setPrice(rs.getDouble("price"));
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try{
				prepareStatement.close();
				connection.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return stock;
	}
	
}
