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

public class AdminDao
{
	public List<Lease> getOrders()
	{
		
		Connection connection = DbConnection.getConnection();
		PreparedStatement prepareStatement = null;
		String sql = "select * from lease where state = 4;";
		List<Lease> list = new ArrayList<Lease>();
		try{
			
			prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
			while(rs.next()){
					Lease lease = new Lease();
					lease.setDays(rs.getInt("days"));
					lease.setGoodsId(rs.getInt("goodsId"));
					lease.setOrderId(rs.getInt("orderId"));
					lease.setState(rs.getInt("state"));
					lease.setTotal(rs.getDouble("total"));
					lease.setUserName(rs.getString("userName"));
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
		String sql = "select * from stock where state = 1;";
		List<Stock> list = new ArrayList<Stock>();
		try{
			prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
			while(rs.next()){
					Stock stock = new Stock();
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
}
