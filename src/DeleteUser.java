package src;
import java.sql.*;

public class DeleteUser
{
	public static boolean deleteUser(String userid) 
	{
		boolean st = false;
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/accountsdb?user=accountsdb&password=accountsdb&serverTimezone=UTC&useSSL=false");
			ps = con.prepareStatement("DELETE FROM accounts WHERE id = ? ");
			ps.setString(1, userid);
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
