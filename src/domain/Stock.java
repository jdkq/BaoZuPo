package domain;

public class Stock
{
	private String goodsId;
	private String userName;
	private String name;
	private String function;
	private double price;
	private int state;
	private String path;
	
	
	
	public Stock()
	{
	}

	
	
	public Stock(String goodsId, String userName, String name, String function, double price, int state, String path)
	{
		super();
		this.goodsId = goodsId;
		this.userName = userName;
		this.name = name;
		this.function = function;
		this.price = price;
		this.state = state;
		this.path = path;
	}



	public String getGoodsId()
	{
		return goodsId;
	}
	public void setGoodsId(String goodsId)
	{
		this.goodsId = goodsId;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getFunction()
	{
		return function;
	}
	public void setFunction(String function)
	{
		this.function = function;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public int getState()
	{
		return state;
	}
	public void setState(int state)
	{
		this.state = state;
	}



	public String getPath()
	{
		return path;
	}



	public void setPath(String path)
	{
		this.path = path;
	}
	
	
	
}
