import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(Validate.checkUser(username, password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			response.sendRedirect("dashboard.jsp");
		}
		else
		{
		out.println("<span>Username or Password incorrect</span>");
		rs = request.getRequestDispatcher("login.jsp");
		rs.include(request, response);
		rs = request.getRequestDispatcher("login.jsp");
		rs.include(request, response);
		}
	}
}
