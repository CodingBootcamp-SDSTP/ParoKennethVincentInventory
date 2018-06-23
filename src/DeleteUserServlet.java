package src;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DeleteUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String userid = request.getParameter("userid");
		if(DeleteUser.deleteUser(userid))
		{
			out.println("Successfully Deleted");
		}
		else {
			response.sendRedirect("account.jsp");
		}
	}
}
