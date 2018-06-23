import java.util.*;
import java.sql.*;

public class Validate
{
	public static boolean checkUser(String username,String password) 
	{
		boolean st =false;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/accountsdb?user=accountsdb&password=accountsdb&serverTimezone=UTC&useSSL=false");
			PreparedStatement ps =con.prepareStatement
			("SELECT username,password FROM accounts WHERE username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs =ps.executeQuery();
			st = rs.next();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return st;
	}
}
