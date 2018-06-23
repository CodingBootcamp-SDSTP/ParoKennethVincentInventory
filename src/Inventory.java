package src;
import java.util.*;
import java.sql.*;
public class Inventory
{
	private int list_price;
	private int sale_price;
	private String house_type;
	private int lot_area;
	private int bedroom;
	private int toilet;
	private String carport;
	private String balcony;
	private int available;
	
	public void setListPrice(int list_price) 
	{
		this.list_price = list_price;
	}

	public int getListPrice()
	{
		return (this.list_price);
	}
	
	public void setSalePrice(int sale_price) 
	{
		this.sale_price = sale_price;
	}

	public int getSaleprice()
	{
		return (this.sale_price);
	}

	public void setHouseType(String house_type) 
	{
		this.house_type = house_type;
	}

	public String getHouseType() 
	{ 
		return (this.house_type);
	}

	public void setLotArea(int lot_area) 
	{
		this.lot_area = lot_area;
	}

	public int getLotArea() 
	{ 
		return (this.lot_area);
	}
	
	public void setBedroom(int bedroom) 
	{
		this.bedroom = bedroom;
	}

	public int getBedroom() 
	{ 
		return (this.bedroom);
	}

	public void setToilet(int toilet) 
	{
		this.toilet = toilet;
	}

	public int getToilet() 
	{ 
		return (this.toilet);
	}

	public void setCarport(String carport) 
	{
		this.carport = carport;
	}

	public String getCarport() 
	{ 
		return (this.carport);
	}

	public void setBalcony(String balcony) 
	{
		this.balcony = balcony;
	}

	public String getBalcony() 
	{ 
		return (this.balcony);
	}

	public void setAvailable(int available) 
	{
		this.available = available;
	}

	public int getAvailable() 
	{ 
		return (this.available);
	}

	public Inventory (ResultSet resultSet) throws SQLException
	{
		this.list_price = resultSet.getInt("list_price");
		this.sale_price = resultSet.getInt("sale_price");
		this.house_type = resultSet.getString("house_type");
		this.lot_area = resultSet.getInt("lot_area");
		this.bedroom = resultSet.getInt("bedroom");
		this.toilet = resultSet.getInt("toilet");
		this.carport = resultSet.getString("carport");
		this.balcony = resultSet.getString("balcony");
		this.available = resultSet.getInt("available");
	}
}
