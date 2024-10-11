package Entity;

public class Customer {
	
	
	private String name;
	private String customerId;
	
	public Customer (String name, String customerId)
	{
		
		this.name=name;
		this.customerId=customerId;
		
	}
	
	public String getName()
	{
		
		return name;
		
	}
	public String getId()
	{
		
		return customerId;
		
	}
	
	public String toString()
	{
		
		return "Customer:" + name +"(" + customerId +")";
		
	}
	
		

	}
