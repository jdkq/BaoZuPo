package domain;


public class Lease
{
	private int orderId;
	private int goodsId;
	private String name;
	private int days;
	private double total;
	private int state;
	private String userName;
	private String time;
	private String path;
	
	
	
	public Lease()
	{
		super();
	}

	public Lease(int orderId, int goodsId, String name, int days, double total, int state, String userName, String time,
			String path)
	{
		super();
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.name = name;
		this.days = days;
		this.total = total;
		this.state = state;
		this.userName = userName;
		this.time = time;
		this.path = path;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}




	public String getTime()
	{
		return time;
	}


	public void setTime(String time)
	{
		this.time = time;
	}
	public int getOrderId()
	{
		return orderId;
	}

	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getDays()
	{
		return days;
	}

	public void setDays(int days)
	{
		this.days = days;
	}

	public double getTotal()
	{
		return total;
	}

	public void setTotal(double total)
	{
		this.total = total;
	}

	public int getState()
	{
		return state;
	}

	public void setState(int state)
	{
		this.state = state;
	}


	public int getGoodsId()
	{
		return goodsId;
	}


	public void setGoodsId(int goodsId)
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
	
	

}
