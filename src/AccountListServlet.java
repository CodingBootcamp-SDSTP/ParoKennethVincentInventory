package src;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

public class AccountListServlet extends HttpServlet
{
	AccountCollection ac;

	public void init() throws ServletException {
		AccountsListDatabase ald = new AccountsListDatabase();
		ac = ald.getAccountCollection();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		RequestDispatcher rs = request.getRequestDispatcher("account.jsp");
		rs.include(request, response);
		ArrayList<Account> account = ac.getAllAccounts();
		StringBuilder sb = new StringBuilder("<accounts>");
		for(Account a : account) {
			sb.append("<account><id>" +a.getId() + "</id>");
			sb.append("<username>" + a.getUsername() + "</username>");
			sb.append("<email>" + a.getEmail() + "</email>");
			sb.append("<role>" + a.getRole() + "</role>");
			sb.append("<status>" + a.getStatus() + "</status>");
			sb.append("<date>" + a.getDate() + "</date></account>");
		}
		sb.append("</accounts>");
		out.println(sb.toString());
	}

	public void destroy(){
		ac = null;
	}
}
