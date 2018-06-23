package src;
import java.util.*;
import java.sql.*;
public class Account
{
	private int id;
	private String username;
	private String email;
	private String role;
	private String status;
	private String date;
	
	public void setId(int id) 
	{
		this.id = id;
	}

	public int getId()
	{
		return (this.id);
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getUsername() 
	{ 
		return (this.username);
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{ 
		return (this.email);
	}
	
	public void setRole(String role) 
	{
		this.role = role;
	}

	public String getRole() 
	{ 
		return (this.role);
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{ 
		return (this.status);
	}

	public void setDate(String date) 
	{
		this.date = date;
	}

	public String getDate() 
	{ 
		return (this.date);
	}

	public Account (ResultSet resultSet) throws SQLException
	{
		this.id = resultSet.getInt("id");
		this.username = resultSet.getString("username");
		this.email = resultSet.getString("email");
		this.role = resultSet.getString("role");
		this.status = resultSet.getString("status");
		this.date = resultSet.getString("date");
	}
}
