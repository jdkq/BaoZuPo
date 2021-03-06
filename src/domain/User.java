package domain;


public class User {
	
    private String userName;
    private String password;
    private String name;
    private String address;
    private int type;
    
	public User()
	{
	}

	public User(String userName, String password, String name, String address, int type)
	{
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.address = address;
		this.type = type;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
	
}
