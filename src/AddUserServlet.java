package src;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddUserServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String role = request.getParameter("role");
		String email = request.getParameter("email");
		String status = request.getParameter("status");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String date = request.getParameter("date");
		
		if(AddUser.addUser(username, role, email, status, password, repassword, date))
		{
			response.sendRedirect("account.jsp");
		}
		else {
			response.sendRedirect("account.jsp");
		}
	}
}
