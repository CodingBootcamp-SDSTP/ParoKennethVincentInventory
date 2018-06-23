package src;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class AccountsListDatabase
{
	Connection connection = null;
	private AccountCollection accounts;
	private InventoryCollection inventories;

	public AccountsListDatabase() {
		accounts = new AccountCollection();
		inventories = new InventoryCollection();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/accountsdb?user=accountsdb&password=accountsdb&serverTimezone=UTC&useSSL=false");
			readFromSQL();
		}
		catch(Exception e) {
		e.printStackTrace();
		}
	}

	public boolean readFromSQL() {
		Statement statement = null;
		ResultSet rs = null;
		boolean v = false;
		try {
			statement=connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM accounts");
			while(rs.next()){
				Account account = new Account(rs);
				account.setId(rs.getInt("id"));
				account.setUsername(rs.getString("username"));
				account.setEmail(rs.getString("email"));
				account.setRole(rs.getString("role"));
				account.setStatus(rs.getString("status"));
				account.setDate(rs.getString("date"));
				accounts.addAccount(account);
			}
			rs = statement.executeQuery("SELECT * FROM inventory");
			while(rs.next()){
				Inventory inventory = new Inventory(rs);
				inventory.setListPrice(rs.getInt("list_price"));
				inventory.setSalePrice(rs.getInt("sale_price"));
				inventory.setHouseType(rs.getString("house_type"));
				inventory.setLotArea(rs.getInt("lot_area"));
				inventory.setBedroom(rs.getInt("bedroom"));
				inventory.setToilet(rs.getInt("toilet"));
				inventory.setCarport(rs.getString("carport"));
				inventory.setBalcony(rs.getString("balcony"));
				inventory.setAvailable(rs.getInt("available"));
				inventories.addInventory(inventory);
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if (rs != null) rs.close(); } catch (Exception e) {};
			try { if (statement != null) statement.close(); } catch (Exception e) {}
		}
		return(v);
	}

	public AccountCollection getAccountCollection() {
		return(accounts);
	}

	public InventoryCollection getInventoryCollection() {
		return(inventories);
	}
}
