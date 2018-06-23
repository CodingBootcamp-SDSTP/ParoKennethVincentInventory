package src;
import java.sql.*;

public class AddUser
{
	public static boolean addUser(String username, String role, String email, String status, String password, String repassword, String date) 
	{
		boolean st = false;
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/accountsdb?user=accountsdb&password=accountsdb&serverTimezone=UTC&useSSL=false");
			ps = con.prepareStatement("INSERT INTO accounts (username, role, email, status, password, repassword, date) VALUES ( ?, ?, ?, ?, ?, ?, ? );");
			ps.setString(1, username);
			ps.setString(2, role);
			ps.setString(3, email);
			ps.setString(4, status);
			ps.setString(5, password);
			ps.setString(6, repassword);
			ps.setString(7, date);
			ps.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try { if (ps != null) ps.close(); } catch (Exception e) {}
		}
		return(st);
	}
}
